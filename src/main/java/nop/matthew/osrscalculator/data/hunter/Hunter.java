package nop.matthew.osrscalculator.data.hunter;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Hunter extends Skill {
	private static final Hunter hunter = new Hunter();

	private Hunter() {
		super(Skills.HUNTER);
		this.methodRecipes.put(Methods.BOXTRAPS, Boxtraps.values());
	}

	public static Hunter getInstance() {
		return hunter;
	}

	@Override
	protected void addTertiaryPrices() {
	}
}
