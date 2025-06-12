package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Prayer extends Skill {
	public Prayer() {
		super(Skills.PRAYER);
		this.methodRecipes.put(Methods.ASHES, Ashes.values());
	}

	@Override
	public void addTertiaryPrices() {
	}
}