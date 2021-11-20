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
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Tar implements Recipe {
	GUAM_TAR(
			new ItemQuantity(Item.GUAM_TAR, 15),
			19,
			30,
			new ItemQuantity[]{
					new ItemQuantity(Item.GUAM_LEAF, 1),
					new ItemQuantity(Item.SWAMP_TAR, 15)
			}),
	GROUNDGUAM_TAR(
			new ItemQuantity(Item.GUAM_TAR, 15),
			19,
			30,
			new ItemQuantity[]{
					new ItemQuantity(Item.GROUND_GUAM, 1),
					new ItemQuantity(Item.SWAMP_TAR, 15)
			}),
	HARRALANDER_TAR(
			new ItemQuantity(Item.HARRALANDER_TAR, 15),
			44,
			72.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.HARRALANDER, 1),
					new ItemQuantity(Item.SWAMP_TAR, 15)
			}),
	MARRENTILL_TAR(
			new ItemQuantity(Item.MARRENTILL_TAR, 15),
			31,
			42.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.MARRENTILL, 1),
					new ItemQuantity(Item.SWAMP_TAR, 15)
			}),
	TARROMIN_TAR(
			new ItemQuantity(Item.TARROMIN_TAR, 15),
			39,
			55,
			new ItemQuantity[]{
					new ItemQuantity(Item.GUAM_LEAF, 1),
					new ItemQuantity(Item.SWAMP_TAR, 15)
			});

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	Tar(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
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
	public ItemQuantity[] getIngredients() {
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
	public boolean flagAffects(Set<Flags> flag) {
		return false;
	}

	@Override
	public boolean flagAffects(Flags flag) {
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/SkillIcons/" + this.output.getId() + ".png");
	}
}
