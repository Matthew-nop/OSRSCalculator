package nop.matthew.osrscalculator.data.herblore;

import net.runelite.api.ItemID;
import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

import java.util.HashMap;
import java.util.Map;

public class Herblore extends Skill {
	private static final Herblore herblore = new Herblore();

	private Herblore() {
		super(Skills.HERBLORE);
		this.methodRecipes.put(Methods.MAKING_POTIONS, Potions.values());
		this.methodRecipes.put(Methods.MAKING_DIVINE_POTIONS, DivinePotions.values());
		this.methodRecipes.put(Methods.CLEANING_HERBS, Herbs.values());
		this.methodRecipes.put(Methods.MAKING_TAR, Tar.values());
	}

	public static Herblore getInstance() {
		return herblore;
	}

	@Override
	public Map<Integer, Float> getRecipeOutCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<>();
		ItemQuantity[] outputs = recipe.getOutput();

		float[] coeff = new float[]{1f, 0f};
		// If using the amulet of chemistry, and the recipe is affected
		if(recipe.flagAffects(Flags.AMULET_OF_CHEMISTRY)) {
			if(flags.contains(Flags.ALCHEMISTS_AMULET)) {
				// 15% chance to proc
				coeff = new float[]{0.85f, 0.15f};
			}
			else if (flags.contains(Flags.AMULET_OF_CHEMISTRY)) {
				// 5% chance to proc
				coeff = new float[]{0.95f, 0.05f};
			}
		}

		for (int i = 0; i < outputs.length; i++) {
			float c = coeff[i];
			if (c > 0) {
				int id = outputs[i].getId();
				costs.put(id, PriceFetcher.getPrice(id) * c);
			}
		}

		return costs;
	}

	@Override
	public Map<Integer, Float> getRecipeInCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<>();

		// If using the amulet of chemistry, and the recipe is affected
		if(recipe.flagAffects(Flags.AMULET_OF_CHEMISTRY)) {
			if(flags.contains(Flags.ALCHEMISTS_AMULET)) {
				// 15% chance to proc, with 1 amulet charge consumed per proc (1 charge = 1/10 amulet of chemistry)
				// 0.15 * 0.10 = 0.015
				costs.put(ItemID.AMULET_OF_CHEMISTRY, PriceFetcher.getPrice(ItemID.AMULET_OF_CHEMISTRY) * 0.015f);
			}
			else if (flags.contains(Flags.AMULET_OF_CHEMISTRY)) {
				// 5% chance to proc, with 1/5 of the amulet consumed per proc
				// 0.05 * 0.20 = 0.01
				costs.put(ItemID.AMULET_OF_CHEMISTRY, PriceFetcher.getPrice(ItemID.AMULET_OF_CHEMISTRY) * 0.01f);
			}
		}
		
		for (ItemQuantity i : recipe.getIngredients(flags)) {
			int id = i.getId();
			costs.put(id, PriceFetcher.getPrice(id) * i.getQuantity());
		}

		return costs;
	}

	@Override
	protected void addTertiaryPrices() {
		PriceFetcher.addItem(ItemID.AMULET_OF_CHEMISTRY);
	}
}
