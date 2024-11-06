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

package nop.matthew.osrscalculator.data.magic;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Arrays;
import java.util.Set;

public enum EnchantingBolts implements Recipe {
	ENCHANT_OPAL_BOLT(
			new ItemQuantity(Item.OPAL_BOLTS_E, 10),
			4,
			9,
			new ItemQuantity[]{
				new ItemQuantity(Item.OPAL_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.AIR_RUNE, 2),
			}
	),
	ENCHANT_SAPPHIRE_BOLT(
			new ItemQuantity(Item.SAPPHIRE_BOLTS_E, 10),
			7,
			17.5f,
			new ItemQuantity[]{
				new ItemQuantity(Item.SAPPHIRE_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.MIND_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.WATER_RUNE, 1),
			}
	),
	ENCHANT_JADE_BOLT(
			new ItemQuantity(Item.JADE_BOLTS_E, 10),
			14,
			19,
			new ItemQuantity[]{
				new ItemQuantity(Item.JADE_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.EARTH_RUNE, 2),
			}
	),
	ENCHANT_PEARL_BOLT(
			new ItemQuantity(Item.PEARL_BOLTS_E, 10),
			24,
			29,
			new ItemQuantity[]{
				new ItemQuantity(Item.PEARL_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.WATER_RUNE, 2),
			}
	),
	ENCHANT_EMERALD_BOLT(
			new ItemQuantity(Item.EMERALD_BOLTS_E, 10),
			27,
			37,
			new ItemQuantity[]{
				new ItemQuantity(Item.EMERALD_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.NATURE_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.AIR_RUNE, 3),
			}
	),
	ENCHANT_TOPAZ_BOLT(
			new ItemQuantity(Item.TOPAZ_BOLTS_E, 10),
			29,
			33,
			new ItemQuantity[]{
				new ItemQuantity(Item.TOPAZ_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.FIRE_RUNE, 2),
			}
	),
	ENCHANT_RUBY_BOLT(
			new ItemQuantity(Item.RUBY_BOLTS_E, 10),
			49,
			59,
			new ItemQuantity[]{
				new ItemQuantity(Item.RUBY_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.BLOOD_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.FIRE_RUNE, 5),
			}
	),
	ENCHANT_DIAMOND_BOLT(
			new ItemQuantity(Item.DIAMOND_BOLTS_E, 10),
			57,
			67,
			new ItemQuantity[]{
				new ItemQuantity(Item.DIAMOND_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.LAW_RUNE, 2),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.EARTH_RUNE, 10),
			}
	),
	ENCHANT_DRAGONSTONE_BOLT(
			new ItemQuantity(Item.DRAGONSTONE_BOLTS_E, 10),
			68,
			78,
			new ItemQuantity[]{
				new ItemQuantity(Item.DRAGONSTONE_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.SOUL_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.EARTH_RUNE, 15),
			}
	),
	ENCHANT_ONYX_BOLT(
			new ItemQuantity(Item.ONYX_BOLTS_E, 10),
			87,
			97,
			new ItemQuantity[]{
				new ItemQuantity(Item.ONYX_BOLTS, 10),
				new ItemQuantity(Item.COSMIC_RUNE, 1),
				new ItemQuantity(Item.DEATH_RUNE, 1),
			},
			new ItemQuantity[]{
				new ItemQuantity(Item.FIRE_RUNE, 20),
			}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;
	private final ItemQuantity[] elementalRunes;

	EnchantingBolts( ItemQuantity output, int level, float xp, ItemQuantity[] ingredients, ItemQuantity[] elementalRunes ) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
		this.elementalRunes = elementalRunes;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		if(flags.contains(Flags.INFINITE_ELEMENTAL_RUNE_SOURCE)) {
			return this.ingredients;
		}

		ItemQuantity[] allIngredients = Arrays.copyOf(this.ingredients, this.ingredients.length + this.elementalRunes.length);
		System.arraycopy(this.elementalRunes, 0, allIngredients, this.ingredients.length, this.elementalRunes.length);
		return allIngredients;
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
		return (flag == Flags.INFINITE_ELEMENTAL_RUNE_SOURCE && this.elementalRunes != null);
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.output.getId() + " - " + this.output.getName().toLowerCase() + " detail.png");
	}
}
