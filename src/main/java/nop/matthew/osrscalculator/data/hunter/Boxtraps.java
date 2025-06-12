package nop.matthew.osrscalculator.data.hunter;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Boxtraps implements Recipe {
	CHINCHOMPAS(
			new ItemQuantity(Item.CHINCHOMPA, 1),
			1,
			198.4f
	),
	RED_CHINCHOMPAS(
			new ItemQuantity(Item.RED_CHINCHOMPA, 1),
			15,
			265
	),
	BLACK_CHINCHOMPAS(
			new ItemQuantity(Item.BLACK_CHINCHOMPA, 1),
			35,
			315
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;

	Boxtraps(ItemQuantity output, int level, float xp) {
		this.output = output;
		this.level = level;
		this.xp = xp;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[0];
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
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.output.getId() + " - " + this.output.getName().toLowerCase() + " detail.png");
	}
}
