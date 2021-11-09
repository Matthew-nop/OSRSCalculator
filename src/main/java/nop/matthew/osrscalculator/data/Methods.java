package nop.matthew.osrscalculator.data;

public enum Methods {
	MAKING_TAR("Making tar", Skills.HERBLORE),
	MAKING_POTIONS("Making potions", Skills.HERBLORE),
	PLANKS("Using planks", Skills.CONSTRUCTION),
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
}
