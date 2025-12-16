package nop.matthew.osrscalculator.data;

public enum Methods {
	// Construction
	PLANKS("Using planks", Skills.CONSTRUCTION),
	REPAIR_KITS("Making repair kits", Skills.CONSTRUCTION),

	// Cooking
	COOKING_FISH("Cooking fish", Skills.COOKING),

	// Crafting
	BATTLESTAVES("Battlestaves", Skills.CRAFTING),
	DRAGON_LEATHER("Dragon leather", Skills.CRAFTING),

	// Firemaking
	BURNING_LOGS("Burning logs", Skills.FIREMAKING),
	CREMATING_SHADES("Cremating shades", Skills.FIREMAKING),

	// Fletching
	FLETCHING_DARTS("Darts", Skills.FLETCHING),

	// Herblore
	CLEANING_HERBS("Cleaning herbs", Skills.HERBLORE),
	MAKING_TAR("Making tar", Skills.HERBLORE),
	MAKING_POTIONS("Making potions", Skills.HERBLORE),
	MAKING_DIVINE_POTIONS("Making divine potions", Skills.HERBLORE),

	// Hunter
	BOXTRAPS("Boxtraps", Skills.HUNTER),
	
	// Magic
	ENCHANTING_BOLTS("Enchanting bolts", Skills.MAGIC),

	// Prayer
	ASHES("Ashes", Skills.PRAYER),
	BONES("Bones", Skills.PRAYER),

	// Smithing
	DART_TIPS("Dart tips", Skills.SMITHING),
	SMITHING_ARMOUR("Armour", Skills.SMITHING),
	;

	private final String name;
	private final Skills skill;

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

	/**
	 * Returns the first Method which matches the given name
	 *
	 * @param name the given name
	 * @return the first matching Method
	 */
	public static Methods getFromName(String name) {
		for (Methods m : Methods.values()) {
			if (m.toString().equals(name)) {
				return m;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
