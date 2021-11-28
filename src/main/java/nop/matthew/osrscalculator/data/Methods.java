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

public enum Methods {
	// Construction
	PLANKS("Using planks", Skills.CONSTRUCTION),

	// Firemaking
	BURNING_LOGS("Burning logs", Skills.FIREMAKING),
	CREMATING_SHADES("Cremating shades", Skills.FIREMAKING),

	// Herblore
	CLEANING_HERBS("Cleaning herbs", Skills.HERBLORE),
	MAKING_TAR("Making tar", Skills.HERBLORE),
	MAKING_POTIONS("Making potions", Skills.HERBLORE),
	MAKING_DIVINE_POTIONS("Making divine potions", Skills.HERBLORE),

	// Prayer
	ASHES("Ashes", Skills.PRAYER),
	BONES("Bones", Skills.PRAYER),
	;

	private final String name;
	private final Skills skill;

	Methods(String name, Skills skill) {
		this.name = name;
		this.skill = skill;
	}

	public String getName() {
		return this.name;
	}

	public Skills getSkill() {
		return this.skill;
	}

	/**
	 * Returns the first Method which matches the given name
	 *
	 * @param name the given name
	 * @return the first matching Method
	 */
	public static Methods getFromName(String name) {
		for (Methods m : Methods.values()) {
			if (m.toString().equals(name))
				return m;
		}

		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
