package nop.matthew.osrscalculator.data;

public enum Skills {
	CONSTRUCTION("Construction"),
	COOKING("Cooking"),
	CRAFTING("Crafting"),
	FARMING("Farming"),
	FIREMAKING("Firemaking"),
	FLETCHING("Fletching"),
	HERBLORE("Herblore"),
	HUNTER("Hunter"),
	MAGIC("Magic"),
	PRAYER("Prayer"),
	SMITHING("Smithing"),
	;

	private final String name;

	Skills(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
