/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nop.matthew.osrscalculator.data.herblore;

import nop.matthew.osrscalculator.data.Flags;
import nop.matthew.osrscalculator.data.Item;
import nop.matthew.osrscalculator.data.ItemQuantity;
import nop.matthew.osrscalculator.data.Recipe;

import java.util.Set;

public enum Potions implements Recipe {
	AGILITY_POTION(
			new ItemQuantity(Item.AGILITY_POTION3, 1),
			34,
			80,
			new ItemQuantity[]{
					new ItemQuantity(Item.TOADFLAX_POTION_UNF, 1),
					new ItemQuantity(Item.TOADS_LEGS, 1)
			},
			new ItemQuantity(Item.AGILITY_POTION4, 1)),
	ANTIDOTE_PLUS(
			new ItemQuantity(Item.ANTIDOTE4, 1),
			68,
			155,
			new ItemQuantity[]{
					new ItemQuantity(Item.COCONUT_MILK, 1),
					new ItemQuantity(Item.TOADFLAX, 1),
					new ItemQuantity(Item.YEW_ROOTS, 1)
			}),
	ANTIDOTE_PLUS_PLUS(
			new ItemQuantity(Item.ANTIDOTE_PLUS_PLUS4, 1),
			79,
			177.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.COCONUT_MILK, 1),
					new ItemQuantity(Item.IRIT_LEAF, 1),
					new ItemQuantity(Item.MAGIC_ROOTS, 1)
			}),
	ANTIFIRE_POTION(
			new ItemQuantity(Item.ANTIFIRE_POTION3, 1),
			69,
			157.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.DRAGON_SCALE_DUST, 1),
					new ItemQuantity(Item.LANTADYME_POTION_UNF, 1)
			},
			new ItemQuantity(Item.ANTIFIRE_POTION4, 1)),
	ANTIPOISON(
			new ItemQuantity(Item.ANTIPOISON3, 1),
			5,
			37.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.MARRENTILL_POTION_UNF, 1)
			},
			new ItemQuantity(Item.ANTIPOISON4, 1)),
	ANTIVENOM1(
			new ItemQuantity(Item.ANTIVENOM1, 1),
			87,
			30,
			new ItemQuantity[]{
					new ItemQuantity(Item.ZULRAHS_SCALES, 5),
					new ItemQuantity(Item.ANTIDOTE_PLUS_PLUS1, 1)
			},
			new ItemQuantity(Item.ANTIVENOM2, 1)),
	ANTIVENOM2(
			new ItemQuantity(Item.ANTIVENOM2, 1),
			87,
			60,
			new ItemQuantity[]{
					new ItemQuantity(Item.ZULRAHS_SCALES, 10),
					new ItemQuantity(Item.ANTIDOTE_PLUS_PLUS2, 1)
			},
			new ItemQuantity(Item.ANTIVENOM3, 1)),
	ANTIVENOM3(
			new ItemQuantity(Item.ANTIVENOM3, 1),
			87,
			90,
			new ItemQuantity[]{
					new ItemQuantity(Item.ZULRAHS_SCALES, 15),
					new ItemQuantity(Item.ANTIDOTE_PLUS_PLUS3, 1)
			},
			new ItemQuantity(Item.ANTIVENOM4, 1)),
	ANTIVENOM4(
			new ItemQuantity(Item.ANTIVENOM4, 1),
			87,
			120,
			new ItemQuantity[]{
					new ItemQuantity(Item.ZULRAHS_SCALES, 20),
					new ItemQuantity(Item.ANTIDOTE_PLUS_PLUS4, 1)
			}),
	ANTIVENOM_PLUS(
			new ItemQuantity(Item.ANTIVENOM_PLUS4, 1),
			94,
			125,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIVENOM4, 1),
					new ItemQuantity(Item.TORSTOL, 1)
			}),
	ATTACK_POTION(
			new ItemQuantity(Item.ATTACK_POTION3, 1),
			3,
			25,
			new ItemQuantity[]{
					new ItemQuantity(Item.EYE_OF_NEWT, 1),
					new ItemQuantity(Item.GUAM_POTION_UNF, 1)
			},
			new ItemQuantity(Item.ATTACK_POTION4, 1)),
	BASTION_POTION(
			new ItemQuantity(Item.BASTION_POTION3, 1),
			80,
			155,
			new ItemQuantity[]{
					new ItemQuantity(Item.WINE_OF_ZAMORAK, 1),
					new ItemQuantity(Item.CADANTINE_BLOOD_POTION_UNF, 1)
			},
			new ItemQuantity(Item.BASTION_POTION4, 1)),
	BATTLEMAGE_POTION(
			new ItemQuantity(Item.BATTLEMAGE_POTION3, 1),
			80,
			155,
			new ItemQuantity[]{
					new ItemQuantity(Item.POTATO_CACTUS, 1),
					new ItemQuantity(Item.CADANTINE_BLOOD_POTION_UNF, 1)
			},
			new ItemQuantity(Item.BATTLEMAGE_POTION4, 1)),
	COMBAT_POTION(
			new ItemQuantity(Item.COMBAT_POTION3, 1),
			36,
			84,
			new ItemQuantity[]{
					new ItemQuantity(Item.GOAT_HORN_DUST, 1),
					new ItemQuantity(Item.HARRALANDER_POTION_UNF, 1)
			},
			new ItemQuantity(Item.COMBAT_POTION4, 1)),
	COMPOST_POTION(
			new ItemQuantity(Item.COMPOST_POTION3, 1),
			22,
			60,
			new ItemQuantity[]{
					new ItemQuantity(Item.VOLCANIC_ASH, 1),
					new ItemQuantity(Item.HARRALANDER_POTION_UNF, 1)
			},
			new ItemQuantity(Item.COMPOST_POTION4, 1)),
	DEFENCE_POTION(
			new ItemQuantity(Item.DEFENCE_POTION3, 1),
			30,
			75,
			new ItemQuantity[]{
					new ItemQuantity(Item.WHITE_BERRIES, 1),
					new ItemQuantity(Item.RANARR_POTION_UNF, 1)
			},
			new ItemQuantity(Item.DEFENCE_POTION4, 1)),
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
	ENERGY_POTION(
			new ItemQuantity(Item.ENERGY_POTION3, 1),
			26,
			67.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.CHOCOLATE_DUST, 1),
					new ItemQuantity(Item.HARRALANDER_POTION_UNF, 1)
			},
			new ItemQuantity(Item.ENERGY_POTION4, 1)),
	EXTENDED_ANTIFIRE1(
			new ItemQuantity(Item.EXTENDED_ANTIFIRE1, 1),
			84,
			27.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIFIRE_POTION1, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 1)
			},
			new ItemQuantity(Item.EXTENDED_ANTIFIRE2, 1)),
	EXTENDED_ANTIFIRE2(
			new ItemQuantity(Item.EXTENDED_ANTIFIRE2, 1),
			84,
			55,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIFIRE_POTION2, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 2)
			},
			new ItemQuantity(Item.EXTENDED_ANTIFIRE3, 1)),
	EXTENDED_ANTIFIRE3(
			new ItemQuantity(Item.EXTENDED_ANTIFIRE3, 1),
			84,
			82.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIFIRE_POTION3, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 3)
			},
			new ItemQuantity(Item.EXTENDED_ANTIFIRE4, 1)),
	EXTENDED_ANTIFIRE4(
			new ItemQuantity(Item.EXTENDED_ANTIFIRE4, 1),
			84,
			110,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIFIRE_POTION4, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 4)
			}),
	EXTENDED_SUPER_ANTIFIRE1(
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE1, 1),
			98,
			40,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ANTIFIRE_POTION1, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 1)
			},
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE2, 1)),
	EXTENDED_SUPER_ANTIFIRE2(
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE2, 1),
			98,
			80,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ANTIFIRE_POTION2, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 2)
			},
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE3, 1)),
	EXTENDED_SUPER_ANTIFIRE3(
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE3, 1),
			98,
			120,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ANTIFIRE_POTION3, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 3)
			},
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE4, 1)),
	EXTENDED_SUPER_ANTIFIRE4(
			new ItemQuantity(Item.EXTENDED_SUPER_ANTIFIRE4, 1),
			98,
			160,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ANTIFIRE_POTION4, 1),
					new ItemQuantity(Item.LAVA_SCALE_SHARD, 4)
			}),
	FISHING_POTION(
			new ItemQuantity(Item.FISHING_POTION3, 1),
			50,
			112.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.AVANTOE_POTION_UNF, 1),
					new ItemQuantity(Item.SNAPE_GRASS, 1)
			},
			new ItemQuantity(Item.FISHING_POTION4, 1)),
	GUTHIX_REST(
			new ItemQuantity(Item.GUTHIX_REST3, 1),
			18,
			59,
			new ItemQuantity[]{
					new ItemQuantity(Item.CUP_OF_HOT_WATER, 1),
					new ItemQuantity(Item.GUAM_LEAF, 2),
					new ItemQuantity(Item.HARRALANDER, 1),
					new ItemQuantity(Item.MARRENTILL, 1)
			}),
	HUNTER_POTION(
			new ItemQuantity(Item.HUNTER_POTION3, 1),
			53,
			120,
			new ItemQuantity[]{
					new ItemQuantity(Item.KEBBIT_TEETH_DUST, 1),
					new ItemQuantity(Item.AVANTOE_POTION_UNF, 1)
			},
			new ItemQuantity(Item.HUNTER_POTION4, 1)),
	MAGIC_ESSENCE_POTION( // TODO: Does this work with the amulet of chemistry?
			new ItemQuantity(Item.MAGIC_ESSENCE3, 1),
			57,
			130,
			new ItemQuantity[]{
					new ItemQuantity(Item.MAGIC_ESSENCE_UNF, 1),
					new ItemQuantity(Item.GORAK_CLAW_POWDER, 1)
			}),
	MAGIC_POTION(
			new ItemQuantity(Item.MAGIC_POTION3, 1),
			76,
			172.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.POTATO_CACTUS, 1),
					new ItemQuantity(Item.LANTADYME_POTION_UNF, 1)
			},
			new ItemQuantity(Item.MAGIC_POTION4, 1)),
	PRAYER_POTION(
			new ItemQuantity(Item.PRAYER_POTION3, 1),
			38,
			87.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SNAPE_GRASS, 1),
					new ItemQuantity(Item.RANARR_POTION_UNF, 1)
			},
			new ItemQuantity(Item.PRAYER_POTION4, 1)),
	RANGING_POTION(
			new ItemQuantity(Item.RANGING_POTION3, 1),
			72,
			162.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.DWARF_WEED_POTION_UNF, 1),
					new ItemQuantity(Item.WINE_OF_ZAMORAK, 1)
			},
			new ItemQuantity(Item.RANGING_POTION4, 1)),
	RELICYMS_BALM(
			new ItemQuantity(Item.RELICYMS_BALM3, 1),
			8,
			40,
			new ItemQuantity[]{
					new ItemQuantity(Item.UNFINISHED_POTION, 1),
					new ItemQuantity(Item.SNAKE_WEED, 1)
			},
			new ItemQuantity(Item.RELICYMS_BALM4, 1)),
	RESTORE_POTION(
			new ItemQuantity(Item.RESTORE_POTION3, 1),
			22,
			62.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.RED_SPIDERS_EGGS, 1),
					new ItemQuantity(Item.HARRALANDER_POTION_UNF, 1)
			},
			new ItemQuantity(Item.RESTORE_POTION4, 1)),
	SANFEW_SERUM1( // TODO: Does this work with the amulet of chemistry?
			new ItemQuantity(Item.SANFEW_SERUM1, 1),
			65,
			160,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_RESTORE1, 1),
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.NAIL_BEAST_NAILS, 1),
					new ItemQuantity(Item.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM2(
			new ItemQuantity(Item.SANFEW_SERUM2, 1),
			65,
			160,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_RESTORE2, 1),
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.NAIL_BEAST_NAILS, 1),
					new ItemQuantity(Item.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM3(
			new ItemQuantity(Item.SANFEW_SERUM3, 1),
			65,
			160,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_RESTORE3, 1),
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.NAIL_BEAST_NAILS, 1),
					new ItemQuantity(Item.SNAKE_WEED, 1)
			}),
	SANFEW_SERUM4(
			new ItemQuantity(Item.SANFEW_SERUM4, 1),
			65,
			160,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_RESTORE4, 1),
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.NAIL_BEAST_NAILS, 1),
					new ItemQuantity(Item.SNAKE_WEED, 1)
			}),
	SARADOMIN_BREW(
			new ItemQuantity(Item.SARADOMIN_BREW3, 1),
			81,
			180,
			new ItemQuantity[]{
					new ItemQuantity(Item.CRUSHED_NEST, 1),
					new ItemQuantity(Item.TOADFLAX_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SARADOMIN_BREW4, 1)),
	SERUM_207(
			new ItemQuantity(Item.SERUM_207_3, 1),
			15,
			50,
			new ItemQuantity[]{
					new ItemQuantity(Item.ASHES, 1),
					new ItemQuantity(Item.TARROMIN, 1)
			}),
	STAMINA_POTION1(
			new ItemQuantity(Item.STAMINA_POTION1, 1),
			77,
			25.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ENERGY1, 1),
					new ItemQuantity(Item.AMYLASE_CRYSTAL, 1)
			},
			new ItemQuantity(Item.STAMINA_POTION2, 1)),
	STAMINA_POTION2(
			new ItemQuantity(Item.STAMINA_POTION2, 1),
			77,
			51,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ENERGY2, 1),
					new ItemQuantity(Item.AMYLASE_CRYSTAL, 2)
			},
			new ItemQuantity(Item.STAMINA_POTION3, 1)),
	STAMINA_POTION3(
			new ItemQuantity(Item.STAMINA_POTION3, 1),
			77,
			76.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ENERGY3, 1),
					new ItemQuantity(Item.AMYLASE_CRYSTAL, 3)
			},
			new ItemQuantity(Item.STAMINA_POTION4, 1)),
	STAMINA_POTION4(
			new ItemQuantity(Item.STAMINA_POTION4, 1),
			77,
			102,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ENERGY4, 1),
					new ItemQuantity(Item.AMYLASE_CRYSTAL, 4)
			}),
	STRENGTH_POTION3(
			new ItemQuantity(Item.STRENGTH_POTION3, 1),
			12,
			50,
			new ItemQuantity[]{
					new ItemQuantity(Item.LIMPWURT_ROOT, 1),
					new ItemQuantity(Item.TARROMIN_POTION_UNF, 1)
			},
			new ItemQuantity(Item.STRENGTH_POTION4, 1)),
	SUPER_ANTIFIRE4(
			new ItemQuantity(Item.SUPER_ANTIFIRE_POTION4, 1),
			92,
			130,
			new ItemQuantity[]{
					new ItemQuantity(Item.ANTIFIRE_POTION4, 1),
					new ItemQuantity(Item.CRUSHED_SUPERIOR_DRAGON_BONES, 1)
			}),
	SUPERANTIPOISON(
			new ItemQuantity(Item.SUPERANTIPOISON3, 1),
			48,
			106.3f,
			new ItemQuantity[]{
					new ItemQuantity(Item.UNICORN_HORN_DUST, 1),
					new ItemQuantity(Item.IRIT_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPERANTIPOISON4, 1)),
	SUPER_ATTACK(
			new ItemQuantity(Item.SUPER_ATTACK3, 1),
			45,
			100,
			new ItemQuantity[]{
					new ItemQuantity(Item.EYE_OF_NEWT, 1),
					new ItemQuantity(Item.IRIT_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPER_ATTACK4, 1)),
	SUPER_COMBAT_POTION(
			new ItemQuantity(Item.SUPER_COMBAT_POTION4, 1),
			90,
			150,
			new ItemQuantity[]{
					new ItemQuantity(Item.SUPER_ATTACK4, 1),
					new ItemQuantity(Item.SUPER_DEFENCE4, 1),
					new ItemQuantity(Item.SUPER_STRENGTH4, 1),
					new ItemQuantity(Item.TORSTOL, 1)
			}),
	SUPER_DEFENCE(
			new ItemQuantity(Item.SUPER_DEFENCE3, 1),
			66,
			150,
			new ItemQuantity[]{
					new ItemQuantity(Item.WHITE_BERRIES, 1),
					new ItemQuantity(Item.CADANTINE_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPER_DEFENCE4, 1)),
	SUPER_ENERGY(
			new ItemQuantity(Item.SUPER_ENERGY3, 1),
			52,
			117.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.MORT_MYRE_FUNGUS, 1),
					new ItemQuantity(Item.AVANTOE_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPER_ENERGY4, 1)),
	SUPER_RESTORE(
			new ItemQuantity(Item.SUPER_RESTORE3, 1),
			63,
			142.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.RED_SPIDERS_EGGS, 1),
					new ItemQuantity(Item.SNAPDRAGON_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPER_RESTORE4, 1)),
	SUPER_STRENGTH(
			new ItemQuantity(Item.SUPER_STRENGTH3, 1),
			55,
			125,
			new ItemQuantity[]{
					new ItemQuantity(Item.LIMPWURT_ROOT, 1),
					new ItemQuantity(Item.KWUARM_POTION_UNF, 1)
			},
			new ItemQuantity(Item.SUPER_STRENGTH4, 1)),
	WEAPON_POISON(
			new ItemQuantity(Item.WEAPON_POISON, 1),
			60,
			137.5f,
			new ItemQuantity[]{
					new ItemQuantity(Item.DRAGON_SCALE_DUST, 1),
					new ItemQuantity(Item.KWUARM_POTION_UNF, 1)
			}),
	WEAPON_POISON_PLUS(
			new ItemQuantity(Item.WEAPON_POISON_PLUS, 1),
			73,
			165,
			new ItemQuantity[]{
					new ItemQuantity(Item.CACTUS_SPINE, 1),
					new ItemQuantity(Item.COCONUT_MILK, 1)
			}),
	WEAPON_POISON_PLUS_PLUS(
			new ItemQuantity(Item.WEAPON_POISON_PLUS_PLUS, 1),
			82,
			190,
			new ItemQuantity[]{
					new ItemQuantity(Item.CAVE_NIGHTSHADE, 1),
					new ItemQuantity(Item.COCONUT_MILK, 1)
			}),
	ZAMORAK_BREW(
			new ItemQuantity(Item.ZAMORAK_BREW3, 1),
			78,
			175,
			new ItemQuantity[]{
					new ItemQuantity(Item.JANGERBERRIES, 1),
					new ItemQuantity(Item.TORSTOL_POTION_UNF, 1)
			},
			new ItemQuantity(Item.ZAMORAK_BREW4, 1)),
	;

	private final ItemQuantity output;
	private final int level;
	private final float xp;
	private final ItemQuantity[] ingredients;
	// The outcome potion given an amulet proc (e.g. 3-dose -> 4-dose (this one))
	private final ItemQuantity amuletItemQuantity;

	Potions(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients, ItemQuantity amuletItemQuantity) {
		this.output = output;
		this.level = level;
		this.xp = xp;
		this.ingredients = ingredients;
		this.amuletItemQuantity = amuletItemQuantity;
	}

	Potions(ItemQuantity output, int level, float xp, ItemQuantity[] ingredients) {
		this(output, level, xp, ingredients, null);
	}

	@Override
	public ItemQuantity[] getOutput() {
		return (this.amuletItemQuantity != null) ? new ItemQuantity[]{this.output, this.amuletItemQuantity} : new ItemQuantity[]{this.output};
	}

	@Override
	public ItemQuantity[] getIngredients() {
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
	public boolean flagsAffect(Set<Flags> flags) {
		return (flags.contains(Flags.AMULET_OF_CHEMISTRY)) && (this.amuletItemQuantity != null);
	}

	@Override
	public boolean flagsAffect(Flags flag) {
		return (flag == Flags.AMULET_OF_CHEMISTRY) && (this.amuletItemQuantity != null);
	}
}
