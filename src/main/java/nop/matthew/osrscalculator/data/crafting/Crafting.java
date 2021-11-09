package nop.matthew.osrscalculator.data.crafting;

import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Crafting extends Skill {
	public Crafting(PriceFetcher priceFetcher) {
		super(Skills.CRAFTING, priceFetcher);
	}

	@Override
	public void addTertiaryPrices() {
	}
}