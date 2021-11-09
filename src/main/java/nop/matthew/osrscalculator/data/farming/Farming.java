package nop.matthew.osrscalculator.data.farming;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Farming extends Skill {
	public Farming(PriceFetcher priceFetcher) {
		super(Skills.FARMING, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}