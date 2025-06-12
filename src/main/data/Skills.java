package data;

public enum Skills {
	CONSTRUCTION("Construction", "res/SkillIcons/construction.png"),
	COOKING("Cooking", "res/SkillIcons/cooking.png"),
	CRAFTING("Crafting", "res/SkillIcons/crafting.png"),
	FARMING("Farming", "res/SkillIcons/farming.png"),
	FIREMAKING("Firemaking", "res/SkillIcons/firemaking.png"),
	FLETCHING("Fletching", "res/SkillIcons/fletching.png"),
	HERBLORE("Herblore", "res/SkillIcons/herblore.png"),
	HUNTER("Hunter", "res/SkillIcons/hunter.png"),
	MAGIC("Magic", "res/SkillIcons/magic.png"),
	PRAYER("Prayer", "res/SkillIcons/prayer.png"),
	SMITHING("Smithing", "res/SkillIcons/smithing.png"),
	;

	private String name;
	private String iconPath;

	Skills(String name, String iconPath) {
		this.name = name;
		this.iconPath = iconPath;
	}

	public String getName() {
		return name;
	}

	public String getIconPath() {
		return iconPath;
	}
}
