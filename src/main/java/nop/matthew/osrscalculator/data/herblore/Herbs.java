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
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Herbs implements Recipe {
	AVANTOE(
			new ItemQuantity(Item.AVANTOE, 1),
			48,
			10,
			new ItemQuantity(Item.GRIMY_AVANTOE, 1)),
	CADANTINE(
			new ItemQuantity(Item.CADANTINE, 1),
			65,
			12.5f,
			new ItemQuantity(Item.GRIMY_CADANTINE, 1)),
	GUAM_LEAF(
			new ItemQuantity(Item.GUAM_LEAF, 1),
			3,
			2.5f,
			new ItemQuantity(Item.GRIMY_GUAM_LEAF, 1)),
	HARRALANDER(
			new ItemQuantity(Item.HARRALANDER, 1),
			20,
			6.3f,
			new ItemQuantity(Item.GRIMY_HARRALANDER, 1)),
	IRIT_LEAF(
			new ItemQuantity(Item.IRIT_LEAF, 1),
			40,
			8.8f,
			new ItemQuantity(Item.GRIMY_IRIT_LEAF, 1)),
	KWUARM(
			new ItemQuantity(Item.KWUARM, 1),
			54,
			11.3f,
			new ItemQuantity(Item.GRIMY_KWUARM, 1)),
	LANTADYME(
			new ItemQuantity(Item.LANTADYME, 1),
			67,
			13.1f,
			new ItemQuantity(Item.GRIMY_LANTADYME, 1)),
	MARRENTILL(
			new ItemQuantity(Item.MARRENTILL, 1),
			5,
			3.8f,
			new ItemQuantity(Item.GRIMY_MARRENTILL, 1)),
	RANARR_WEED(
			new ItemQuantity(Item.RANARR_WEED, 1),
			25,
			7.5f,
			new ItemQuantity(Item.GRIMY_RANARR_WEED, 1)),
	SNAPDRAGON(
			new ItemQuantity(Item.SNAPDRAGON, 1),
			59,
			11.8f,
			new ItemQuantity(Item.GRIMY_SNAPDRAGON, 1)),
	TARROMIN(
			new ItemQuantity(Item.TARROMIN, 1),
			11,
			5,
			new ItemQuantity(Item.GRIMY_TARROMIN, 1)
	),
	TOADFLAX(
			new ItemQuantity(Item.TOADFLAX, 1),
			30,
			8,
			new ItemQuantity(Item.GRIMY_TOADFLAX, 1)),
	TORSTOL(
			new ItemQuantity(Item.TORSTOL, 1),
			75,
			15,
			new ItemQuantity(Item.GRIMY_TORSTOL, 1));

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;


	Herbs(ItemQuantity output, int level, float xp, ItemQuantity ingredient) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredient = ingredient;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[]{this.ingredient};
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
		return getClass().getResource("/Items/" + this.output.getId() + " - " + this.getName().toLowerCase() + " detail.png");
	}
}
