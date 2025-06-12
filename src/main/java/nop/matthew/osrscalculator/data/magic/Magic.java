package nop.matthew.osrscalculator.data.magic;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Magic extends Skill {
	private static final Magic magic = new Magic();

	private Magic() {
		super(Skills.MAGIC);
		this.methodRecipes.put(Methods.ENCHANTING_BOLTS, EnchantingBolts.values());
	}

	public static Magic getInstance() {
		return magic;
	}

	@Override
	public void addTertiaryPrices() {
	}
}