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

package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Ashes implements Recipe {
	ABYSSAL_ASHES(1, 85, new ItemQuantity(Item.ABYSSAL_ASHES, 1)),
	FIENDISH_ASHES(1, 10, new ItemQuantity(Item.FIENDISH_ASHES, 1)),
	INFERNAL_ASHES(1, 110, new ItemQuantity(Item.INFERNAL_ASHES, 1)),
	MALICIOUS_ASHES(1, 65, new ItemQuantity(Item.MALICIOUS_ASHES, 1)),
	VILE_ASHES(1, 25, new ItemQuantity(Item.VILE_ASHES, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Ashes(int level, float xp, ItemQuantity ingredient) {
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
	public boolean flagAffects(Set<Flags> flag) {
		return false;
	}

	@Override
	public boolean flagAffects(Flags flag) {
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.ingredient.getId() + ".png");
	}
}
