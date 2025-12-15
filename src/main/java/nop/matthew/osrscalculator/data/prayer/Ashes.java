package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Ashes implements Recipe {
	ABYSSAL_ASHES(1, 85, Item.ABYSSAL_ASHES),
	FIENDISH_ASHES(1, 10, Item.FIENDISH_ASHES),
	INFERNAL_ASHES(1, 110, Item.INFERNAL_ASHES),
	MALICIOUS_ASHES(1, 65, Item.MALICIOUS_ASHES),
	VILE_ASHES(1, 25, Item.VILE_ASHES),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Ashes(int level, float xp, Item ingredient) {
		this.level = level;
		this.xp = xp;
		this.ingredient = new ItemQuantity(ingredient, 1);
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
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.ingredient.getId() + ".png");
	}
}
