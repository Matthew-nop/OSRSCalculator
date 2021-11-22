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

public final class Experience {
	public static final int LEVEL_MAX = 99;
	public static final int LEVEL_MAX_VIRT = 126;
	public static final int MAX_EXPERIENCE = 200000000;

	private static final int[] LEVEL_XP = new int[LEVEL_MAX_VIRT];

	static {
		int xp = 0;
		for (int lvl = 1; lvl <= LEVEL_MAX_VIRT; ++lvl) {
			LEVEL_XP[lvl - 1] = xp / 4;
			xp += (int) ((double) lvl + 300.0 * Math.pow(2.0, (double) lvl / 7.0));
		}
	}

	/**
	 * Get the minimum XP value needed for a given level
	 *
	 * @param level the given level
	 * @return the minimum XP value needed
	 */
	public static int getXpFromLevel(int level) {
		if (level > LEVEL_MAX_VIRT || level < 1) {
			throw new IllegalArgumentException("level must be from [1, 126], received: " + level);
		}

		return LEVEL_XP[level - 1];
	}

	/**
	 * Get the minimum level needed for a given XP value
	 *
	 * @param xp the given XP value
	 * @return the minimum level needed
	 */
	public static int getLevelFromXp(int xp) {
		// Binary search array to get the lowest level with >= xp
		if (xp < 0) {
			throw new IllegalArgumentException("XP must be positive, received: " + xp);
		}
		else if (xp > MAX_EXPERIENCE) {
			throw new IllegalArgumentException("XP cannot be > " + MAX_EXPERIENCE + ", received " + xp);
		}

		return getLevelFromXp(xp, 0, LEVEL_XP.length);
	}

	private static int getLevelFromXp(int xp, int low, int high) {
		if (low >= high) {
			return high;
		}

		int mid = low + ((high - low) / 2);
		int levelXp = LEVEL_XP[mid];

		if (xp < levelXp) {
			high = mid + 1;
		}
		else if (xp > levelXp) {
			low = mid + 1;
		}
		else {
			return mid + 1;
		}

		return getLevelFromXp(xp, low, high);
	}
}
