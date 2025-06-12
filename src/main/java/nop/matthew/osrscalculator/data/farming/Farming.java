package nop.matthew.osrscalculator.data.farming;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Farming extends Skill {
	private static final Farming farming = new Farming();

	private Farming() {
		super(Skills.FARMING);
	}

	public static Farming getInstance() {
		return farming;
	}

	@Override
	public void addTertiaryPrices() {
	}
}