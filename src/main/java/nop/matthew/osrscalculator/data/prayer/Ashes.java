package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.util.Set;

public enum Ashes implements Recipe {
	ABYSSAL_ASHES(1, 85, new ItemQuantity(Item.ABYSSAL_ASHES, 1)),
	FIENDISH_ASHES(1, 10, new ItemQuantity(Item.FIENDISH_ASHES, 1)),
	INFERNAL_ASHES(1, 110, new ItemQuantity(Item.INFERNAL_ASHES, 1)),
	MALICIOUS_ASHES(1, 65, new ItemQuantity(Item.MALICIOUS_ASHES, 1)),
	VILE_ASHES(1, 25, new ItemQuantity(Item.VILE_ASHES, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Ashes(int level, float xp, ItemQuantity ingredient) {
		this.level = level;
		this.xp = xp;
		this.ingredient = ingredient;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients() {
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
	public boolean flagsAffect(Set<Flags> flag) {
		return false;
	}

	@Override
	public boolean flagsAffect(Flags flag) {
		return false;
	}
}
