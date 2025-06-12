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

	/**
	 * Get the set of flags represented by the given val
	 *
	 * @param val the given val
	 * @return a set of set flags
	 */
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

	/** Checks if the given flag is set in the given flags
	 * @param flags the given flags val
	 * @param flag the flag to check for
	 * @return true if the flag is set, false if not
	 */
	public static boolean isEnabled(int flags, Flags flag) {
		return ((flags & flag.getVal()) != 0);
	}
}
