package nop.matthew.osrscalculator.data.smithing;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Smithing extends Skill {
	private static final Smithing smithing = new Smithing();

	private Smithing() {
		super(Skills.SMITHING);
	}

	public static Smithing getInstance() {
		return smithing;
	}

	@Override
	public void addTertiaryPrices() {
	}
}