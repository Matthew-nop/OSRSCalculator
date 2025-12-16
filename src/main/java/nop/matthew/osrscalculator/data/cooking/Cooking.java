package nop.matthew.osrscalculator.data.cooking;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Cooking extends Skill {
	private static final Cooking cooking = new Cooking();

	private Cooking() {
		super(Skills.COOKING);
		methodRecipes.put(Methods.COOKING_FISH, Fish.values());
	}

	public static Cooking getInstance() {
		return cooking;
	}

	@Override
	public void addTertiaryPrices() {
	}
}