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
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.util.Set;

public enum Planks implements Recipe {
	PLANKS(
			1,
			29,
			new ItemQuantity(Item.PLANK, 1)),
	OAK_PLANKS(
			15,
			60,
			new ItemQuantity(Item.OAK_PLANK, 1)),
	TEAK_PLANKS(
			35,
			90,
			new ItemQuantity(Item.TEAK_PLANK, 1)),
	MAHOGANY_PLANKS(
			35,
			90,
			new ItemQuantity(Item.MAHOGANY_PLANK, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Planks(int level, float xp, ItemQuantity ingredient) {
		this.level = level;
		this.xp = xp;
		this.ingredient = ingredient;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients() {
		return new ItemQuantity[]{this.ingredient};
	}

	@Override
	public String getName() {
		return this.ingredient.getName();
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
	public boolean flagsAffect(Set<Flags> flag) {
		return false;
	}

	@Override
	public boolean flagsAffect(Flags flag) {
		return false;
	}
}
