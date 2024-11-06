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

import java.net.URL;

public enum Flags {
    // Construction
	CARPENTERS_OUTFIT("Carpenter's Outfit", Skills.CONSTRUCTION),

	// Firemaking
	PYROMANCER_OUTFIT("Pyromancer Outfit", Skills.FIREMAKING),

	// Herblore
	ALCHEMISTS_AMULET("Alchemist's amulet", Skills.HERBLORE),
	AMULET_OF_CHEMISTRY("Amulet of chemistry", Skills.HERBLORE),

	// Magic
	INFINITE_ELEMENTAL_RUNE_SOURCE("Infinite elemental rune source", Skills.MAGIC),

	;

	private final String name;
	private final Skills skill;

	Flags(String name, Skills skill) {
		this.name = name;
		this.skill = skill;
	}

	public URL getIconPath() {
		return getClass().getResource("/Flags/" + this.getName().toLowerCase() + ".png");
	}

	public String getName() {
		return this.name;
	}

	public Skills getSkill() {
		return this.skill;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
