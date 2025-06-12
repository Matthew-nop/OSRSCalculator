package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Prayer extends Skill {
	private static final Prayer prayer = new Prayer();

	private Prayer() {
		super(Skills.PRAYER);
		this.methodRecipes.put(Methods.ASHES, Ashes.values());
	}

	public static Prayer getInstance() {
		return prayer;
	}

	@Override
	public void addTertiaryPrices() {
	}
}