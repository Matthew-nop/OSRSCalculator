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

package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Construction extends Skill {
	public Construction(PriceFetcher priceFetcher) {
		super(Skills.CONSTRUCTION, priceFetcher);
		this.methodRecipes.put(Methods.PLANKS, Planks.values());
	}

	@Override
	public void addTertiaryPrices() {
	}

	@Override
	public double getXp(Recipe recipe) {
		return this.flags.contains(Flags.CARPENTERS_OUTFIT) ? super.getXp(recipe) * 1.025d: super.getXp(recipe);
	}
}
