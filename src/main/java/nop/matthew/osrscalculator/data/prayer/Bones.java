package nop.matthew.osrscalculator.data.prayer;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum Bones implements Recipe {
	BONES(1, 4.5f, new ItemQuantity(Item.BONES, 1)),
	BURNT_BONES(1, 4.5f, new ItemQuantity(Item.BURNT_BONES, 1)),
	WOLF_BONES(1, 4.5f, new ItemQuantity(Item.WOLF_BONES, 1)),
	MONKEY_BONES(1, 5,  new ItemQuantity(Item.MONKEY_BONES, 1)),
	BAT_BONES(1, 5.3f, new ItemQuantity(Item.BAT_BONES, 1)),
	BIG_BONES(1, 15, new ItemQuantity(Item.BIG_BONES, 1)),
	JOGRE_BONES(1, 15, new ItemQuantity(Item.JOGRE_BONES, 1)),
	ZOGRE_BONES(1, 15, new ItemQuantity(Item.ZOGRE_BONES, 1)),
	SHAIKAHAN_BONES(1, 25, new ItemQuantity(Item.SHAIKAHAN_BONES, 1)),
	BABYDRAGON_BONES(1, 30, new ItemQuantity(Item.BABYDRAGON_BONES, 1)),
	WYRM_BONES(1, 50, new ItemQuantity(Item.WYRM_BONES, 1)),
	DRAGON_BONES(1, 72, new ItemQuantity(Item.DRAGON_BONES, 1)),
	WYVERN_BONES(1, 72, new ItemQuantity(Item.WYVERN_BONES, 1)),
	DRAKE_BONES(1, 80, new ItemQuantity(Item.DRAKE_BONES, 1)),
	FAYRG_BONES(1, 84, new ItemQuantity(Item.FAYRG_BONES, 1)),
	LAVA_DRAGON_BONES(1, 85, new ItemQuantity(Item.LAVA_DRAGON_BONES, 1)),
	RAURG_BONES(1, 96, new ItemQuantity(Item.RAURG_BONES, 1)),
	HYDRA_BONES(1, 110, new ItemQuantity(Item.HYDRA_BONES, 1)),
	DAGANNOTH_BONES(1, 125, new ItemQuantity(Item.DAGANNOTH_BONES, 1)),
	OURG_BONES(1, 140, new ItemQuantity(Item.OURG_BONES, 1)),
	SUPERIOR_DRAGON_BONES(70, 150, new ItemQuantity(Item.SUPERIOR_DRAGON_BONES, 1)),
	;

	private final int level;
	private final float xp;
	private final ItemQuantity ingredient;

	Bones(int level, float xp, ItemQuantity ingredient) {
		this.level = level;
		this.xp = xp;
		this.ingredient = ingredient;
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
