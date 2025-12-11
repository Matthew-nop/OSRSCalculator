package nop.matthew.osrscalculator.data.firemaking;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Logs implements Recipe {
	LOGS(1,
			40,
			new ItemQuantity(Item.LOGS, 1)),
	ACHEY_TREE_LOGS(
			1,
			40,
			new ItemQuantity(Item.ACHEY_TREE_LOGS, 1)),
	OAK_LOGS(
			15,
			60,
			new ItemQuantity(Item.OAK_LOGS, 1)),
	WILLOW_LOGS(
			30,
			90,
			new ItemQuantity(Item.WILLOW_LOGS, 1)),
	TEAK_LOGS(
			35,
			105,
			new ItemQuantity(Item.TEAK_LOGS, 1)),
	ARCTIC_PINE_LOGS(
			42,
			125,
			new ItemQuantity(Item.ARCTIC_PINE_LOGS, 1)),
	MAPLE_LOGS(
			45,
			135,
			new ItemQuantity(Item.MAPLE_LOGS, 1)),
	MAHOGANY_LOGS(
			50,
			157.5f,
			new ItemQuantity(Item.MAHOGANY_LOGS, 1)),
	YEW_LOGS(
			60,
			202.5f,
			new ItemQuantity(Item.YEW_LOGS, 1)),
	BLISTERWOOD_LOGS(
			62,
			96,
			new ItemQuantity(Item.BLISTERWOOD_LOGS, 1)),
	MAGIC_LOGS(
			75,
			303.8f,
			new ItemQuantity(Item.MAGIC_LOGS, 1)),
	REDWOOD_LOGS(
			90,
			350,
			new ItemQuantity(Item.REDWOOD_LOGS, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Logs(int level, float xp, ItemQuantity ingredient) {
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
		return new ItemQuantity[]{ingredient};
	}

	@Override
	public String getName() {
		return ingredient.getName();
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
		return getClass().getResource("/Items/" + this.ingredient.getId() + ".png");
	}
}
