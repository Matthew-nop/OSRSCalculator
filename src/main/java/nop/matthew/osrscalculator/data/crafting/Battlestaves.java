package nop.matthew.osrscalculator.data.crafting;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Battlestaves implements Recipe {
	WATER_BATTLESTAFF(
			new ItemQuantity(Item.WATER_BATTLESTAFF, 1),
			54,
			100,
			new ItemQuantity[]{
					new ItemQuantity(Item.WATER_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	EARTH_BATTLESTAFF(
			new ItemQuantity(Item.EARTH_BATTLESTAFF, 1),
			58,
			112.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.EARTH_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	FIRE_BATTLESTAFF(
			new ItemQuantity(Item.FIRE_BATTLESTAFF, 1),
			62,
			125,
			new ItemQuantity[]{
					new ItemQuantity(Item.FIRE_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	AIR_BATTLESTAFF(
			new ItemQuantity(Item.AIR_BATTLESTAFF, 1),
			66,
			137.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.AIR_ORB, 1),
					new ItemQuantity(Item.BATTLESTAFF, 1),
			}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	Battlestaves(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
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
		return output.getName();
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
		return getClass().getResource("/Items/" + this.output.getId() + ".png");
	}
}
