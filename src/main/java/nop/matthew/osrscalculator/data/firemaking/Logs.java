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

package nop.matthew.osrscalculator.data.firemaking;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Logs implements Recipe {
	LOGS(1,
			40,
			new ItemQuantity(Item.LOGS, 1)),
	ACHEY_TREE_LOGS(
			1,
			40,
			new ItemQuantity(Item.ACHEY_TREE_LOGS, 1)),
	OAK_LOGS(
			15,
			60,
			new ItemQuantity(Item.OAK_LOGS, 1)),
	WILLOW_LOGS(
			30,
			90,
			new ItemQuantity(Item.WILLOW_LOGS, 1)),
	TEAK_LOGS(
			35,
			105,
			new ItemQuantity(Item.TEAK_LOGS, 1)),
	ARCTIC_PINE_LOGS(
			42,
			125,
			new ItemQuantity(Item.ARCTIC_PINE_LOGS, 1)),
	MAPLE_LOGS(
			45,
			135,
			new ItemQuantity(Item.MAPLE_LOGS, 1)),
	MAHOGANY_LOGS(
			50,
			157.5f,
			new ItemQuantity(Item.MAHOGANY_LOGS, 1)),
	YEW_LOGS(
			60,
			202.5f,
			new ItemQuantity(Item.YEW_LOGS, 1)),
	BLISTERWOOD_LOGS(
			62,
			96,
			new ItemQuantity(Item.BLISTERWOOD_LOGS, 1)),
	MAGIC_LOGS(
			75,
			303.8f,
			new ItemQuantity(Item.MAGIC_LOGS, 1)),
	REDWOOD_LOGS(
			90,
			350,
			new ItemQuantity(Item.REDWOOD_LOGS, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Logs(int level, float xp, ItemQuantity ingredient) {
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
		return new ItemQuantity[]{ingredient};
	}

	@Override
	public String getName() {
		return ingredient.getName();
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
	public boolean flagAffects(Set<Flags> flag) {
		return flag.contains(Flags.PYROMANCER_OUTFIT);
	}

	@Override
	public boolean flagAffects(Flags flag) {
		return flag.equals(Flags.PYROMANCER_OUTFIT);
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.ingredient.getId() + " - " + this.getName().toLowerCase() + " detail.png");
	}
}
