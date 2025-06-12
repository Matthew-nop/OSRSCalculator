package nop.matthew.osrscalculator.data.crafting;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Dragonleather implements Recipe {
	GREEN_DHIDE_BODY(
			new ItemQuantity(Item.GREEN_DHIDE_BODY, 1),
			63,
			186,
			new ItemQuantity[]{
					new ItemQuantity(Item.GREEN_DRAGON_LEATHER, 3),
					new ItemQuantity(Item.THREAD, 0.6f)
			}
	),
	BLUE_DHIDE_BODY(
			new ItemQuantity(Item.BLUE_DHIDE_BODY, 1),
			71,
			210,
			new ItemQuantity[]{
					new ItemQuantity(Item.BLUE_DRAGON_LEATHER, 3),
					new ItemQuantity(Item.THREAD, 0.6f)
			}
	),
	RED_DHIDE_BODY(
			new ItemQuantity(Item.RED_DHIDE_BODY, 1),
			77,
			234,
			new ItemQuantity[]{
					new ItemQuantity(Item.RED_DRAGON_LEATHER, 3),
					new ItemQuantity(Item.THREAD, 0.6f)
			}
	),
	BLACK_DHIDE_BODY(
			new ItemQuantity(Item.BLACK_DHIDE_BODY, 1),
			84,
			258,
			new ItemQuantity[]{
					new ItemQuantity(Item.BLACK_DRAGON_LEATHER, 3),
					new ItemQuantity(Item.THREAD, 0.6f)
			}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	Dragonleather(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return this.ingredients;
	}

	@Override
	public String getName() {
		return this.output.getName();
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
		return getClass().getResource("/Items/" + this.output.getId() + " - " + this.output.getName().toLowerCase() + " detail.png");
	}
}
