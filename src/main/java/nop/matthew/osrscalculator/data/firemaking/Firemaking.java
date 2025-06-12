package nop.matthew.osrscalculator.data.firemaking;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Firemaking extends Skill {
	private static final Firemaking firemaking = new Firemaking();

	private Firemaking() {
		super(Skills.FIREMAKING);
		this.methodRecipes.put(Methods.BURNING_LOGS, Logs.values());
		this.methodRecipes.put(Methods.CREMATING_SHADES, PyreLogs.values());
	}

	public static Firemaking getInstance() {
		return firemaking;
	}

	@Override
	public void addTertiaryPrices() {
	}

	@Override
	public double getXp(Recipe recipe) {
		return this.flags.contains(Flags.PYROMANCER_OUTFIT) ? super.getXp(recipe) * 1.025d : super.getXp(recipe);
	}
}