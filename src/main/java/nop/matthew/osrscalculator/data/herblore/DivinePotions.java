package nop.matthew.osrscalculator.data.herblore;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.net.URL;
import java.util.Set;

public enum DivinePotions implements Recipe {
	DIVINE_BASTION_POTION1(
			new ItemQuantity(Item.DIVINE_BASTION_POTION1, 1),
			86,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.BASTION_POTION1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_BASTION_POTION2, 1)),
	DIVINE_BASTION_POTION2(
			new ItemQuantity(Item.DIVINE_BASTION_POTION2, 1),
			86,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.BASTION_POTION2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_BASTION_POTION3, 1)),
	DIVINE_BASTION_POTION3(
			new ItemQuantity(Item.DIVINE_BASTION_POTION3, 1),
			86,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.BASTION_POTION3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_BASTION_POTION4, 1)),
	DIVINE_BASTION_POTION4(
			new ItemQuantity(Item.DIVINE_BASTION_POTION4, 1),
			86,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.BASTION_POTION4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_BATTLEMAGE_POTION1(
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION1, 1),
			86,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.BATTLEMAGE_POTION1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION2, 1)),
	DIVINE_BATTLEMAGE_POTION2(
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION2, 1),
			86,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.BATTLEMAGE_POTION2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION3, 1)),
	DIVINE_BATTLEMAGE_POTION3(
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION3, 1),
			86,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.BATTLEMAGE_POTION3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION4, 1)),
	DIVINE_BATTLEMAGE_POTION4(
			new ItemQuantity(Item.DIVINE_BATTLEMAGE_POTION4, 1),
			86,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.BATTLEMAGE_POTION4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_MAGIC_POTION1(
			new ItemQuantity(Item.DIVINE_MAGIC_POTION1, 1),
			78,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.MAGIC_POTION1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_MAGIC_POTION2, 1)),
	DIVINE_MAGIC_POTION2(
			new ItemQuantity(Item.DIVINE_MAGIC_POTION2, 1),
			78,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.MAGIC_POTION2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_MAGIC_POTION3, 1)),
	DIVINE_MAGIC_POTION3(
			new ItemQuantity(Item.DIVINE_MAGIC_POTION3, 1),
			78,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.MAGIC_POTION3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_MAGIC_POTION4, 1)),
	DIVINE_MAGIC_POTION4(
			new ItemQuantity(Item.DIVINE_MAGIC_POTION4, 1),
			78,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.MAGIC_POTION4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_RANGING_POTION1(
			new ItemQuantity(Item.DIVINE_RANGING_POTION1, 1),
			74,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.RANGING_POTION1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_RANGING_POTION2, 1)),
	DIVINE_RANGING_POTION2(
			new ItemQuantity(Item.DIVINE_RANGING_POTION2, 1),
			74,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.RANGING_POTION2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_RANGING_POTION3, 1)),
	DIVINE_RANGING_POTION3(
			new ItemQuantity(Item.DIVINE_RANGING_POTION3, 1),
			74,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.RANGING_POTION3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_RANGING_POTION4, 1)),
	DIVINE_RANGING_POTION4(
			new ItemQuantity(Item.DIVINE_RANGING_POTION4, 1),
			74,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.RANGING_POTION4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_SUPER_ATTACK_POTION1(
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION1, 1),
			70,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ATTACK1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION2, 1)),
	DIVINE_SUPER_ATTACK_POTION2(
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION2, 1),
			70,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ATTACK2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION3, 1)),
	DIVINE_SUPER_ATTACK_POTION3(
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION3, 1),
			70,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ATTACK3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION4, 1)),
	DIVINE_SUPER_ATTACK_POTION4(
			new ItemQuantity(Item.DIVINE_SUPER_ATTACK_POTION4, 1),
			70,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ATTACK4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_SUPER_COMBAT_POTION1(
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION1, 1),
			97,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_COMBAT_POTION1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION2, 1)),
	DIVINE_SUPER_COMBAT_POTION2(
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION2, 1),
			97,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_COMBAT_POTION2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION3, 1)),
	DIVINE_SUPER_COMBAT_POTION3(
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION3, 1),
			97,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_COMBAT_POTION3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION4, 1)),
	DIVINE_SUPER_COMBAT_POTION4(
			new ItemQuantity(Item.DIVINE_SUPER_COMBAT_POTION4, 1),
			97,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_COMBAT_POTION4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_SUPER_DEFENCE_POTION1(
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION1, 1),
			70,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_DEFENCE1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION2, 1)),
	DIVINE_SUPER_DEFENCE_POTION2(
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION2, 1),
			70,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_DEFENCE2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION3, 1)),
	DIVINE_SUPER_DEFENCE_POTION3(
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION3, 1),
			70,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_DEFENCE3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION4, 1)),
	DIVINE_SUPER_DEFENCE_POTION4(
			new ItemQuantity(Item.DIVINE_SUPER_DEFENCE_POTION4, 1),
			70,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_DEFENCE4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	DIVINE_SUPER_STRENGTH_POTION1(
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION1, 1),
			70,
			0.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_STRENGTH1, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 1)
			},
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION2, 1)),
	DIVINE_SUPER_STRENGTH_POTION2(
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION2, 1),
			70,
			1,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_STRENGTH2, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 2)
			},
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION3, 1)),
	DIVINE_SUPER_STRENGTH_POTION3(
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION3, 1),
			70,
			1.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_STRENGTH3, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 3)
			},
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION4, 1)),
	DIVINE_SUPER_STRENGTH_POTION4(
			new ItemQuantity(Item.DIVINE_SUPER_STRENGTH_POTION4, 1),
			70,
			2,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_STRENGTH4, 1),
					new ItemQuantity(Item.CRYSTAL_DUST, 4)
			}),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;
	// The outcome potion given an amulet proc (e.g. 3-dose -> 4-dose (this one))
	private final ItemQuantity amuletItemQuantity;

	DivinePotions(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients, ItemQuantity amuletItemQuantity) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
		this.amuletItemQuantity = amuletItemQuantity;
	}

	DivinePotions(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
		this(output, level, xp, ingredients, null);
	}

	@Override
	public ItemQuantity[] getOutput() {
		return (this.amuletItemQuantity != null) ? new ItemQuantity[]{this.output, this.amuletItemQuantity} : new ItemQuantity[]{this.output};
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
		return (flag == Flags.AMULET_OF_CHEMISTRY && this.amuletItemQuantity != null);
	}

	@Override
	public URL getIconPath() {
		return getClass().getResource("/Items/" + this.output.getId() + ".png");
	}
}
