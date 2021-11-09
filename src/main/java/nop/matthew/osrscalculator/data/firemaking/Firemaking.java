package nop.matthew.osrscalculator.data.firemaking;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Firemaking extends Skill {
	public Firemaking(PriceFetcher priceFetcher) {
		super(Skills.FIREMAKING, priceFetcher);
		this.methodRecipes.put(Methods.BURNING_LOGS, Logs.values());
	}

	@Override
	public void addTertiaryPrices() {
	}
}