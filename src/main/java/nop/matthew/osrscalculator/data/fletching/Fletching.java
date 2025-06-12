package nop.matthew.osrscalculator.data.fletching;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Fletching extends Skill {
	private static final Fletching fletching = new Fletching();

	private Fletching() {
		super(Skills.FLETCHING);
	}

	public static Fletching getInstance() {
		return fletching;
	}

	@Override
	public void addTertiaryPrices() {
	}
}