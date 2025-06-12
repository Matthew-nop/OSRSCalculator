package nop.matthew.osrscalculator.data.firemaking;import nop.matthew.osrscalculator.data.Flags;

import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum PyreLogs implements Recipe {
	PYRE_LOGS(5, 50, new ItemQuantity(Item.PYRE_LOGS, 1)),
	OAK_PYRE_LOGS(20, 70, new ItemQuantity(Item.OAK_PYRE_LOGS, 1)),
	WILLOW_PYRE_LOGS(35, 100, new ItemQuantity(Item.WILLOW_PYRE_LOGS, 1)),
	TEAK_PYRE_LOGS(40, 120, new ItemQuantity(Item.TEAK_PYRE_LOGS, 1)),
	ARCTIC_PYRE_LOGS(47, 158, new ItemQuantity(Item.ARCTIC_PYRE_LOGS, 1)),
	MAPLE_PYRE_LOGS(50, 175, new ItemQuantity(Item.MAPLE_PYRE_LOGS, 1)),
	MAHOGANY_PYRE_LOGS(55, 210, new ItemQuantity(Item.MAHOGANY_PYRE_LOGS, 1)),
	YEW_PYRE_LOGS(65, 255, new ItemQuantity(Item.YEW_PYRE_LOGS, 1)),
	MAGIC_PYRE_LOGS(80, 404.5f, new ItemQuantity(Item.MAGIC_PYRE_LOGS, 1)),
	REDWOOD_PYRE_LOGS(95, 500, new ItemQuantity(Item.REDWOOD_PYRE_LOGS, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	PyreLogs(int level, float xp, ItemQuantity ingredient) {
		this.level = level;
		this.xp = xp;
		this.ingredient = ingredient;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[]{this.ingredient};
	}

	@Override
	public String getName() {
		return this.ingredient.getName();
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public float getXp() {
		return this.xp;
	}

	@Override
	public boolean flagAffects(Flags flag) {
		return flag == Flags.PYROMANCER_OUTFIT;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.ingredient.getId() + " - " + this.getName().toLowerCase() + " detail.png");
	}
}
