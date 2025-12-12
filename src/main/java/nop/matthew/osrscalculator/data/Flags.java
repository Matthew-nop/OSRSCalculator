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
	PRESCRIPTION_GOGGLES("Prescription goggles", Skills.HERBLORE),

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
