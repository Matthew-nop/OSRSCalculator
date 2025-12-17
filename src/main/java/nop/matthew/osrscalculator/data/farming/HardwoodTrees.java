package nop.matthew.osrscalculator.data.farming;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum HardwoodTrees implements Recipe {
	CAMPHOR(
			66,
			17928,
			Item.CAMPHOR_SAPLING,
			Item.CAMPHOR_SEED
	),
	IRONWOOD(
			80,
			20525,
			Item.IRONWOOD_SAPLING,
			Item.IRONWOOD_SEED
	),
	MAHOGANY(
			55,
			15783,
			Item.MAHOGANY_SAPLING,
			Item.MAHOGANY_SEED
	),
	ROSEWOOD(
			92,
			23352,
			Item.ROSEWOOD_SAPLING,
			Item.ROSEWOOD_SEED
	),
	TEAK(
			35,
			7325,
			Item.TEAK_SAPLING,
			Item.TEAK_SEED
	),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;
	private final Item iconItem;

	HardwoodTrees(int level, float xp, Item ingredient, Item iconItem) {
		this.level = level;
		this.xp = xp;
		this.ingredient = new ItemQuantity(ingredient, 1);
		this.iconItem = iconItem;
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
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.iconItem.getId() + ".png");
	}
}
