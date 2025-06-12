package nop.matthew.osrscalculator.data.hunter;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Hunter extends Skill {
	public Hunter(PriceFetcher priceFetcher) {
		super(Skills.HUNTER, priceFetcher);
	}

	@Override
	protected void addTertiaryPrices() {
	}
}
