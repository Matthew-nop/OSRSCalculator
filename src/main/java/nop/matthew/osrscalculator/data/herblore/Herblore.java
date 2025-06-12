package nop.matthew.osrscalculator.data.herblore;

import nop.matthew.osrscalculator.data.ItemID;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

import java.util.HashMap;
import java.util.Map;

public class Herblore extends Skill {
	public Herblore(PriceFetcher priceFetcher) {
		super(Skills.HERBLORE, priceFetcher);
		this.methodRecipes.put(Methods.MAKING_POTIONS, Potions.values());
		this.methodRecipes.put(Methods.CLEANING_HERBS, Herbs.values());
	}

	@Override
	public Map<Integer, Float> getRecipeOutCosts(Recipe r) {
		HashMap<Integer, Float> costs = new HashMap<Integer, Float>();
		ItemQuantity[] outputs = r.getOutput();
		// If using the amulet of chemistry, and the recipe is affected
		float[] coeff = r.flagsAffect(flags) ? new float[]{0.95f, 0.05f} : new float[]{1f, 0f};

		for (int i = 0; i < outputs.length; i++) {
			float c = coeff[i];
			if (c > 0) {
				int id = outputs[i].getId();
				costs.put(id, priceFetcher.getPrice(id) * c);
			}
		}

		return costs;
	}

	@Override
	public Map<Integer, Float> getRecipeInCosts(Recipe r) {
		HashMap<Integer, Float> costs = new HashMap<Integer, Float>();

		// If using the amulet of chemistry, and the recipe is affected
		if (r.flagsAffect(flags)) {
			// 5% chance to proc, with 20% of the amulet consumed each proc
			costs.put(ItemID.AMULET_OF_CHEMISTRY, priceFetcher.getPrice(ItemID.AMULET_OF_CHEMISTRY)*0.01f);
		}
		for (ItemQuantity i : r.getIngredients()) {
			int id = i.getId();
			costs.put(id, priceFetcher.getPrice(id)*i.getQuantity());
		}

		return costs;
	}


	@Override
	public void addTertiaryPrices() {
		this.priceFetcher.addItem(ItemID.AMULET_OF_CHEMISTRY);
	}
}
