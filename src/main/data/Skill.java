package data;

import net.PriceFetcher;

import java.util.Set;
import java.util.TreeMap;

public abstract class Skill {
	protected PriceFetcher priceFetcher;
	protected TreeMap<String, Recipe[]> methodRecipes;

	public Skill(PriceFetcher priceFetcher) {
		this.priceFetcher = priceFetcher;
		this.methodRecipes = new TreeMap<>();
	}

	/*
	Add all items from a skill's recipes to the price fetcher
	 */
	public void addRecipePrices() {
		for (Recipe[] recipes : methodRecipes.values()) {
			for (Recipe recipe : recipes) {
				priceFetcher.addRecipe(recipe);
			}
		}
	}

	public Set<String> getMethods() {
		return this.methodRecipes.keySet();
	}

	public Recipe[] getRecipes(String method) {
		return this.methodRecipes.get(method);
	}

	public TreeMap<String, Recipe[]> getMethodRecipes() {
		return this.methodRecipes;
	}
}
