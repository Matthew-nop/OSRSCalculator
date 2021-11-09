package nop.matthew.osrscalculator.data.magic;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Magic extends Skill {
	public Magic(PriceFetcher priceFetcher) {
		super(Skills.MAGIC, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}