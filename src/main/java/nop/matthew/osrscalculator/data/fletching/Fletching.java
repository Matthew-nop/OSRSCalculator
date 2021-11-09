package nop.matthew.osrscalculator.data.fletching;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Fletching extends Skill {
	public Fletching(PriceFetcher priceFetcher) {
		super(Skills.FLETCHING, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}