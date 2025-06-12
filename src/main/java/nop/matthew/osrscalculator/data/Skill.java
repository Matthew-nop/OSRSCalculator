package nop.matthew.osrscalculator.data;

import nop.matthew.osrscalculator.net.PriceFetcher;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Skill {
	protected Skills skills;
	protected PriceFetcher priceFetcher;
	protected TreeMap<Methods, Recipe[]> methodRecipes;
	protected Set<Flags> flags;


	public Skill(Skills skills, PriceFetcher priceFetcher) {
		this.skills = skills;
		this.priceFetcher = priceFetcher;
		this.methodRecipes = new TreeMap<>();
		this.flags = new HashSet<>();
	}

	/**
	 * Add all items from a skill's recipes to the price fetcher
	 */
	public void addRecipePrices() {
		for (Recipe[] recipes : methodRecipes.values()) {
			for (Recipe recipe : recipes) {
				priceFetcher.addRecipe(recipe);
			}
		}

		addTertiaryPrices();
	}

	/**
	 * Add all items which are not in a recipe, but require prices to be tracked
	 */
	protected abstract void addTertiaryPrices();

	/**
	 * Get a map of (ItemID -> total cost) for recipe outputs
	 *
	 * @param recipe the recipe
	 * @return the map of costs
	 */
	public Map<Integer, Float> getRecipeOutCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<Integer, Float>();
		ItemQuantity[] outputs = recipe.getOutput();

		for (ItemQuantity item : outputs) {
			int id = item.getId();
			costs.put(id, priceFetcher.getPrice(id) * item.getQuantity());
		}

		return costs;
	}

	/**
	 * Returns the xp gained per the  given recipe's action
	 *
	 * @param recipe the recipe
	 * @return The xp gained
	 */
	public double getXp(Recipe recipe) {
		return recipe.getXp();
	}

	/**
	 * Get a map of (ItemID -> total cost) for recipe inputs
	 *
	 * @param recipe the recipe
	 * @return the map of costs
	 */
	public Map<Integer, Float> getRecipeInCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<Integer, Float>();

		for (ItemQuantity item : recipe.getIngredients()) {
			int id = item.getId();
			costs.put(id, priceFetcher.getPrice(id) * item.getQuantity());
		}

		return costs;
	}

	public URL getIconPath() {
		return getClass().getResource("/SkillIcons/" + getKey().toString().toLowerCase() + ".png");
	}

	public Skills getSkills() {
		return this.skills;
	}

	public Set<Methods> getMethods() {
		return this.methodRecipes.keySet();
	}

	public Recipe[] getRecipes(Methods method) {
		return this.methodRecipes.get(method);
	}

	public TreeMap<Methods, Recipe[]> getMethodRecipes() {
		return this.methodRecipes;
	}

	public Skills getKey() {
		return this.skills;
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

	public boolean checkFlag(Flags flag) {
		return this.flags.contains(flag);
	}
}
