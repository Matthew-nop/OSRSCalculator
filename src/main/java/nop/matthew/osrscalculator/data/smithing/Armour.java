package nop.matthew.osrscalculator.data.smithing;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Armour implements Recipe {
	BRONZE_PLATEBODY(
		Item.BRONZE_PLATEBODY,
		18,
		62.5f,
		new ItemQuantity(Item.BRONZE_BAR, 5)
	),
	IRON_PLATEBODY(
		Item.IRON_PLATEBODY,
		33,
		125,
		new ItemQuantity(Item.IRON_BAR, 5)
	),
	STEEL_PLATEBODY(
		Item.STEEL_PLATEBODY,
		48,
		187.5f,
		new ItemQuantity(Item.STEEL_BAR, 5)
	),
	MITHRIL_PLATEBODY(
		Item.MITHRIL_PLATEBODY,
		68,
		250,
		new ItemQuantity(Item.MITHRIL_BAR, 5)
	),
	ADAMANT_PLATEBODY(
		Item.ADAMANT_PLATEBODY,
		88,
		312.5f,
		new ItemQuantity(Item.ADAMANTITE_BAR, 5)
	),
	RUNE_PLATEBODY(
		Item.RUNE_PLATEBODY,
		99,
		375,
		new ItemQuantity(Item.RUNITE_BAR, 5)
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity ingredients;

	Armour(Item output, int level, float xp, ItemQuantity ingredients) {
		this.output = new ItemQuantity(output, 1);
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
		return new ItemQuantity[]{this.ingredients};
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
		return getClass().getResource("/Items/" + this.output.getId() + ".png");
	}
}
