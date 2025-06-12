package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
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

	@Override
	public double getXp(Recipe recipe) {
		return this.flags.contains(Flags.CARPENTERS_OUTFIT) ? super.getXp(recipe) * 1.025d : super.getXp(recipe);
	}
}
