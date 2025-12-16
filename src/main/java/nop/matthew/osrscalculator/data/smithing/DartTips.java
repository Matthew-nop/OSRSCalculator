package nop.matthew.osrscalculator.data.smithing;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum DartTips implements Recipe {
	BRONZE_DART_TIPS(
			new ItemQuantity(Item.BRONZE_DART_TIP, 10),
			4,
			12.5f,
			Item.BRONZE_BAR
	),
	IRON_DART_TIPS(
			new ItemQuantity(Item.IRON_DART_TIP, 10),
			19,
			25,
			Item.IRON_BAR
	),
	STEEL_DART_TIPS(
			new ItemQuantity(Item.STEEL_DART_TIP, 10),
			34,
			37.5f,
			Item.STEEL_BAR
	),
	MITHRIL_DART_TIPS(
			new ItemQuantity(Item.MITHRIL_DART_TIP, 10),
			54,
			50,
			Item.MITHRIL_BAR
	),
	ADAMANT_DART_TIPS(
			new ItemQuantity(Item.ADAMANT_DART_TIP, 10),
			74,
			62.5f,
			Item.ADAMANTITE_BAR
	),
	RUNE_DART_TIPS(
			new ItemQuantity(Item.RUNE_DART_TIP, 10),
			89,
			75,
			Item.RUNITE_BAR
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	DartTips(ItemQuantity output, int level, float xp, Item ingredient) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredient = new ItemQuantity(ingredient, 1);
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[]{this.ingredient };
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
