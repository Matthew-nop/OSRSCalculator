package nop.matthew.osrscalculator.data.magic;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Magic extends Skill {
	private static final Magic magic = new Magic();

	private Magic() {
		super(Skills.MAGIC);
	}

	public static Magic getInstance() {
		return magic;
	}

	@Override
	public void addTertiaryPrices() {
	}
}