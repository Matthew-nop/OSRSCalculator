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

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Firemaking extends Skill {
	private static final Firemaking firemaking = new Firemaking();

	private Firemaking() {
		super(Skills.FIREMAKING);
		this.methodRecipes.put(Methods.BURNING_LOGS, Logs.values());
	}

	public static Firemaking getInstance() {
		return firemaking;
	}

	@Override
	public void addTertiaryPrices() {
	}
}