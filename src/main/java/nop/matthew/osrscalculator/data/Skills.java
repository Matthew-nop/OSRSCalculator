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

package nop.matthew.osrscalculator.data;

public enum Skills {
	CONSTRUCTION("Construction"),
	COOKING("Cooking"),
	CRAFTING("Crafting"),
	FARMING("Farming"),
	FIREMAKING("Firemaking"),
	FLETCHING("Fletching"),
	HERBLORE("Herblore"),
	HUNTER("Hunter"),
	MAGIC("Magic"),
	PRAYER("Prayer"),
	SMITHING("Smithing"),
	;

	private final String name;

	Skills(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
