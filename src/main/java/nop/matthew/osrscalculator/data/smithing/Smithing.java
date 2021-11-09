package nop.matthew.osrscalculator.data.smithing;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Smithing extends Skill {
	public Smithing(PriceFetcher priceFetcher) {
		super(Skills.SMITHING, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}