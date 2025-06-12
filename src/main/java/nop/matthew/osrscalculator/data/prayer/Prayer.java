package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Prayer extends Skill {
	public Prayer(PriceFetcher priceFetcher) {
		super(Skills.PRAYER, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}