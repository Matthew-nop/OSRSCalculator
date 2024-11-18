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

package nop.matthew.osrscalculator.data.crafting;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Battlestaves implements Recipe {
	WATER_BATTLESTAFF(
			new ItemQuantity(Item.WATER_BATTLESTAFF, 1),
			54,
			100,
			new ItemQuantity[]{
					new ItemQuantity(Item.WATER_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	EARTH_BATTLESTAFF(
			new ItemQuantity(Item.EARTH_BATTLESTAFF, 1),
			58,
			112.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.EARTH_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	FIRE_BATTLESTAFF(
			new ItemQuantity(Item.FIRE_BATTLESTAFF, 1),
			62,
			125,
			new ItemQuantity[]{
					new ItemQuantity(Item.FIRE_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	AIR_BATTLESTAFF(
			new ItemQuantity(Item.AIR_BATTLESTAFF, 1),
			66,
			137.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.AIR_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	Battlestaves(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
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
		return output.getName();
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
