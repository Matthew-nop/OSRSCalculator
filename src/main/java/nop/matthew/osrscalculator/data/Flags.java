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
