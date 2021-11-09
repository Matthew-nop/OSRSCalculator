package nop.matthew.osrscalculator.data.herblore;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemID;
import nop.matthew.osrscalculator.data.Recipe;

import java.util.Set;

public enum Potions implements Recipe {
	AGILITY_POTION(ItemID.AGILITY_POTION3,
			34,
			80,
			new Item[]{
					new Item(ItemID.TOADFLAX_POTION_UNF, 1),
					new Item(ItemID.TOADS_LEGS, 1)
			},
			ItemID.AGILITY_POTION4),
	ANTIDOTE_PLUS(
			ItemID.ANTIDOTE4,
			68,
			155,
			new Item[]{
					new Item(ItemID.COCONUT_MILK, 1),
					new Item(ItemID.TOADFLAX, 1),
					new Item(ItemID.YEW_ROOTS, 1)
			}),
	ANTIDOTE_PLUS_PLUS(
			ItemID.ANTIDOTE4_5952,
			79,
			177.5f,
			new Item[]{
					new Item(ItemID.COCONUT_MILK, 1),
					new Item(ItemID.IRIT_LEAF, 1),
					new Item(ItemID.MAGIC_ROOTS, 1)
			}),
	ANTIFIRE_POTION(
			ItemID.ANTIFIRE_POTION3,
			69,
			157.5f,
			new Item[]{
					new Item(ItemID.DRAGON_SCALE_DUST, 1),
					new Item(ItemID.LANTADYME_POTION_UNF, 1)
			},
			ItemID.ANTIFIRE_POTION4),
	ANTIPOISON(
			ItemID.ANTIPOISON3,
			5,
			37.5f,
			new Item[]{
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.MARRENTILL_POTION_UNF, 1)
			},
			ItemID.ANTIPOISON4),
	ANTIVENOM1(
			ItemID.ANTIVENOM3,
			87,
			30,
			new Item[]{
					new Item(ItemID.ZULRAHS_SCALES, 5),
					new Item(ItemID.ANTIDOTE4_5952, 1)
			},
			ItemID.ANTIVENOM2),
	ANTIVENOM2(
			ItemID.ANTIVENOM4,
			87,
			60,
			new Item[]{
					new Item(ItemID.ZULRAHS_SCALES, 10),
					new Item(ItemID.ANTIDOTE4_5952, 1)
			},
			ItemID.ANTIVENOM3),
	ANTIVENOM3(
			ItemID.ANTIVENOM3,
			87,
			90,
			new Item[]{
					new Item(ItemID.ZULRAHS_SCALES, 15),
					new Item(ItemID.ANTIDOTE4_5952, 1)
			},
			ItemID.ANTIVENOM4),
	ANTIVENOM4(
			ItemID.ANTIVENOM4,
			87,
			120,
			new Item[]{
					new Item(ItemID.ZULRAHS_SCALES, 20),
					new Item(ItemID.ANTIDOTE4_5952, 1)
			}),
	ANTIVENOM_PLUS(
			ItemID.ANTIVENOM4_12913,
			94,
			125,
			new Item[]{
					new Item(ItemID.ANTIVENOM4, 1),
					new Item(ItemID.TORSTOL, 1)
			}),
	ATTACK_POTION(
			ItemID.ATTACK_POTION3,
			3,
			25,
			new Item[]{
					new Item(ItemID.EYE_OF_NEWT, 1),
					new Item(ItemID.IRIT_POTION_UNF, 1)
			},
			ItemID.ATTACK_POTION4),
	BASTION_POTION(
			ItemID.BASTION_POTION3,
			80,
			155,
			new Item[]{
					new Item(ItemID.WINE_OF_ZAMORAK, 1),
					new Item(ItemID.CADANTINE_BLOOD_POTION_UNF, 1)
			},
			ItemID.BASTION_POTION4),
	BATTLEMAGE_POTION(
			ItemID.BATTLEMAGE_POTION3,
			80,
			155,
			new Item[]{
					new Item(ItemID.POTATO_CACTUS, 1),
					new Item(ItemID.CADANTINE_BLOOD_POTION_UNF, 1)
			},
			ItemID.BATTLEMAGE_POTION4),
	COMBAT_POTION(
			ItemID.COMBAT_POTION3,
			36,
			84,
			new Item[]{
					new Item(ItemID.GOAT_HORN_DUST, 1),
					new Item(ItemID.HARRALANDER_POTION_UNF, 1)
			},
			ItemID.COMBAT_POTION4),
	COMPOST_POTION(
			ItemID.COMPOST_POTION3,
			22,
			60,
			new Item[]{
					new Item(ItemID.VOLCANIC_ASH, 1),
					new Item(ItemID.HARRALANDER_POTION_UNF,1)
			},
			ItemID.COMPOST_POTION4),
	DEFENCE_POTION(
			ItemID.DEFENCE_POTION3,
			30,
			75,
			new Item[]{
					new Item(ItemID.WHITE_BERRIES, 1),
					new Item(ItemID.RANARR_POTION_UNF, 1)
			},
			ItemID.DEFENCE_POTION4),
	DIVINE_BASTION_POTION1(
			ItemID.DIVINE_BASTION_POTION1,
			86,
			0.5f,
			new Item[]{
					new Item(ItemID.BASTION_POTION1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_BASTION_POTION2),
	DIVINE_BASTION_POTION2(
			ItemID.DIVINE_BASTION_POTION2,
			86,
			1,
			new Item[]{
					new Item(ItemID.BASTION_POTION2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_BASTION_POTION3),
	DIVINE_BASTION_POTION3(
			ItemID.DIVINE_BASTION_POTION3,
			86,
			1.5f,
			new Item[]{
					new Item(ItemID.BASTION_POTION3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_BASTION_POTION4),
	DIVINE_BASTION_POTION4(
			ItemID.DIVINE_BASTION_POTION4,
			86,
			2,
			new Item[]{
					new Item(ItemID.BASTION_POTION4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_BATTLEMAGE_POTION1(
			ItemID.DIVINE_BATTLEMAGE_POTION1,
			86,
			0.5f,
			new Item[]{
					new Item(ItemID.BATTLEMAGE_POTION1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_BATTLEMAGE_POTION2),
	DIVINE_BATTLEMAGE_POTION2(
			ItemID.DIVINE_BATTLEMAGE_POTION2,
			86,
			1,
			new Item[]{
					new Item(ItemID.BATTLEMAGE_POTION2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_BATTLEMAGE_POTION3),
	DIVINE_BATTLEMAGE_POTION3(
			ItemID.DIVINE_BATTLEMAGE_POTION3,
			86,
			1.5f,
			new Item[]{
					new Item(ItemID.BATTLEMAGE_POTION3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_BATTLEMAGE_POTION4),
	DIVINE_BATTLEMAGE_POTION4(
			ItemID.DIVINE_BATTLEMAGE_POTION4,
			86,
			2,
			new Item[]{
					new Item(ItemID.BATTLEMAGE_POTION4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_MAGIC_POTION1(
			ItemID.DIVINE_MAGIC_POTION1,
			78,
			0.5f,
			new Item[]{
					new Item(ItemID.MAGIC_POTION1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_MAGIC_POTION2),
	DIVINE_MAGIC_POTION2(
			ItemID.DIVINE_MAGIC_POTION2,
			78,
			1,
			new Item[]{
					new Item(ItemID.MAGIC_POTION2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_MAGIC_POTION3),
	DIVINE_MAGIC_POTION3(
			ItemID.DIVINE_MAGIC_POTION3,
			78,
			1.5f,
			new Item[]{
					new Item(ItemID.MAGIC_POTION3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_MAGIC_POTION4),
	DIVINE_MAGIC_POTION4(
			ItemID.DIVINE_MAGIC_POTION4,
			78,
			2,
			new Item[]{
					new Item(ItemID.MAGIC_POTION4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_RANGING_POTION1(
			ItemID.DIVINE_RANGING_POTION1,
			74,
			0.5f,
			new Item[]{
					new Item(ItemID.RANGING_POTION1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_RANGING_POTION2),
	DIVINE_RANGING_POTION2(
			ItemID.DIVINE_RANGING_POTION2,
			74,
			1,
			new Item[]{
					new Item(ItemID.RANGING_POTION2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_RANGING_POTION3),
	DIVINE_RANGING_POTION3(
			ItemID.DIVINE_RANGING_POTION3,
			74,
			1.5f,
			new Item[]{
					new Item(ItemID.RANGING_POTION3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_RANGING_POTION4),
	DIVINE_RANGING_POTION4(
			ItemID.DIVINE_RANGING_POTION4,
			74,
			2,
			new Item[]{
					new Item(ItemID.RANGING_POTION4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_SUPER_ATTACK_POTION1(
			ItemID.DIVINE_SUPER_ATTACK_POTION1,
			70,
			0.5f,
			new Item[]{
					new Item(ItemID.SUPER_ATTACK1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_SUPER_ATTACK_POTION2),
	DIVINE_SUPER_ATTACK_POTION2(
			ItemID.DIVINE_SUPER_ATTACK_POTION2,
			70,
			1,
			new Item[]{
					new Item(ItemID.SUPER_ATTACK2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_SUPER_ATTACK_POTION3),
	DIVINE_SUPER_ATTACK_POTION3(
			ItemID.DIVINE_SUPER_ATTACK_POTION3,
			70,
			1.5f,
			new Item[]{
					new Item(ItemID.SUPER_ATTACK3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_SUPER_ATTACK_POTION4),
	DIVINE_SUPER_ATTACK_POTION4(
			ItemID.DIVINE_SUPER_ATTACK_POTION4,
			70,
			2,
			new Item[]{
					new Item(ItemID.SUPER_ATTACK4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_SUPER_COMBAT_POTION1(
			ItemID.DIVINE_SUPER_COMBAT_POTION1,
			97,
			0.5f,
			new Item[]{
					new Item(ItemID.SUPER_COMBAT_POTION1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_SUPER_COMBAT_POTION2),
	DIVINE_SUPER_COMBAT_POTION2(
			ItemID.DIVINE_SUPER_COMBAT_POTION2,
			97,
			1,
			new Item[]{
					new Item(ItemID.SUPER_COMBAT_POTION2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_SUPER_COMBAT_POTION3),
	DIVINE_SUPER_COMBAT_POTION3(
			ItemID.DIVINE_SUPER_COMBAT_POTION3,
			97,
			1.5f,
			new Item[]{
					new Item(ItemID.SUPER_COMBAT_POTION3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_SUPER_COMBAT_POTION4),
	DIVINE_SUPER_COMBAT_POTION4(
			ItemID.DIVINE_SUPER_COMBAT_POTION4,
			97,
			2,
			new Item[]{
					new Item(ItemID.SUPER_COMBAT_POTION4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_SUPER_DEFENCE_POTION1(
			ItemID.DIVINE_SUPER_DEFENCE_POTION1,
			70,
			0.5f,
			new Item[]{
					new Item(ItemID.SUPER_DEFENCE1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_SUPER_DEFENCE_POTION2),
	DIVINE_SUPER_DEFENCE_POTION2(
			ItemID.DIVINE_SUPER_DEFENCE_POTION2,
			70,
			1,
			new Item[]{
					new Item(ItemID.SUPER_DEFENCE2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_SUPER_DEFENCE_POTION3),
	DIVINE_SUPER_DEFENCE_POTION3(
			ItemID.DIVINE_SUPER_DEFENCE_POTION3,
			70,
			1.5f,
			new Item[]{
					new Item(ItemID.SUPER_DEFENCE3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_SUPER_DEFENCE_POTION4),
	DIVINE_SUPER_DEFENCE_POTION4(
			ItemID.DIVINE_SUPER_DEFENCE_POTION4,
			70,
			2,
			new Item[]{
					new Item(ItemID.SUPER_DEFENCE4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	DIVINE_SUPER_STRENGTH_POTION1(
			ItemID.DIVINE_SUPER_STRENGTH_POTION1,
			70,
			0.5f,
			new Item[]{
					new Item(ItemID.SUPER_STRENGTH1, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 1)
			},
			ItemID.DIVINE_SUPER_STRENGTH_POTION2),
	DIVINE_SUPER_STRENGTH_POTION2(
			ItemID.DIVINE_SUPER_STRENGTH_POTION2,
			70,
			1,
			new Item[]{
					new Item(ItemID.SUPER_STRENGTH2, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 2)
			},
			ItemID.DIVINE_SUPER_STRENGTH_POTION3),
	DIVINE_SUPER_STRENGTH_POTION3(
			ItemID.DIVINE_SUPER_STRENGTH_POTION3,
			70,
			1.5f,
			new Item[]{
					new Item(ItemID.SUPER_STRENGTH3, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 3)
			},
			ItemID.DIVINE_SUPER_STRENGTH_POTION4),
	DIVINE_SUPER_STRENGTH_POTION4(
			ItemID.DIVINE_SUPER_STRENGTH_POTION4,
			70,
			2,
			new Item[]{
					new Item(ItemID.SUPER_STRENGTH4, 1),
					new Item(ItemID.CRYSTAL_DUST_23964, 4)
			}),
	ENERGY_POTION(
			ItemID.ENERGY_POTION3,
			26,
			67.5f,
			new Item[]{
					new Item(ItemID.CHOCOLATE_DUST, 1),
					new Item(ItemID.HARRALANDER_POTION_UNF, 1)
			}),
	EXTENDED_ANTIFIRE1(
			ItemID.EXTENDED_ANTIFIRE1,
			84,
			27.5f,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION1, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 1)
			},
			ItemID.EXTENDED_ANTIFIRE2),
	EXTENDED_ANTIFIRE2(
			ItemID.EXTENDED_ANTIFIRE2,
			84,
			55,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION1, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 2)
			},
			ItemID.EXTENDED_ANTIFIRE3),
	EXTENDED_ANTIFIRE3(
			ItemID.EXTENDED_ANTIFIRE3,
			84,
			82.5f,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION1, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 3)
			},
			ItemID.EXTENDED_ANTIFIRE4),
	EXTENDED_ANTIFIRE4(
			ItemID.EXTENDED_ANTIFIRE4,
			84,
			110,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION1, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 4)
			}),
	EXTENDED_SUPER_ANTIFIRE1(
			ItemID.EXTENDED_SUPER_ANTIFIRE1,
			98,
			40,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION1, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 1)
			},
			ItemID.EXTENDED_SUPER_ANTIFIRE2),
	EXTENDED_SUPER_ANTIFIRE2(
			ItemID.EXTENDED_SUPER_ANTIFIRE2,
			98,
			80,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION2, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 2)
			},
			ItemID.EXTENDED_SUPER_ANTIFIRE3),
	EXTENDED_SUPER_ANTIFIRE3(
			ItemID.EXTENDED_SUPER_ANTIFIRE3,
			98,
			120,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION3, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 3)
			},
			ItemID.EXTENDED_SUPER_ANTIFIRE4),
	EXTENDED_SUPER_ANTIFIRE4(
			ItemID.EXTENDED_SUPER_ANTIFIRE4,
			98,
			160,
			new Item[]{
					new Item(ItemID.SUPER_ANTIFIRE_POTION4, 1),
					new Item(ItemID.LAVA_SCALE_SHARD, 4)
			}),
	FISHING_POTION(
			ItemID.FISHING_POTION3,
			50,
			112.5f,
			new Item[]{
				new Item(ItemID.AVANTOE_POTION_UNF, 1),
				new Item(ItemID.SNAPE_GRASS, 1)
			},
			ItemID.FISHING_POTION4),
	GUTHIX_REST(
			ItemID.GUTHIX_REST3,
			18,
			59,
			new Item[]{
					new Item(ItemID.CUP_OF_HOT_WATER, 1),
					new Item(ItemID.GUAM_LEAF, 2),
					new Item(ItemID.HARRALANDER, 1),
					new Item(ItemID.MARRENTILL, 1)
			}),
	HUNTER_POTION(
			ItemID.HUNTER_POTION3,
			53,
			120,
			new Item[]{
					new Item(ItemID.KEBBIT_TEETH_DUST, 1),
					new Item(ItemID.AVANTOE_POTION_UNF, 1)
			},
			ItemID.HUNTER_POTION4),
	MAGIC_ESSENCE_POTION(           // TODO: Does this work with the amulet of chemistry?
			ItemID.MAGIC_ESSENCE3,
			57,
			130,
			new Item[]{
					new Item(ItemID.MAGIC_ESSENCE_UNF, 1),
					new Item(ItemID.GORAK_CLAW_POWDER, 1)
			}),
	MAGIC_POTION(
			ItemID.MAGIC_POTION3,
			76,
			172.5f,
			new Item[]{
					new Item(ItemID.POTATO_CACTUS, 1),
					new Item(ItemID.LANTADYME_POTION_UNF, 1)
			},
			ItemID.MAGIC_POTION4),
	PRAYER_POTION(
			ItemID.PRAYER_POTION3,
			38,
			87.5f,
			new Item[]{
					new Item(ItemID.SNAPE_GRASS, 1),
					new Item(ItemID.RANARR_POTION_UNF, 1)
			},
			ItemID.PRAYER_POTION4),
	RANGING_POTION(
			ItemID.RANGING_POTION3,
			72,
			162.5f,
			new Item[]{
					new Item(ItemID.DWARF_WEED_POTION_UNF, 1),
					new Item(ItemID.WINE_OF_ZAMORAK, 1)
			},
			ItemID.RANGING_POTION4),
	RELICYMS_BALM(
			ItemID.RELICYMS_BALM3,
			8,
			40,
			new Item[]{
					new Item(ItemID.UNFINISHED_POTION_4840, 1),
					new Item(ItemID.SNAKE_WEED, 1)
			},
			ItemID.RELICYMS_BALM4),
	RESTORE_POTION(
			ItemID.RESTORE_POTION3,
			22,
			62.5f,
			new Item[]{
					new Item(ItemID.RED_SPIDERS_EGGS, 1),
					new Item(ItemID.HARRALANDER_POTION_UNF, 1)
			},
			ItemID.RESTORE_POTION4),
	SANFEW_SERUM1(              // TODO: Does this work with the amulet of chemistry?
			ItemID.SANFEW_SERUM1,
			65,
			160,
			new Item[]{
					new Item(ItemID.SUPER_RESTORE1, 1),
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.NAIL_BEAST_NAILS, 1),
					new Item(ItemID.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM2(
			ItemID.SANFEW_SERUM2,
			65,
			160,
			new Item[]{
					new Item(ItemID.SUPER_RESTORE2, 1),
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.NAIL_BEAST_NAILS, 1),
					new Item(ItemID.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM3(
			ItemID.SANFEW_SERUM3,
			65,
			160,
			new Item[]{
					new Item(ItemID.SUPER_RESTORE3, 1),
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.NAIL_BEAST_NAILS, 1),
					new Item(ItemID.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM4(
			ItemID.SANFEW_SERUM4,
			65,
			160,
			new Item[]{
					new Item(ItemID.SUPER_RESTORE4, 1),
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.NAIL_BEAST_NAILS, 1),
					new Item(ItemID.SNAKE_WEED, 1)
			}),
	SARADOMIN_BREW(
			ItemID.SARADOMIN_BREW3,
			81,
			180,
			new Item[]{
					new Item(ItemID.CRUSHED_NEST, 1),
					new Item(ItemID.TOADFLAX_POTION_UNF, 1)
			},
			ItemID.SARADOMIN_BREW4),
	SERUM_207(
			ItemID.SERUM_207_3,
			15,
			50,
			new Item[]{
					new Item(ItemID.ASHES, 1),
					new Item(ItemID.TARROMIN, 1)
			}),
	STAMINA_POTION1(
			ItemID.STAMINA_POTION1,
			77,
			25.5f,
			new Item[]{
					new Item(ItemID.SUPER_ENERGY1, 1),
					new Item(ItemID.AMYLASE_CRYSTAL, 1)
			},
			ItemID.STAMINA_POTION2),
	STAMINA_POTION2(
			ItemID.STAMINA_POTION2,
			77,
			51,
			new Item[]{
					new Item(ItemID.SUPER_ENERGY2, 1),
					new Item(ItemID.AMYLASE_CRYSTAL, 2)
			},
			ItemID.STAMINA_POTION3),
	STAMINA_POTION3(
			ItemID.STAMINA_POTION3,
			77,
			76.5f,
			new Item[]{
					new Item(ItemID.SUPER_ENERGY3, 1),
					new Item(ItemID.AMYLASE_CRYSTAL, 3)
			},
			ItemID.STAMINA_POTION4),
	STAMINA_POTION4(
			ItemID.STAMINA_POTION4,
			77,
			102,
			new Item[]{
					new Item(ItemID.SUPER_ENERGY4, 1),
					new Item(ItemID.AMYLASE_CRYSTAL, 4)
			}),
	STRENGTH_POTION3(
			ItemID.STRENGTH_POTION3,
			12,
			50,
			new Item[]{
					new Item(ItemID.LIMPWURT_ROOT, 1),
					new Item(ItemID.TARROMIN_POTION_UNF, 1)
			},
			ItemID.STRENGTH_POTION4),
	SUPER_ANTIFIRE4(
			ItemID.SUPER_ANTIFIRE_POTION4,
			92,
			130,
			new Item[]{
					new Item(ItemID.ANTIFIRE_POTION4, 1),
					new Item(ItemID.CRUSHED_SUPERIOR_DRAGON_BONES, 1)
			}),
	SUPERANTIPOISON(
			ItemID.SUPERANTIPOISON3,
			48,
			106.3f,
			new Item[]{
					new Item(ItemID.UNICORN_HORN_DUST, 1),
					new Item(ItemID.IRIT_POTION_UNF, 1)
			},
			ItemID.SUPERANTIPOISON4),
	SUPER_ATTACK(
			ItemID.SUPER_ATTACK3,
			45,
			100,
			new Item[]{
					new Item(ItemID.EYE_OF_NEWT, 1),
					new Item(ItemID.IRIT_POTION_UNF, 1)
			},
			ItemID.SUPER_ATTACK4),
	SUPER_COMBAT_POTION(
			ItemID.SUPER_COMBAT_POTION4,
			90,
			150,
			new Item[]{
					new Item(ItemID.SUPER_ATTACK4, 1),
					new Item(ItemID.SUPER_DEFENCE4, 1),
					new Item(ItemID.SUPER_STRENGTH4, 1),
					new Item(ItemID.TORSTOL, 1)
			}),
	SUPER_DEFENCE(
			ItemID.SUPER_DEFENCE3,
			66,
			150,
			new Item[]{
					new Item(ItemID.WHITE_BERRIES, 1),
					new Item(ItemID.CADANTINE_POTION_UNF, 1)
			},
			ItemID.SUPER_DEFENCE4),
	SUPER_ENERGY(
			ItemID.SUPER_ENERGY3,
			52,
			117.5f,
			new Item[]{
					new Item(ItemID.MORT_MYRE_FUNGUS, 1),
					new Item(ItemID.AVANTOE_POTION_UNF, 1)
			},
			ItemID.SUPER_ENERGY4),
	SUPER_RESTORE(
			ItemID.SUPER_RESTORE3,
			63,
			142.5f,
			new Item[]{
					new Item(ItemID.RED_SPIDERS_EGGS, 1),
					new Item(ItemID.SNAPDRAGON_POTION_UNF, 1)
			},
			ItemID.SUPER_RESTORE4),
	SUPER_STRENGTH(
			ItemID.SUPER_STRENGTH3,
			55,
			125,
			new Item[]{
					new Item(ItemID.LIMPWURT_ROOT, 1),
					new Item(ItemID.KWUARM_POTION_UNF, 1)
			},
			ItemID.SUPER_STRENGTH4),
	WEAPON_POISON(
			ItemID.WEAPON_POISON,
			60,
			137.5f,
			new Item[]{
					new Item(ItemID.DRAGON_SCALE_DUST, 1),
					new Item(ItemID.KWUARM_POTION_UNF, 1)
			}),
	WEAPON_POISON_PLUS(
			ItemID.WEAPON_POISON_5937,
			73,
			165,
			new Item[]{
					new Item(ItemID.CACTUS_SPINE, 1),
					new Item(ItemID.COCONUT_MILK, 1)
			}),
	WEAPON_POISON_PLUS_PLUS(
			ItemID.WEAPON_POISON_5940,
			82,
			190,
			new Item[]{
					new Item(ItemID.CAVE_NIGHTSHADE, 1),
					new Item(ItemID.COCONUT_MILK, 1)
			}),
	ZAMORAK_BREW(
			ItemID.ZAMORAK_BREW3,
			78,
			175,
			new Item[]{
					new Item(ItemID.JANGERBERRIES, 1),
					new Item(ItemID.TORSTOL_POTION_UNF, 1)
			},
			ItemID.ZAMORAK_BREW4),
	;

	// if (id >= 0) then (id exists)
	private final int id;
	private final int level;
	private final float xp;
	private Item[] ingredients;
	// The id of a potion given an amulet proc (e.g. 3-dose id -> 4-dose id)
	// if (idAmulet >= 0) then (idAmulet exists)
	private final int idAmulet;

	Potions(int id, int level, float xp, Item[] ingredients, int procsAmulet) {
		this.id = id;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
		this.idAmulet = procsAmulet;
	}

	Potions(int id, int level, float xp, Item[] ingredients) {
		this(id, level, xp, ingredients, -1);
	}

	@Override
	public int[] getOutput() {
		return new int[]{this.id, this.idAmulet};
	}

	@Override
	public Item[] getIngredients() {
		return this.ingredients;
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
	public boolean flagsAffect(Set<Flags> flags) {
		return (flags.contains(Flags.AMULET_OF_CHEMISTRY)) && (this.idAmulet >= 0);
	}

	@Override
	public boolean flagsAffect(Flags flag) {
		return (flag == Flags.AMULET_OF_CHEMISTRY) && (this.idAmulet >= 0);
	}
}
