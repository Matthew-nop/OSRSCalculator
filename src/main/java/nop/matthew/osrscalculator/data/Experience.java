package nop.matthew.osrscalculator.data;

public final class Experience {
	private static final int LEVEL_MAX = 99;
	private static final int LEVEL_MAX_VIRT = 126;
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
		if (level > LEVEL_MAX_VIRT) {
			throw new IllegalArgumentException("level must be from [1, 126], received: " + level);
		}

		return LEVEL_XP[level];
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

		return getLevelFromXp(xp, 1, LEVEL_XP.length - 1);
	}

	private static int getLevelFromXp(int xp, int low, int high) {
		if (low == high) {
			return low;
		}

		int mid = low + ((high - low) / 2);
		int levelXp = LEVEL_XP[mid];

		if (xp < levelXp) {
			high = mid - 1;
		}
		else if (xp > levelXp) {
			low = mid + 1;
		}
		else {
			return mid;
		}

		return getLevelFromXp(xp, low, high);
	}
}
