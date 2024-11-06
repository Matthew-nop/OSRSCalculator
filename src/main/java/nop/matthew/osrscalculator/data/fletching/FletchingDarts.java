/*
 * Copyright 2024 Matthew C. <Chapman.L.Matthew@gmail.com>
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

package nop.matthew.osrscalculator.data.fletching;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum FletchingDarts implements Recipe {
	BRONZE_DARTS(
			new ItemQuantity(Item.BRONZE_DART, 10),
			10,
			18,
			new ItemQuantity[]{
					new ItemQuantity(Item.BRONZE_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	IRON_DARTS(
			new ItemQuantity(Item.IRON_DART, 10),
			22,
			38,
			new ItemQuantity[]{
					new ItemQuantity(Item.IRON_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	STEEL_DARTS(
			new ItemQuantity(Item.STEEL_DART, 10),
			37,
			75,
			new ItemQuantity[]{
					new ItemQuantity(Item.STEEL_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	MITHRIL_DARTS(
			new ItemQuantity(Item.MITHRIL_DART, 10),
			52,
			112,
			new ItemQuantity[]{
					new ItemQuantity(Item.MITHRIL_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	ADAMANT_DARTS(
			new ItemQuantity(Item.ADAMANT_DART, 10),
			67,
			150,
			new ItemQuantity[]{
					new ItemQuantity(Item.ADAMANT_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	RUNE_DARTS(
			new ItemQuantity(Item.RUNE_DART, 10),
			81,
			188,
			new ItemQuantity[]{
					new ItemQuantity(Item.RUNE_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	AMETHYST_DARTS(
			new ItemQuantity(Item.AMETHYST_DART, 10),
			90,
			210,
			new ItemQuantity[]{
					new ItemQuantity(Item.AMETHYST_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	DRAGON_DARTS(
			new ItemQuantity(Item.DRAGON_DART, 10),
			95,
			250,
			new ItemQuantity[]{
					new ItemQuantity(Item.DRAGON_DART_TIP, 10),
					new ItemQuantity(Item.FEATHER, 10),
			}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;


	FletchingDarts(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return this.ingredients;
	}

	@Override
	public String getName() {
		return this.output.getName();
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public float getXp() {
		return this.xp;
	}

	@Override
	public boolean flagAffects(Flags flag) {
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.output.getId() + " - " + this.output.getName().toLowerCase() + " detail.png");
	}
}
