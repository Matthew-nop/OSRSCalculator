package nop.matthew.osrscalculator.data.sailing;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum BarracudaTrials implements Recipe {
	TEMPOR_TANTRUM_SWORDFISH("Tempor Tantrum: Swordfish", 30, 595, Item.STORMY_KEY),
	TEMPOR_TANTRUM_SHARK("Tempor Tantrum: Shark", 30, 1025, Item.BARREL_STAND),
	TEMPOR_TANTRUM_MARLIN("Tempor Tantrum: Marlin", 30, 1790, Item.RALPHS_FABRIC_ROLL),
	JUBBLY_JIVE_SWORDFISH("Jubbly Jive: Swordfish", 55, 2392 , Item.FETID_KEY),
	JUBBLY_JIVE_SHARK("Jubbly Jive: Shark", 55, 4270, Item.CAPTURED_WIND_MOTE),
	JUBBLY_JIVE_MARLIN("Jubbly Jive: Marlin", 55, 8204, Item.GURTOBS_FABRIC_ROLL),
	GWENITH_GLIDE_SWORDFISH("Gwenith Glide: Swordfish", 72, 4100, Item.SERRATED_KEY),
	GWENITH_GLIDE_SHARK("Gwenith Glide: Shark", 72, 9315, Item.HEART_OF_ITHELL),
	GWENITH_GLIDE_MARLIN("Gwenith Glide: Marlin", 72, 19410, Item.GWYNAS_FABRIC_ROLL),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final Item iconItem;

	BarracudaTrials(String name, int level, float xp, Item iconItem) {
		this.name = name;
		this.level = level;
		this.xp = xp;
		this.iconItem = iconItem;
	}

	@Override
	public ItemQuantity[] getOutput() {
		return new ItemQuantity[0];
	}

	@Override
	public ItemQuantity[] getIngredients(Set<Flags> flags) {
		return new ItemQuantity[0];
	}

	@Override
	public String getName() {
		return this.name;
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
		return getClass().getResource("/Items/" + this.iconItem.getId() + ".png");
	}
}
