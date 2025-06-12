package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.util.Set;

public enum Planks implements Recipe {
	PLANKS(
			1,
			29,
			new ItemQuantity[]{new ItemQuantity(Item.PLANK, 1)}),
	OAK_PLANKS(
			15,
			60,
			new ItemQuantity[]{new ItemQuantity(Item.OAK_PLANK, 1)}),
	TEAK_PLANKS(
			35,
			90,
			new ItemQuantity[]{new ItemQuantity(Item.PLANK, 1)}),
	MAHOGANY_PLANKS(
			35,
			90,
			new ItemQuantity[]{new ItemQuantity(Item.PLANK, 1)}),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	Planks(int level, float xp, ItemQuantity[] ingredients) {
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients() {
		return ingredients;
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
	public boolean flagsAffect(Set<Flags> flag) {
		return false;
	}

	@Override
	public boolean flagsAffect(Flags flag) {
		return false;
	}
}
