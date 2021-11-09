package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;
import nop.matthew.osrscalculator.net.PriceFetcher;

public class Construction extends Skill {
	public Construction(PriceFetcher priceFetcher) {
		super(Skills.CONSTRUCTION, priceFetcher);
		this.methodRecipes.put(Methods.PLANKS, Planks.values());
	}

	@Override
	public void addTertiaryPrices() {
	}
}
