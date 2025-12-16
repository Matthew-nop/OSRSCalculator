package nop.matthew.osrscalculator.data.construction;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum RepairKits implements Recipe {
	REPAIR_KIT(
		new ItemQuantity(Item.REPAIR_KIT, 2),
		1,
		43.5f,
		new ItemQuantity[]{
			new ItemQuantity(Item.PLANK, 2),
			new ItemQuantity(Item.BRONZE_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	OAK_REPAIR_KIT(
		new ItemQuantity(Item.OAK_REPAIR_KIT, 2),
		19,
		90,
		new ItemQuantity[]{
			new ItemQuantity(Item.OAK_PLANK, 2),
			new ItemQuantity(Item.IRON_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	TEAK_REPAIR_KIT(
		new ItemQuantity(Item.TEAK_REPAIR_KIT, 2),
		30,
		135,
		new ItemQuantity[]{
			new ItemQuantity(Item.TEAK_PLANK, 2),
			new ItemQuantity(Item.STEEL_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	MAHOGANY_REPAIR_KIT(
		new ItemQuantity(Item.MAHOGANY_REPAIR_KIT, 2),
		47,
		210,
		new ItemQuantity[]{
			new ItemQuantity(Item.MAHOGANY_PLANK, 2),
			new ItemQuantity(Item.MITHRIL_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	CAMPHOR_REPAIR_KIT(
		new ItemQuantity(Item.CAMPHOR_REPAIR_KIT, 2),
		66,
		255,
		new ItemQuantity[]{
			new ItemQuantity(Item.CAMPHOR_PLANK, 2),
			new ItemQuantity(Item.ADAMANTITE_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	IRONWOOD_REPAIR_KIT(
		new ItemQuantity(Item.IRONWOOD_REPAIR_KIT, 3),
		80,
		300,
		new ItemQuantity[]{
			new ItemQuantity(Item.IRONWOOD_PLANK, 1),
			new ItemQuantity(Item.RUNE_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	ROSEWOOD_REPAIR_KIT(
		new ItemQuantity(Item.ROSEWOOD_REPAIR_KIT, 3),
		92,
		330,
		new ItemQuantity[]{
			new ItemQuantity(Item.ROSEWOOD_PLANK, 2),
			new ItemQuantity(Item.DRAGON_NAILS, 10),
			new ItemQuantity(Item.SWAMP_PASTE, 5)
		}
	),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;

	RepairKits(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
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
		return false;
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.output.getId() + ".png");
	}
}


