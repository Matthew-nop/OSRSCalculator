package nop.matthew.osrscalculator.data;

public enum Flags {
    // Construction
	CARPENTERS_OUTFIT("Carpenter's Outfit", Skills.CONSTRUCTION),

	// Herblore
	AMULET_OF_CHEMISTRY("Amulet of chemistry", Skills.HERBLORE),
	;

	private final String name;
	private final Skills skill;

	Flags(String name, Skills skill) {
		this.name = name;
		this.skill = skill;
	}

	public Skills getSkill() {
		return skill;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
