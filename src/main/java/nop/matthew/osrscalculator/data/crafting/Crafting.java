package nop.matthew.osrscalculator.data.crafting;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Crafting extends Skill {
	private static final Crafting crafting = new Crafting();

	private Crafting() {
		super(Skills.CRAFTING);
	}

	public static Crafting getInstance() {
		return crafting;
	}

	@Override
	public void addTertiaryPrices() {
	}
}