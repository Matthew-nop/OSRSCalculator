package nop.matthew.osrscalculator.data.cooking;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Fish implements Recipe {
	ANCHOVIES(
			Item.ANCHOVIES,
			1,
			30,
			Item.RAW_ANCHOVIES
	),
	MARLIN(
			Item.MARLIN,
			91,
			225,
			Item.RAW_MARLIN
	),
	MONKFISH(
			Item.MONKFISH,
			62,
			150,
			Item.RAW_MONKFISH
	),
	SALMON(
			Item.SALMON,
			25,
			90,
			Item.RAW_SALMON
	),
	SHARK(
			Item.SHARK,
			80,
			210,
			Item.RAW_SHARK
	),
	SHRIMPS(
			Item.SHRIMPS,
			1,
			30,
			Item.RAW_SHRIMPS
	),
	TROUT(
			Item.TROUT,
			15,
			70,
			Item.RAW_TROUT
	),
	BASS(
			Item.BASS,
			43,
			130,
			Item.RAW_BASS
	),
	CAVE_EEL(
			Item.CAVE_EEL,
			38,
			115,
			Item.RAW_CAVE_EEL
	),
	COD(
			Item.COD,
			18,
			75,
			Item.RAW_COD
	),
	DARK_CRAB(
			Item.DARK_CRAB,
			90,
			215,
			Item.RAW_DARK_CRAB
	),
	ANGLERFISH(
			Item.ANGLERFISH,
			84,
			230,
			Item.RAW_ANGLERFISH
	),
	GIANT_KRILL(
			Item.GIANT_KRILL,
			69,
			177.5f,
			Item.RAW_GIANT_KRILL
	),
	KARAMBWAN(
			Item.KARAMBWAN,
			30,
			190,
			Item.RAW_KARAMBWAN
	),
	BLUEFIN(
			Item.BLUEFIN,
			87,
			215,
			Item.RAW_BLUEFIN
	),
	HADDOCK(
			Item.HADDOCK,
			73,
			180,
			Item.RAW_HADDOCK
	),
	HALIBUT(
			Item.HALIBUT,
			83,
			212.5f,
			Item.RAW_HALIBUT
	),
	HERRING(
			Item.HERRING,
			5,
			50,
			Item.RAW_HERRING
	),
	HARPOONFISH(
			Item.HARPOONFISH,
			1,
			10,
			Item.RAW_HARPOONFISH
	),
	LOBSTER(
			Item.LOBSTER,
			40,
			120,
			Item.RAW_LOBSTER
	),
	MACKEREL(
			Item.MACKEREL,
			10,
			60,
			Item.RAW_MACKEREL
	),
	JUMBO_SQUID(
			Item.JUMBO_SQUID,
			71,
			180,
			Item.RAW_JUMBO_SQUID
	),
	PIKE(
			Item.PIKE,
			20,
			80,
			Item.RAW_PIKE
	),
	RAINBOW_FISH(
			Item.RAINBOW_FISH,
			35,
			110,
			Item.RAW_RAINBOW_FISH
	),
	SEA_TURTLE(
			Item.SEA_TURTLE,
			82,
			211.3f,
			Item.RAW_SEA_TURTLE
	),
	SARDINE(
			Item.SARDINE,
			1,
			40,
			Item.RAW_SARDINE
	),
	SWORDFISH(
			Item.SWORDFISH,
			45,
			140,
			Item.RAW_SWORDFISH
	),
	TUNA(
			Item.TUNA,
			30,
			100,
			Item.RAW_TUNA
	),
	YELLOWFIN(
			Item.YELLOWFIN,
			79,
			200,
			Item.RAW_YELLOWFIN
	),
	SWORDTIP_SQUID(
			Item.SWORDTIP_SQUID,
			56,
			150,
			Item.RAW_SWORDTIP_SQUID
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity ingredients;

	Fish(ItemQuantity output, int level, float xp, ItemQuantity ingredients) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
	}

	Fish(Item output, int level, float xp, Item ingredients) {
		this.output = new ItemQuantity(output, 1);
		this.level = level;
		this.xp = xp;
		this.ingredients = new ItemQuantity(ingredients, 1);
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[]{ this.output };
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[]{ this.ingredients };
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
