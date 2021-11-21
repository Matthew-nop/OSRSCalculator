/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nop.matthew.osrscalculator.net;

import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ConcurrentHashMap;

public class PriceFetcher {
	private static final String USER_AGENT = "OSRSCalculator";
	private static final String BASE_URL = "https://prices.runescape.wiki/api/v1/osrs/latest";
	private static final int CONNECTION_TIMEOUT_MS = 20000;
	private static final int READ_TIMEOUT_MS = 60000;
	private static final int CONNECTION_RETRY_MAX = 2;

	private static final ConcurrentHashMap<Integer, Float> prices = new ConcurrentHashMap<>();

	/**
	 * Update the current stored item prices
	 *
	 * @throws IOException If either the connection or JSON parsing fails
	 */
	public static void updatePrices() throws IOException {
		JSONObject data = readData(BASE_URL);

		for (Integer id : prices.keySet()) {
			JSONObject jsonObject = null;
			try {
				jsonObject = data.getJSONObject(id.toString());
			} catch (JSONException ignored) {
				System.out.println("itemID: " + id + " was not found with the prices API");
			}

			float price = readPrice(jsonObject);
			System.out.println("itemID: " + id + " price set to " + price);
			prices.put(id, price);
		}
	}

	/**
	 * Immediately fetch the current price of an item
	 *
	 * @param id the item's id
	 * @throws IOException If either the connection or JSON parsing fails
	 */
	public static void fetchID(int id) throws IOException {
		String endpoint = BASE_URL + "?id=" + id;
		JSONObject data = readData(endpoint);
		JSONObject jsonObject = null;
		try {
			jsonObject = data.getJSONObject(String.valueOf(id));
		} catch (JSONException ignored) {
			System.out.println("itemID: " + id + " was not found with the prices API");
		}

		float price = readPrice(jsonObject);
		System.out.println("itemID: " + id + " price set to " + price);
		prices.put(id, readPrice(jsonObject));
	}

	/**
	 * Add an item to start fetching prices for
	 *
	 * @param id the item's id
	 */
	public static void addItem(int id) {
		prices.put(id, 0f);
	}

	/**
	 * Add items to start fetching prices for
	 *
	 * @param ids for these ids, start fetching their prices
	 */
	public static void addItems(int[] ids) {
		for (int id : ids) {
			addItem(id);
		}
	}

	/**
	 * Add the components from a recipe to start fetching prices for
	 *
	 * @param recipe the recipe
	 */
	public static void addRecipe(Recipe recipe) {
		for (ItemQuantity itemQuantity : recipe.getOutput()) {
			prices.put(itemQuantity.getId(), 0f);
		}
		for (ItemQuantity ingredient : recipe.getIngredients()) {
			prices.put(ingredient.getId(), 0f);
		}
	}

	/**
	 * Get the current cached price of an item
	 *
	 * @param id the item's id
	 * @return the price of the item
	 */
	public static Float getPrice(int id) {
		Float price = prices.get(id);
		return price != null ? price : 0;
	}

	private static URLConnection connect(String endpoint) throws IOException {
		URLConnection conn = new URL(endpoint).openConnection();
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setConnectTimeout(CONNECTION_TIMEOUT_MS);
		conn.setReadTimeout(READ_TIMEOUT_MS);
		for (int attempt = 0; attempt < CONNECTION_RETRY_MAX; ++attempt) {
			try {
				System.out.println("Attempting to connect to \"" + conn.getURL().toString() + "\"...");
				conn.connect();
				return conn;
			} catch (IOException e) {
				System.err.println(e + "\nConnection attempt " + (attempt + 1) + " timed out after waiting " + CONNECTION_TIMEOUT_MS + "ms");
			}
		}
		return null;
	}

	private static JSONObject readData(String endpoint) throws IOException {
		URLConnection conn = connect(endpoint);
		if (conn == null)
			throw new IOException("Update attempted with null connection");
		InputStream inputStream = conn.getInputStream();
		if (inputStream == null)
			throw new IOException("Update attempted while collection input stream is null");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}

		return new JSONObject(sb.toString()).getJSONObject("data");
	}

	private static float readPrice(JSONObject item) {
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
			return (high + low) / 2f;
		}
		else {
			// If there's only data for low or high, use that instead of the average
			return (high < 0) ? low : high;
		}
	}
}