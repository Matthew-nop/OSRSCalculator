package nop.matthew.osrscalculator.data.firemaking;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Firemaking extends Skill {
	public Firemaking() {
		super(Skills.FIREMAKING);
		this.methodRecipes.put(Methods.BURNING_LOGS, Logs.values());
	}

	@Override
	public void addTertiaryPrices() {
	}
}