package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Planks implements Recipe {
	PLANKS(
			1,
			29,
			new ItemQuantity(Item.PLANK, 1)),
	OAK_PLANKS(
			15,
			60,
			new ItemQuantity(Item.OAK_PLANK, 1)),
	TEAK_PLANKS(
			35,
			90,
			new ItemQuantity(Item.TEAK_PLANK, 1)),
	MAHOGANY_PLANKS(
			40,
			140,
			new ItemQuantity(Item.MAHOGANY_PLANK, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Planks(int level, float xp, ItemQuantity ingredient) {
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
		return flag == Flags.CARPENTERS_OUTFIT;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.ingredient.getId() + " - " + this.getName().toLowerCase() + " detail.png");
	}
}
