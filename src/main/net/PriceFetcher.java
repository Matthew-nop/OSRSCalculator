package net;

import data.Item;
import data.Recipe;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class PriceFetcher {
	private static final String baseUrl = "https://prices.runescape.wiki/api/v1/osrs/latest";
	private static final int CONNECTION_TIMEOUT_MS = 20000;
	private static final int READ_TIMEOUT_MS = 60000;
	private static final int CONNECTION_RETRY_MAX = 2;

	private URLConnection conn;
	private String endpoint;
	private HashMap<Integer, Float> prices;

	public PriceFetcher() throws IOException {
		this.prices = new HashMap<Integer, Float>(); // TODO: set an accurate initial size
		this.endpoint = baseUrl;
	}

	public void updatePrices() throws IOException {
		this.endpoint = baseUrl;
		JSONObject data = readData();

		for (Integer id : prices.keySet()) {
			JSONObject item = null;
			try {
				 item = data.getJSONObject(id.toString());
			} catch (JSONException ignored) {}
			float price = readPrice(item);
			System.out.println("Fetched price of " + price + " for item id " + id);
			prices.put(id, price);
		}
	}

	// Avoid repeatedly calling fetchID to minimise API requests
	public void fetchID(int id) throws IOException {
		this.endpoint = baseUrl + "?id=" + id;
		JSONObject data = readData();

		JSONObject item = data.getJSONObject("id");

		float price = readPrice(data.getJSONObject("id"));
		System.out.println("Fetched price of " + price + " for item id " + id);
		prices.put(id, price);
	}

	public void addItem(int id, float price) {
		prices.put(id, price);
	}

	public void addItem(int id) {
		addItem(id, 0f);
	}

	public void addItems(int[] ids) {
		for (int id : ids) {
			addItem(id);
		}
	}

	public void addRecipe(Recipe recipe) {
		for (int id : recipe.getOutput()) {
			prices.put(id, 0f);
		}
		for (Item ingredient : recipe.getIngredients()) {
			prices.put(ingredient.getId(), 0f);
		}
	}

	public Float getPrice(int id) {
		return prices.get(id);
	}

	public HashMap<Integer, Float> getPrices() {
		return this.prices;
	}

	private int connect() throws IOException {
		return connect(0);
	}

	private int connect(int attempt) throws IOException  {
		this.conn = new URL(endpoint).openConnection();
		this.conn.setRequestProperty("User-Agent", "OSRSCalculator");
		this.conn.setConnectTimeout(CONNECTION_TIMEOUT_MS);
		this.conn.setReadTimeout(READ_TIMEOUT_MS);
		try {
			System.out.println("Attempting to connect to \"" + this.conn.getURL().toString() + "\"...");
			conn.connect();
			return attempt;
		} catch (IOException e) {
			System.err.println(e + "\nConnection attempt " + (attempt + 1) + " timed out after waiting " + CONNECTION_TIMEOUT_MS + "ms");
			return attempt >= CONNECTION_RETRY_MAX ? -1 : connect(attempt++);
		}
	}

	private JSONObject readData() throws IOException {
		connect();
		InputStream inputStream = this.conn.getInputStream();
		if (this.conn == null || inputStream == null)
			throw new IOException("Update attempted  with null connection or connection input stream");

		BufferedReader in = new BufferedReader(new InputStreamReader(this.conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}

		JSONObject data = new JSONObject(sb.toString()).getJSONObject("data");
		return data;
	}

	private float readPrice(JSONObject item) {
		// If the item isn't traded, let the price equal 0
		if (item == null)
			return 0;

		int high, low;
		try {
			high = item.getInt("high");
		} catch (JSONException e) {
			System.out.println("High price for item not found");
			high = -1;
		}
		try {
			low = item.getInt("low");
		} catch (JSONException e) {
			System.out.println("Low price for item not found");
			low = -1;
		}

		if (high >= 0 && low >= 0) {
			// Return the average of the low and high prices
			return (high + low)/2f;
		} else {
			// If there's only data for low or high, use it instead of the average
			return (high < 0) ? low : high;
		}
	}
}