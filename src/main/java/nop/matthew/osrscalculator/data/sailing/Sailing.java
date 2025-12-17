package nop.matthew.osrscalculator.data.sailing;

import nop.matthew.osrscalculator.data.Methods;
import nop.matthew.osrscalculator.data.Skill;
import nop.matthew.osrscalculator.data.Skills;

public class Sailing extends Skill {
	private static final Sailing sailing = new Sailing();

	private Sailing() {
		super(Skills.SAILING);
		this.methodRecipes.put(Methods.BARRACUDA_TRIALS, BarracudaTrials.values());
	}

	public static Sailing getInstance() {
		return sailing;
	}

	@Override
	public void addTertiaryPrices() {
	}
}