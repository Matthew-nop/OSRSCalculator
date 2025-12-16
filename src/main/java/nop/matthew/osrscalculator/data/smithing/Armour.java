package nop.matthew.osrscalculator.data.smithing;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Armour implements Recipe {
	ADAMANT_PLATEBODY(
			Item.ADAMANT_PLATEBODY,
			88,
			312.5f,
			new ItemQuantity(Item.ADAMANTITE_BAR, 5)
	),
	ADAMANT_PLATELEGS(
			Item.ADAMANT_PLATELEGS,
			86,
			187.5f,
			new ItemQuantity(Item.ADAMANTITE_BAR, 3)
	),
	BRONZE_PLATEBODY(
			Item.BRONZE_PLATEBODY,
			18,
			62.5f,
			new ItemQuantity(Item.BRONZE_BAR, 5)
	),
	BRONZE_PLATELEGS(
			Item.BRONZE_PLATELEGS,
			16,
			37.5f,
			new ItemQuantity(Item.BRONZE_BAR, 3)
	),
	IRON_PLATEBODY(
			Item.IRON_PLATEBODY,
			33,
			125,
			new ItemQuantity(Item.IRON_BAR, 5)
	),
	IRON_PLATELEGS(
			Item.IRON_PLATELEGS,
			31,
			75,
			new ItemQuantity(Item.IRON_BAR, 3)
	),
	MITHRIL_PLATEBODY(
			Item.MITHRIL_PLATEBODY,
			68,
			250,
			new ItemQuantity(Item.MITHRIL_BAR, 5)
	),
	MITHRIL_PLATELEGS(
			Item.MITHRIL_PLATELEGS,
			66,
			150,
			new ItemQuantity(Item.MITHRIL_BAR, 3)
	),
	RUNE_PLATEBODY(
			Item.RUNE_PLATEBODY,
			99,
			375,
			new ItemQuantity(Item.RUNITE_BAR, 5)
	),
	RUNE_PLATELEGS(
			Item.RUNE_PLATELEGS,
			99,
			225,
			new ItemQuantity(Item.RUNITE_BAR, 3)
	),
	STEEL_PLATEBODY(
			Item.STEEL_PLATEBODY,
			48,
			187.5f,
			new ItemQuantity(Item.STEEL_BAR, 5)
	),
	STEEL_PLATELEGS(
			Item.STEEL_PLATELEGS,
			46,
			112.5f,
			new ItemQuantity(Item.STEEL_BAR, 3)
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
