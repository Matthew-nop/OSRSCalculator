package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Bones implements Recipe {
	BABYDRAGON_BONES(1, 30, Item.BABYDRAGON_BONES),
	BAT_BONES(1, 5.3f, Item.BAT_BONES),
	BIG_BONES(1, 15, Item.BIG_BONES),
	BONES(1, 4.5f, Item.BONES),
	BURNT_BONES(1, 4.5f, Item.BURNT_BONES),
	DAGANNOTH_BONES(1, 125, Item.DAGANNOTH_BONES),
	DRAGON_BONES(1, 72, Item.DRAGON_BONES),
	DRAKE_BONES(1, 80, Item.DRAKE_BONES),
	FAYRG_BONES(1, 84, Item.FAYRG_BONES),
	FROST_DRAGON_BONES(1, 100, Item.FROST_DRAGON_BONES),
	HYDRA_BONES(1, 110, Item.HYDRA_BONES),
	JOGRE_BONES(1, 15, Item.JOGRE_BONES),
	LAVA_DRAGON_BONES(1, 85, Item.LAVA_DRAGON_BONES),
	MONKEY_BONES(1, 5, Item.MONKEY_BONES),
	OURG_BONES(1, 140, Item.OURG_BONES),
	RAURG_BONES(1, 96, Item.RAURG_BONES),
	SHAIKAHAN_BONES(1, 25, Item.SHAIKAHAN_BONES),
	SUPERIOR_DRAGON_BONES(1, 150, Item.SUPERIOR_DRAGON_BONES),
	WOLF_BONES(1, 4.5f, Item.WOLF_BONES),
	WYRM_BONES(1, 50, Item.WYRM_BONES),
	WYVERN_BONES(1, 72, Item.WYVERN_BONES),
	ZOGRE_BONES(1, 15, Item.ZOGRE_BONES),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Bones(int level, float xp, Item ingredient) {
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
		return ingredient.getName();
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
