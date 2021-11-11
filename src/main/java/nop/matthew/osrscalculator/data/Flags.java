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

import java.util.HashSet;
import java.util.Set;

public enum Flags {
	AMULET_OF_CHEMISTRY(1),
	;

	private final int val;

	Flags(int val) {
		this.val = val;
	}

	public static Set<Flags> getFlags(int val) {
		Flags[] flags = Flags.values();
		Set<Flags> flagsSet = new HashSet<Flags>(flags.length);
		for (Flags f : flags) {
			if ((val & f.getVal()) != 0)
				flagsSet.add(f);
		}
		return flagsSet;
	}

	public int getVal() {
		return this.val;
	}

	public static boolean isEnabled(int flags, Flags flag) {
		return ((flags & flag.getVal()) != 0);
	}
}
