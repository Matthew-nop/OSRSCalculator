package nop.matthew.osrscalculator.data;

public enum Methods {
	// Construction
	PLANKS("Using planks", Skills.CONSTRUCTION),

	// Firemaking
	BURNING_LOGS("Burning logs", Skills.FIREMAKING),

	// Herblore
	CLEANING_HERBS("Cleaning herbs", Skills.HERBLORE),
	MAKING_TAR("Making tar", Skills.HERBLORE),
	MAKING_POTIONS("Making potions", Skills.HERBLORE),
	;

	private String name;
	private Skills skill;

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

	@Override
	public String toString() {
		return this.name;
	}

	public static Methods getFromName(String name) {
		for (Methods m : Methods.values()) {
			if (m.toString().equals(name))
				return m;
		}

		return null;
	}
}
