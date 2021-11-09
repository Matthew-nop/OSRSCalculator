package nop.matthew.osrscalculator.data.cooking;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Cooking extends Skill {
	public Cooking(PriceFetcher priceFetcher) {
		super(Skills.COOKING, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}