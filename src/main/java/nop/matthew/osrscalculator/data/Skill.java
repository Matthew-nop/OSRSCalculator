package nop.matthew.osrscalculator.data;

import nop.matthew.osrscalculator.net.PriceFetcher;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Skill {
	protected PriceFetcher priceFetcher;
	protected TreeMap<String, Recipe[]> methodRecipes;
	protected String key;
	protected Set<Flags> flags;

	public Skill(PriceFetcher priceFetcher, String key) {
		this.priceFetcher = priceFetcher;
		this.methodRecipes = new TreeMap<>();
		this.key = key;
		this.flags = new HashSet<>();
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

		addTertiaryPrices();
	}

	/*
	Add all items which are not in a recipe, but require prices to be tracked
	 */
	public abstract void addTertiaryPrices();

	public abstract Map<Integer, Float> getRecipeOutCosts(Recipe r);

	public abstract Map<Integer, Float> getRecipeInCosts(Recipe r);

	public Set<String> getMethods() {
		return this.methodRecipes.keySet();
	}

	public Recipe[] getRecipes(String method) {
		return this.methodRecipes.get(method);
	}

	public TreeMap<String, Recipe[]> getMethodRecipes() {
		return this.methodRecipes;
	}

	public String getKey() {
		return this.key;
	}

	public Set<Flags> getFlags() {
		return this.flags;
	}

	public void setFlag(Flags flag) {
		this.flags.add(flag);
	}

	public void unsetFlag(Flags flag) {
		this.flags.remove(flag);
	}
}
