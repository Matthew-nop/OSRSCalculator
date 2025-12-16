package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Recipe;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Construction extends Skill {
	private static final Construction construction = new Construction();

	private Construction() {
		super(Skills.CONSTRUCTION);
		this.methodRecipes.put(Methods.PLANKS, Planks.values());
		this.methodRecipes.put(Methods.REPAIR_KITS, RepairKits.values());
	}

	public static Construction getInstance() {
		return construction;
	}

	@Override
	public void addTertiaryPrices() {
	}

	@Override
	public double getXp(Recipe recipe) {
		return this.flags.contains(Flags.CARPENTERS_OUTFIT) ? super.getXp(recipe) * 1.025d : super.getXp(recipe);
	}
}
