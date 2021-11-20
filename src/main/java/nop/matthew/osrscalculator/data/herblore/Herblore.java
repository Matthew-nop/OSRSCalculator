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

package nop.matthew.osrscalculator.data.herblore;

import nop.matthew.osrscalculator.data.Flags;
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
		this.methodRecipes.put(Methods.MAKING_DIVINE_POTIONS, DivinePotions.values());
		this.methodRecipes.put(Methods.CLEANING_HERBS, Herbs.values());
		this.methodRecipes.put(Methods.MAKING_TAR, Tar.values());
	}

	@Override
	public Map<Integer, Float> getRecipeOutCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<>();
		ItemQuantity[] outputs = recipe.getOutput();
		// If using the amulet of chemistry, and the recipe is affected
		float[] coeff = recipe.flagAffects(flags) ? new float[]{0.95f, 0.05f} : new float[]{1f, 0f};

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
	public Map<Integer, Float> getRecipeInCosts(Recipe recipe) {
		HashMap<Integer, Float> costs = new HashMap<>();

		// If using the amulet of chemistry, and the recipe is affected
		if (flags.contains(Flags.AMULET_OF_CHEMISTRY) && recipe.flagAffects(Flags.AMULET_OF_CHEMISTRY)) {
			// 5% chance to proc, with 20% of the amulet consumed each proc
			costs.put(ItemID.AMULET_OF_CHEMISTRY, priceFetcher.getPrice(ItemID.AMULET_OF_CHEMISTRY) * 0.01f);
		}
		for (ItemQuantity i : recipe.getIngredients()) {
			int id = i.getId();
			costs.put(id, priceFetcher.getPrice(id) * i.getQuantity());
		}

		return costs;
	}

	@Override
	protected void addTertiaryPrices() {
		this.priceFetcher.addItem(ItemID.AMULET_OF_CHEMISTRY);
	}
}
