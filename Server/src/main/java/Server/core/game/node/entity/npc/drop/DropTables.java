package core.game.node.entity.npc.drop;

import core.tools.Items;
import core.game.node.item.ChanceItem;
import core.game.node.item.Item;
import core.game.node.item.WeightedChanceItem;
import core.tools.RandomFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public enum DropTables {
    //FORMAT NPC(int[] ids, int.... shared table weights, new Item[] always drops, new ChanceItem[] charms, new WeightedChanceItem[] main drop table)
    CHICKEN(new int[] {41,288,951,1017,1401,1402,2313,2314,2315},0,0,0,0,0,0,0,0,
            new Item[]{new Item(Items.BONES),new Item(Items.RAW_CHICKEN)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.FEATHER,5,2),
                    new WeightedChanceItem(Items.FEATHER,15,1),
                    new WeightedChanceItem(0,1,1)
            }),
    MAN_AND_THIEF(new int[]{1, 2, 3, 4, 5, 6, 8}, 0, 0, 0, 0, 0, 0, 23, 0,
            new Item[]{new Item(Items.BONES)}, //always drops
            new ChanceItem[]{}, // charms
            new WeightedChanceItem[]{ //main drop table v
                    new WeightedChanceItem(Items.BRONZE_MED_HELM, 1, 2),
                    new WeightedChanceItem(Items.IRON_DAGGER, 1, 1),
                    new WeightedChanceItem(Items.BRONZE_BOLTS, 2, 12, 22),
                    new WeightedChanceItem(Items.BRONZE_ARROW, 7, 3),
                    new WeightedChanceItem(Items.EARTH_RUNE, 4, 2),
                    new WeightedChanceItem(Items.FIRE_RUNE, 6, 2),
                    new WeightedChanceItem(Items.MIND_RUNE, 9, 2),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 2, 1),
                    new WeightedChanceItem(Items.COINS, 3, 38),
                    new WeightedChanceItem(Items.COINS, 5, 9),
                    new WeightedChanceItem(Items.COINS, 15, 4),
                    new WeightedChanceItem(Items.COINS, 25, 1),
                    new WeightedChanceItem(Items.FISHING_BAIT, 1, 5),
                    new WeightedChanceItem(Items.COPPER_ORE, 1, 2),
                    new WeightedChanceItem(Items.EARTH_TALISMAN, 1, 2),
                    new WeightedChanceItem(Items.CABBAGE, 1, 1)
            }),
    FARMER(new int[]{7}, 0, 0, 0, 0, 27, 0, 11, 0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.EARTH_RUNE, 4, 2),
                    new WeightedChanceItem(Items.FIRE_RUNE, 6, 2),
                    new WeightedChanceItem(Items.MIND_RUNE, 9, 2),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 2, 1),
                    new WeightedChanceItem(Items.COINS, 3, 38),
                    new WeightedChanceItem(Items.COINS, 25, 1),
                    new WeightedChanceItem(Items.FISHING_BAIT, 1, 5),
                    new WeightedChanceItem(Items.RAKE_5341, 1, 3),
                    new WeightedChanceItem(Items.EARTH_TALISMAN, 1, 2),
                    new WeightedChanceItem(Items.GARDENING_BOOTS_5345, 1, 2),
                    new WeightedChanceItem(Items.SEED_DIBBER_5343, 1, 2),
                    new WeightedChanceItem(Items.SECATEURS_5329, 1, 1),
                    new WeightedChanceItem(Items.WATERING_CAN8_5340, 1, 1)
            }),
    GUARD(new int[]{9, 32, 206, 296, 297, 298, 299, 344, 345, 346, 368}, 0, 18, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_BOLTS_9140, 2, 12, 10),
                    new WeightedChanceItem(Items.STEEL_ARROW, 1, 4),
                    new WeightedChanceItem(Items.BRONZE_ARROW, 1, 3),
                    new WeightedChanceItem(Items.AIR_RUNE, 6, 2),
                    new WeightedChanceItem(Items.EARTH_RUNE, 3, 2),
                    new WeightedChanceItem(Items.FIRE_RUNE, 2, 2),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 1, 1),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 1, 1),
                    new WeightedChanceItem(Items.NATURE_RUNE, 1, 1),
                    new WeightedChanceItem(Items.STEEL_ARROW, 5, 1),
                    new WeightedChanceItem(Items.COINS, 1, 19),
                    new WeightedChanceItem(Items.COINS, 7, 16),
                    new WeightedChanceItem(Items.COINS, 12, 9),
                    new WeightedChanceItem(Items.COINS, 4, 8),
                    new WeightedChanceItem(Items.COINS, 25, 4),
                    new WeightedChanceItem(Items.COINS, 17, 4),
                    new WeightedChanceItem(Items.COINS, 30, 2),
                    new WeightedChanceItem(Items.IRON_DAGGER, 1, 6),
                    new WeightedChanceItem(Items.BODY_TALISMAN, 1, 3),
                    new WeightedChanceItem(Items.GRAIN_1947, 1, 1),
                    new WeightedChanceItem(Items.IRON_ORE, 1, 1)
            }),
    BARBARIAN(new int[]{12, 3246, 3247, 3248, 3249, 3250, 3251, 3252, 3253, 3255, 3256, 3257, 3258, 3259, 3260, 3261, 3262, 3263, 3264}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_AXE, 1, 6),
                    new WeightedChanceItem(Items.BRONZE_BATTLEAXE, 1, 4),
                    new WeightedChanceItem(Items.IRON_MACE, 1, 1),
                    new WeightedChanceItem(Items.BRONZE_ARROW, 10, 4),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 3, 4),
                    new WeightedChanceItem(Items.IRON_ARROW, 8, 3),
                    new WeightedChanceItem(Items.EARTH_RUNE, 5, 3),
                    new WeightedChanceItem(Items.MIND_RUNE, 10, 2),
                    new WeightedChanceItem(Items.FIRE_RUNE, 8, 2),
                    new WeightedChanceItem(Items.LAW_RUNE, 2, 1),
                    new WeightedChanceItem(Items.COINS, 8, 42),
                    new WeightedChanceItem(Items.COINS, 12, 9),
                    new WeightedChanceItem(Items.COINS, 25, 5),
                    new WeightedChanceItem(Items.COINS, 32, 3),
                    new WeightedChanceItem(Items.COOKED_MEAT, 1, 1),
                    new WeightedChanceItem(Items.AMULET_MOULD_1595, 1, 1),
                    new WeightedChanceItem(Items.BEER, 1, 1),
                    new WeightedChanceItem(Items.BEAR_FUR_948, 1, 1),
                    new WeightedChanceItem(Items.FLIER_956, 1, 1),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 1)
            }),
    ABERRANT_SPECTRE(new int[]{1604, 1605, 1606, 1607}, 0, 0, 76, 0, 0, 0, 312, 0,
            new Item[]{},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.STEEL_AXE, 1, 12),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD, 1, 4),
                    new WeightedChanceItem(Items.LAVA_BATTLESTAFF, 1, 4),
                    new WeightedChanceItem(Items.ADAMANT_PLATELEGS, 1, 4),
                    new WeightedChanceItem(Items.RUNE_FULL_HELM, 1, 4),
                    new WeightedChanceItem(Items.MYSTIC_ROBE_BOTTOM_DARK, 1, 1),
                    new WeightedChanceItem(Items.COINS, 460, 4),
                    new WeightedChanceItem(0, 1, 55),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 20)
            }),
    ABYSSAL_DEMONS(new int[]{1615}, 0, 0, 0, 0, 0, 0, 76, 0,
            new Item[]{new Item(Items.ASHES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BLACK_SWORD, 1, 16),
                    new WeightedChanceItem(Items.STEEL_BATTLEAXE, 1, 12),
                    new WeightedChanceItem(Items.BLACK_AXE, 1, 8),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD, 1, 4),
                    new WeightedChanceItem(Items.RUNE_CHAINBODY, 1, 4),
                    new WeightedChanceItem(Items.RUNE_MED_HELM, 1, 4),
                    new WeightedChanceItem(Items.ABYSSAL_WHIP, 1, 1),
                    new WeightedChanceItem(Items.AIR_RUNE, 50, 32),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 10, 24),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 7, 16),
                    new WeightedChanceItem(Items.LAW_RUNE, 3, 4),
                    new WeightedChanceItem(Items.PURE_ESSENCE_NOTED, 60, 20),
                    new WeightedChanceItem(Items.ADAMANT_BAR, 1, 8),
                    new WeightedChanceItem(Items.COINS, 132, 140),
                    new WeightedChanceItem(Items.COINS, 220, 36),
                    new WeightedChanceItem(Items.COINS, 30, 28),
                    new WeightedChanceItem(Items.COINS, 44, 24),
                    new WeightedChanceItem(Items.COINS, 460, 4),
                    new WeightedChanceItem(Items.LOBSTER, 1, 8),
                    new WeightedChanceItem(Items.COSMIC_TALISMAN, 1, 4),
                    new WeightedChanceItem(Items.CHAOS_TALISMAN, 1, 4),
                    new WeightedChanceItem(Items.DEFENCE_POTION3, 1, 4),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 8)
            }),
    ANKOU(new int[]{4381, 4382, 4383}, 1, 0, 0, 0, 0, 0, 3, 0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BLACK_KNIFE_869, 1, 1),
                    new WeightedChanceItem(Items.BLACK_ROBE, 1, 1),
                    new WeightedChanceItem(Items.DEATH_RUNE, 10, 10),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 11, 6),
                    new WeightedChanceItem(Items.LAW_RUNE, 2, 6),
                    new WeightedChanceItem(Items.ADAMANT_ARROW, 5, 14, 4),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 5, 3),
                    new WeightedChanceItem(Items.PURE_ESSENCE_NOTED, 15, 5),
                    new WeightedChanceItem(Items.MITHRIL_ORE_NOTED, 3, 7, 2),
                    new WeightedChanceItem(Items.COINS, 8, 33),
                    new WeightedChanceItem(Items.COINS, 5, 204, 10),
                    new WeightedChanceItem(Items.FISHING_BAIT, 60, 30),
                    new WeightedChanceItem(Items.LEFT_SKULL_HALF_9008, 1, 3),
                    new WeightedChanceItem(Items.BASS, 1, 2),
                    new WeightedChanceItem(Items.WEAPON_POISON, 1, 2),
                    new WeightedChanceItem(Items.FRIED_MUSHROOMS_7082, 1, 1),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 2)
            }),
    AVIANSIE(IntStream.range(6232, 6247).toArray(), 0, 0, 0, 0, 0, 0, 15, 0,
            new Item[]{new Item(Items.BONES), new Item(Items.FEATHER, 6)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.RUNE_DAGGERP__5678, 1, 11),
                    new WeightedChanceItem(Items.AIR_RUNE, 15, 18),
                    new WeightedChanceItem(Items.WATER_RUNE, 30, 13),
                    new WeightedChanceItem(Items.LAW_RUNE, 2, 4),
                    new WeightedChanceItem(Items.NATURE_RUNE, 9, 4),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 3, 3),
                    new WeightedChanceItem(Items.BODY_RUNE, 12, 2),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 11, 2),
                    new WeightedChanceItem(Items.MIND_RUNE, 5, 1),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 16, 1),
                    new WeightedChanceItem(Items.ADAMANT_BAR, 4, 30),
                    new WeightedChanceItem(Items.SILVER_ORE_442, 1, 10),
                    new WeightedChanceItem(Items.RUNITE_LIMBS, 1, 1),
                    new WeightedChanceItem(Items.ANTIPOISON3_175, 5, 5),
                    new WeightedChanceItem(Items.SWORDFISH, 5, 2),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 3)
            }),
    BANSHEE(new int[]{1612}, 0, 0, 0, 0, 0, 0, 136, 0,
            new Item[]{},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_MACE, 1, 8),
                    new WeightedChanceItem(Items.IRON_DAGGER, 1, 8),
                    new WeightedChanceItem(Items.IRON_KITESHIELD, 1, 4),
                    new WeightedChanceItem(Items.MYSTIC_GLOVES_DARK, 1, 1),
                    new WeightedChanceItem(Items.AIR_RUNE, 3, 12),
                    new WeightedChanceItem(Items.COSMIC_RUNE, 2, 12),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 3, 8),
                    new WeightedChanceItem(Items.FIRE_RUNE, 7, 4),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 7, 4),
                    new WeightedChanceItem(Items.PURE_ESSENCE_NOTED, 13, 88),
                    new WeightedChanceItem(Items.IRON_ORE, 1, 4),
                    new WeightedChanceItem(Items.COINS, 13, 40),
                    new WeightedChanceItem(Items.COINS, 26, 32),
                    new WeightedChanceItem(Items.COINS, 35, 32),
                    new WeightedChanceItem(Items.FISHING_BAIT, 15, 88),
                    new WeightedChanceItem(Items.FISHING_BAIT, 7, 20),
                    new WeightedChanceItem(Items.EYE_OF_NEWT, 1, 4),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 8)
            }),
    BASILISK(new int[]{1616, 1617}, 0, 0, 0, 0, 0, 0, 140, 0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.MITHRIL_AXE, 1, 12),
                    new WeightedChanceItem(Items.STEEL_BATTLEAXE, 1, 12),
                    new WeightedChanceItem(Items.MITHRIL_SPEAR, 1, 8),
                    new WeightedChanceItem(Items.ADAMANT_FULL_HELM, 1, 4),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD, 1, 4),
                    new WeightedChanceItem(Items.RUNE_DAGGER, 1, 4),
                    new WeightedChanceItem(Items.MYSTIC_HAT_LIGHT, 1, 1),
                    new WeightedChanceItem(Items.WATER_RUNE, 75, 32),
                    new WeightedChanceItem(Items.NATURE_RUNE, 15, 20),
                    new WeightedChanceItem(Items.LAW_RUNE, 3, 12),
                    new WeightedChanceItem(Items.NATURE_RUNE, 37, 4),
                    new WeightedChanceItem(Items.ADAMANTITE_ORE, 1, 12),
                    new WeightedChanceItem(Items.COINS, 44, 115),
                    new WeightedChanceItem(Items.COINS, 200, 68),
                    new WeightedChanceItem(Items.COINS, 132, 20),
                    new WeightedChanceItem(Items.COINS, 11, 20),
                    new WeightedChanceItem(Items.COINS, 440, 4),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 20)
            }),
    BATS(new int[]{412}, 0, 0, 0, 0, 0, 0, 0, 0, new Item[]{new Item(Items.BAT_BONES)}, new ChanceItem[]{}, new WeightedChanceItem[]{}),
    GIANT_BATS(new int[]{78, 3711, 4345}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.BAT_BONES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.RARE),
                    new ChanceItem(12163, 1, DropFrequency.VERY_RARE)
            },
            new WeightedChanceItem[]{}),
    BEARS(new int[]{106, 105, 1195, 3645, 3664, 1326, 1327}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{
                    new Item(Items.BONES),
                    new Item(Items.BEAR_FUR_948),
                    new Item(Items.RAW_BEAR_MEAT)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{}),
    BIRDS(new int[]{1475, 5120, 5121, 5122, 5123, 5133, 1475, 1476, 41, 951, 1017, 1401, 1402, 2313, 2314, 2315, 1016, 1550, 147, 1180, 1754, 1755, 1756, 2252, 4570, 4571, 1911, 6114, 46, 2693, 6113, 6112, 146, 149, 150, 450, 451, 1179, 1322, 1323, 1324, 1325, 1400, 2726, 2727, 3197, 138, 4373, 4374, 4535, 139, 1751, 148, 1181, 6382, 2459, 2460, 2461, 2462, 2707, 2708, 6115, 6116, 3296, 6378, 1996, 3675, 3676, 6792}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.BONES), new Item(Items.FEATHER, 2)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{}),
    BLACK_DEMONS(new int[]{84, 677, 4702, 4703, 4704, 4705}, 0, 0, 0, 0, 0, 0, 23, 0,
            new Item[]{new Item(Items.ASHES, 1)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.RARE),
                    new ChanceItem(12163, 1, DropFrequency.VERY_RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BLACK_SWORD, 1, 4),
                    new WeightedChanceItem(Items.STEEL_BATTLEAXE, 1, 3),
                    new WeightedChanceItem(Items.BLACK_AXE, 1, 2),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD, 1, 1),
                    new WeightedChanceItem(Items.RUNE_MED_HELM, 1, 1),
                    new WeightedChanceItem(Items.RUNE_CHAINBODY, 1, 1),
                    new WeightedChanceItem(Items.AIR_RUNE, 50, 8),
                    new WeightedChanceItem(Items.CHAOS_RUNE, 10, 7),
                    new WeightedChanceItem(Items.BLOOD_RUNE, 7, 4),
                    new WeightedChanceItem(Items.FIRE_RUNE, 37, 1),
                    new WeightedChanceItem(Items.LAW_RUNE, 3, 1),
                    new WeightedChanceItem(Items.COINS, 132, 40),
                    new WeightedChanceItem(Items.COINS, 30, 7),
                    new WeightedChanceItem(Items.COINS, 44, 6),
                    new WeightedChanceItem(Items.COINS, 220, 6),
                    new WeightedChanceItem(Items.COINS, 460, 1),
                    new WeightedChanceItem(Items.LOBSTER, 1, 3),
                    new WeightedChanceItem(Items.ADAMANT_BAR, 1, 2),
                    new WeightedChanceItem(Items.DEFENCE_POTION3, 1, 1),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID, 1, 1)
            }),
    BLACK_DRAGONS(new int[]{240, 54, 4673, 4674, 4675, 4676, 3376}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.DRAGON_BONES, 1), new Item(Items.BLACK_DRAGONHIDE, 1)},
            new ChanceItem[]{ // charms
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{ // main
                    new WeightedChanceItem(Items.MITHRIL_2H_SWORD, 1, 4),
                    new WeightedChanceItem(Items.MITHRIL_AXE,1,3),
                    new WeightedChanceItem(Items.MITHRIL_BATTLEAXE,1,3),
                    new WeightedChanceItem(Items.RUNE_KNIFE,2,3),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD,1,1),
                    new WeightedChanceItem(Items.ADAMANT_PLATEBODY,1,1),
                    new WeightedChanceItem(Items.RUNE_LONGSWORD,1,1),
                    new WeightedChanceItem(Items.ADAMANT_JAVELIN,30,20),
                    new WeightedChanceItem(Items.FIRE_RUNE,50,8),
                    new WeightedChanceItem(Items.ADAMANT_DARTP,16,7),
                    new WeightedChanceItem(Items.LAW_RUNE,10,5),
                    new WeightedChanceItem(Items.BLOOD_RUNE,15,3),
                    new WeightedChanceItem(Items.AIR_RUNE,75,1),
                    new WeightedChanceItem(Items.COINS,196,40),
                    new WeightedChanceItem(Items.COINS,330,10),
                    new WeightedChanceItem(Items.COINS,690,1),
                    new WeightedChanceItem(Items.ADAMANT_BAR,1,3),
                    new WeightedChanceItem(Items.CHOCOLATE_CAKE,1,3),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,2)
            },
            new ChanceItem[]{ // tertiary
                    new ChanceItem(Items.DRACONIC_VISAGE,1,10000)
            }),
    BLOODVELD(new int[]{1618, 1619, 6215, 7643, 7642},0,0,0,0,0,0,1,0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.STEEL_AXE,1,4),
                    new WeightedChanceItem(Items.STEEL_FULL_HELM,1,4),
                    new WeightedChanceItem(Items.STEEL_SCIMITAR,1,2),
                    new WeightedChanceItem(Items.BLACK_BOOTS,1,1),
                    new WeightedChanceItem(Items.MITHRIL_SQ_SHIELD,1,1),
                    new WeightedChanceItem(Items.MITHRIL_CHAINBODY,1,1),
                    new WeightedChanceItem(Items.RUNE_MED_HELM,1,1),
                    new WeightedChanceItem(Items.FIRE_RUNE,60,8),
                    new WeightedChanceItem(Items.BLOOD_RUNE,10,5),
                    new WeightedChanceItem(Items.BLOOD_RUNE,3,3),
                    new WeightedChanceItem(Items.BLOOD_RUNE,30,1),
                    new WeightedChanceItem(Items.COINS,120,30),
                    new WeightedChanceItem(Items.COINS,40,30),
                    new WeightedChanceItem(Items.COINS,200,10),
                    new WeightedChanceItem(Items.COINS,10,7),
                    new WeightedChanceItem(Items.COINS,450,1),
                    new WeightedChanceItem(Items.BONES,1,10),
                    new WeightedChanceItem(Items.BIG_BONES,1,7),
                    new WeightedChanceItem(Items.BIG_BONES,3,3),
                    new WeightedChanceItem(Items.MEAT_PIZZA,1,3),
                    new WeightedChanceItem(Items.GOLD_ORE,1,2),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,4)
            }),
    BLUE_DRAGON(new int[]{55, 4681, 4682, 4683, 4684, 5178, 52, 4665, 4666},0,0,0,0,0,0,15,0,
            new Item[]{new Item(Items.BLUE_DRAGONHIDE,1),new Item(Items.DRAGON_BONES,1)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.STEEL_PLATELEGS,1,4),
                    new WeightedChanceItem(Items.MITHRIL_AXE,1,3),
                    new WeightedChanceItem(Items.STEEL_BATTLEAXE,1,3),
                    new WeightedChanceItem(Items.MITHRIL_SPEAR,1,2),
                    new WeightedChanceItem(Items.ADAMANT_FULL_HELM,1,1),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD,1,1),
                    new WeightedChanceItem(Items.RUNE_DAGGER,1,1),
                    new WeightedChanceItem(Items.WATER_RUNE,75,8),
                    new WeightedChanceItem(Items.NATURE_RUNE,15,5),
                    new WeightedChanceItem(Items.LAW_RUNE,3,3),
                    new WeightedChanceItem(Items.FIRE_RUNE,37,1),
                    new WeightedChanceItem(Items.COINS,44,29),
                    new WeightedChanceItem(Items.COINS,132,25),
                    new WeightedChanceItem(Items.COINS,200,10),
                    new WeightedChanceItem(Items.COINS,11,5),
                    new WeightedChanceItem(Items.COINS,440,1),
                    new WeightedChanceItem(Items.ADAMANTITE_ORE,1,3),
                    new WeightedChanceItem(Items.BASS,1,3),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,5)
            }),
    BRINE_RAT(new int[] {3707},0,0,0,0,0,0,0,0,
            new Item[]{new Item(Items.BONES), new Item(Items.RAW_RAT_MEAT)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BRINE_SABRE_11037,1,1),
                    new WeightedChanceItem(Items.DEATH_RUNE,7,72),
                    new WeightedChanceItem(Items.EARTH_RUNE,10,24),
                    new WeightedChanceItem(Items.EARTH_RUNE,36,16),
                    new WeightedChanceItem(Items.WATER_RUNE,10,12),
                    new WeightedChanceItem(Items.AIR_RUNE,18,8),
                    new WeightedChanceItem(Items.EARTH_RUNE,18,8),
                    new WeightedChanceItem(Items.WATER_RUNE,18,8),
                    new WeightedChanceItem(Items.BLOOD_RUNE,4,8),
                    new WeightedChanceItem(Items.RAW_LOBSTER_NOTED_378,10,24),
                    new WeightedChanceItem(Items.RAW_SHARK_NOTED_384,3,24),
                    new WeightedChanceItem(Items.RAW_RAT_MEAT_NOTED,18,8),
                    new WeightedChanceItem(Items.RAW_PIKE_NOTED_350,18,8),
                    new WeightedChanceItem(Items.RAW_SHARK_NOTED_384,8,8),
                    new WeightedChanceItem(Items.RAW_SWORDFISH,9,8),
                    new WeightedChanceItem(Items.RAW_SHARK,1,4),
                    new WeightedChanceItem(Items.COINS,1,84),
                    new WeightedChanceItem(Items.COINS,2,64),
                    new WeightedChanceItem(Items.COINS,4,36),
                    new WeightedChanceItem(Items.COINS,29,12),
                    new WeightedChanceItem(0,1,64),
                    new WeightedChanceItem(Items.WATER_TALISMAN,1,12)
            }),
    BRONZE_DRAGON(new int[]{1590}, 0,0,0,0,0,0,0,0,
            new Item[]{new Item(Items.DRAGON_BONES), new Item(Items.BRONZE_BAR,5)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.UNCOMMON),
                    new ChanceItem(12163, 1, DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.ADAMANT_DARTP,16,7),
                    new WeightedChanceItem(Items.MITHRIL_2H_SWORD,1,4),
                    new WeightedChanceItem(Items.MITHRIL_AXE,1,3),
                    new WeightedChanceItem(Items.MITHRIL_BATTLEAXE,1,3),
                    new WeightedChanceItem(Items.RUNE_KNIFE,2,3),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD,1,1),
                    new WeightedChanceItem(Items.ADAMANT_PLATEBODY,1,1),
                    new WeightedChanceItem(Items.RUNE_LONGSWORD,1,1),
                    new WeightedChanceItem(Items.ADAMANT_JAVELIN,30,20),
                    new WeightedChanceItem(Items.FIRE_RUNE,50,8),
                    new WeightedChanceItem(Items.MITHRIL_BOLTS,2,12,6),
                    new WeightedChanceItem(Items.LAW_RUNE,10,5),
                    new WeightedChanceItem(Items.BLOOD_RUNE,15,3),
                    new WeightedChanceItem(Items.DEATH_RUNE,25,1),
                    new WeightedChanceItem(Items.COINS,196,40),
                    new WeightedChanceItem(Items.COINS,330,10),
                    new WeightedChanceItem(Items.COINS,690,1),
                    new WeightedChanceItem(Items.ADAMANT_BAR,1,3),
                    new WeightedChanceItem(Items.SWORDFISH,2,2),
                    new WeightedChanceItem(Items.SWORDFISH,1,1),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,1)
            },
            new ChanceItem[]{
                    new ChanceItem(Items.DRAGON_PLATELEGS,1,2048),
                    new ChanceItem(Items.DRAGON_PLATESKIRT,1,2048)
            }),
    CATABLEPON(new int[] {4397, 4398, 4399},0,0,0,0,1,0,3,0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.RARE),
                    new ChanceItem(12163, 1, DropFrequency.VERY_RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.ADAMANT_MED_HELM,1,1),
                    new WeightedChanceItem(Items.FIRE_RUNE,15,7),
                    new WeightedChanceItem(Items.WATER_RUNE,7,6),
                    new WeightedChanceItem(Items.LAW_RUNE,2,4),
                    new WeightedChanceItem(Items.MITHRIL_ARROW,5,14,4),
                    new WeightedChanceItem(Items.COSMIC_RUNE,2,3),
                    new WeightedChanceItem(Items.CHAOS_RUNE,7,1),
                    new WeightedChanceItem(Items.EYE_OF_NEWT,1,7),
                    new WeightedChanceItem(Items.RUNE_ESSENCE_NOTED,15,5),
                    new WeightedChanceItem(Items.PURE_ESSENCE_NOTED,15,5),
                    new WeightedChanceItem(Items.COAL_NOTED,3,7,20),
                    new WeightedChanceItem(Items.COINS,44,12),
                    new WeightedChanceItem(Items.COINS,5,104,10),
                    new WeightedChanceItem(Items.COINS,15,6),
                    new WeightedChanceItem(Items.UNLIT_TORCH_596,1,9),
                    new WeightedChanceItem(Items.TOP_OF_SCEPTRE_9010,1,9),
                    new WeightedChanceItem(Items.TROUT_333,1,2),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,2)
            }),
    CAVE_BUG(new int[] {1832, 5750},0,0,0,0,0,0,24,0,
            new Item[]{new Item(Items.NOTHING)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.WATER_RUNE,8,5),
                    new WeightedChanceItem(Items.NATURE_RUNE,1,5),
                    new WeightedChanceItem(Items.EARTH_RUNE,6,2),
                    new WeightedChanceItem(Items.NATURE_RUNE,2,1),
                    new WeightedChanceItem(Items.UNICORN_HORN_DUST,1,2),
                    new WeightedChanceItem(Items.EYE_OF_NEWT,1,2),
                    new WeightedChanceItem(Items.RED_SPIDERS_EGGS,1,2),
                    new WeightedChanceItem(Items.LIMPWURT_ROOT,1,1),
                    new WeightedChanceItem(Items.SNAPE_GRASS,1,1),
                    new WeightedChanceItem(Items.COINS,3,8),
                    new WeightedChanceItem(Items.COINS,8,3),
                    new WeightedChanceItem(Items.CANDLE_36,1,5),
                    new WeightedChanceItem(Items.TINDERBOX,1,3),
                    new WeightedChanceItem(Items.EMPTY_CANDLE_LANTERN_4527,1,1)
    }),
    CAVE_CRAWLERS(new int[]{1600, 1601, 1602, 1603},26,0,0,0,0,0,22,0,
            new Item[]{new Item(Items.NOTHING)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BRONZE_BOOTS,1,1),
                    new WeightedChanceItem(Items.NATURE_RUNE,3,4,6),
                    new WeightedChanceItem(Items.FIRE_RUNE,12,5),
                    new WeightedChanceItem(Items.EARTH_RUNE,9,2),
                    new WeightedChanceItem(Items.VIAL_OF_WATER,1,13),
                    new WeightedChanceItem(Items.WHITE_BERRIES,1,5),
                    new WeightedChanceItem(Items.UNICORN_HORN_DUST,1,2),
                    new WeightedChanceItem(Items.EYE_OF_NEWT,1,1),
                    new WeightedChanceItem(Items.RED_SPIDERS_EGGS,1,1),
                    new WeightedChanceItem(Items.LIMPWURT_ROOT,1,1),
                    new WeightedChanceItem(Items.SNAPE_GRASS,1,1),
                    new WeightedChanceItem(Items.COINS,3,5),
                    new WeightedChanceItem(Items.COINS,8,3),
                    new WeightedChanceItem(Items.COINS,29,3),
                    new WeightedChanceItem(Items.COINS,10,1),
                    new WeightedChanceItem(Items.NOTHING,1,29),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,1)
            }),
    CAVE_HORRORS(new int[]{4353, 4354, 4355, 4356, 4357},0,0,18,0,15,0,13,0,
            new Item[]{
                    new Item(Items.BIG_BONES)
            },
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.RARE),
                    new ChanceItem(12163, 1, DropFrequency.VERY_RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.MITHRIL_AXE,1,3),
                    new WeightedChanceItem(Items.RUNE_DAGGER,1,1),
                    new WeightedChanceItem(Items.ADAMANT_FULL_HELM,1,1),
                    new WeightedChanceItem(Items.MITHRIL_KITESHIELD,1,1),
                    new WeightedChanceItem(Items.NATURE_RUNE,6,6),
                    new WeightedChanceItem(Items.NATURE_RUNE,4,5),
                    new WeightedChanceItem(Items.NATURE_RUNE,3,1),
                    new WeightedChanceItem(Items.COINS,44,28),
                    new WeightedChanceItem(Items.COINS,132,12),
                    new WeightedChanceItem(Items.COINS,440,1),
                    new WeightedChanceItem(Items.LIMPWURT_ROOT,1,7),
                    new WeightedChanceItem(Items.TEAK_LOGS_NOTED_6334,4,7),
                    new WeightedChanceItem(Items.MAHOGANY_LOGS_6332,2,3),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,5)
            },
            new ChanceItem[]{
                    new ChanceItem(Items.BLACK_MASK_10_8901,1,512)
            }),
    CAVE_SLIMES(new int[]{1831}, 0,0,0,0,0,0,0,0,
            new Item[]{new Item(Items.SWAMP_TAR_1939,2)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_SWORD,1,7),
                    new WeightedChanceItem(Items.BRONZE_AXE,1,3),
                    new WeightedChanceItem(Items.IRON_KITESHIELD,1,2),
                    new WeightedChanceItem(Items.BRONZE_FULL_HELM,1,1),
                    new WeightedChanceItem(Items.IRON_BOOTS,1,1),
                    new WeightedChanceItem(Items.WATER_RUNE,15,5),
                    new WeightedChanceItem(Items.EARTH_RUNE,5,3),
                    new WeightedChanceItem(Items.COINS,10,39),
                    new WeightedChanceItem(Items.COINS,4,30),
                    new WeightedChanceItem(Items.COINS,22,10),
                    new WeightedChanceItem(Items.COINS,1,7),
                    new WeightedChanceItem(Items.COINS,46,2),
                    new WeightedChanceItem(Items.UNLIT_TORCH_596,1,11),
                    new WeightedChanceItem(Items.GOLD_BAR,1,2),
                    new WeightedChanceItem(Items.OIL_LANTERN_FRAME_4540,1,1),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,4)
            }),
    COCKATRICE(new int[] {1620, 1621, 4227}, 0,18,0,0,0,0,10,0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON),
                    new ChanceItem(12159, 1, DropFrequency.COMMON),
                    new ChanceItem(12160, 1, DropFrequency.RARE),
                    new ChanceItem(12163, 1, DropFrequency.VERY_RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_SWORD,1,3),
                    new WeightedChanceItem(Items.STEEL_DAGGER,1,3),
                    new WeightedChanceItem(Items.IRON_BOOTS,1,1),
                    new WeightedChanceItem(Items.IRON_JAVELIN,5,1),
                    new WeightedChanceItem(Items.STEEL_LONGSWORD,1,1),
                    new WeightedChanceItem(Items.NATURE_RUNE,2,6,6),
                    new WeightedChanceItem(Items.LAW_RUNE,2,3),
                    new WeightedChanceItem(Items.WATER_RUNE,2,2),
                    new WeightedChanceItem(Items.FIRE_RUNE,7,1),
                    new WeightedChanceItem(Items.COINS,15,16),
                    new WeightedChanceItem(Items.COINS,5,12),
                    new WeightedChanceItem(Items.COINS,28,12),
                    new WeightedChanceItem(Items.COINS,62,4),
                    new WeightedChanceItem(Items.COINS,42,3),
                    new WeightedChanceItem(Items.COINS,1,1),
                    new WeightedChanceItem(Items.LIMPWURT_ROOT,1,21),
                    new WeightedChanceItem(Items.NOTHING,1,17),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,2)
            },
            new ChanceItem[]{
                    new ChanceItem(Items.MYSTIC_BOOTS_LIGHT,1,512)
            }),
    COWS(new int[]{1766, 1768, 2310, 81, 397, 955, 1767, 3309},0,0,0,0,0,0,0,0,
            new Item[]{
                    new Item(Items.COWHIDE,1),
                    new Item(Items.RAW_BEEF,1),
                    new Item(Items.BONES,1)
            },
            new ChanceItem[]{
                    new ChanceItem(12158, 1, DropFrequency.COMMON)
            },
            new WeightedChanceItem[]{}),
    CRAWLING_HAND(new int[]{1648, 1649, 1650, 1651, 1652, 1653, 1654, 1655, 1656, 1657, 4226, 7640, 7641},0,0,0,0,0,0,0,0,
            new Item[]{},
            new ChanceItem[]{
                    new ChanceItem(Items.GOLD_CHARM,1,DropFrequency.COMMON)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.PURPLE_GLOVES_2942,1,2),
                    new WeightedChanceItem(Items.YELLOW_GLOVES_2922,1,2),
                    new WeightedChanceItem(Items.RED_GLOVES_2912,1,2),
                    new WeightedChanceItem(Items.TEAL_GLOVES_2932,1,2),
                    new WeightedChanceItem(Items.LEATHER_GLOVES,1,20),
                    new WeightedChanceItem(Items.GOLD_RING,1,3),
                    new WeightedChanceItem(Items.SAPPHIRE_RING_1637,1,2),
                    new WeightedChanceItem(Items.EMERALD_RING_1639,1,2),
                    new WeightedChanceItem(Items.COINS,5,10,43),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,4),
                    new WeightedChanceItem(Items.NOTHING,1,44)
            }),
    CROCODILE(new int[]{1993, 6779},0,0,0,0,0,0,0,0,
            new Item[]{new Item(Items.BONES)}, new ChanceItem[]{}, new WeightedChanceItem[]{}),
    CYCLOPES(new int[]{ 116, 4291, 4292, 6078, 6079, 6080, 6081, 6269, 6270},1,0,0,0,0,0,3,0,
            new Item[]{new Item(Items.BIG_BONES,1)},
            new ChanceItem[]{
                    new ChanceItem(Items.GOLD_CHARM,1,DropFrequency.COMMON),
                    new ChanceItem(Items.GREEN_CHARM,1,DropFrequency.COMMON),
                    new ChanceItem(Items.BLUE_CHARM,1,DropFrequency.UNCOMMON),
                    new ChanceItem(Items.CRIMSON_CHARM,1,DropFrequency.RARE)
            },
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.BLACK_KNIFE_869,4,13,16),
                    new WeightedChanceItem(Items.STEEL_CHAINBODY,1,2),
                    new WeightedChanceItem(Items.IRON_2H_SWORD,1,2),
                    new WeightedChanceItem(Items.IRON_CHAINBODY,1,2),
                    new WeightedChanceItem(Items.STEEL_DAGGER,1,2),
                    new WeightedChanceItem(Items.STEEL_MACE,1,2),
                    new WeightedChanceItem(Items.STEEL_SWORD,1,2),
                    new WeightedChanceItem(Items.STEEL_BATTLEAXE,1,2),
                    new WeightedChanceItem(Items.STEEL_2H_SWORD,1,2),
                    new WeightedChanceItem(Items.STEEL_LONGSWORD,1,2),
                    new WeightedChanceItem(Items.STEEL_MED_HELM,1,2),
                    new WeightedChanceItem(Items.BLACK_2H_SWORD,1,1),
                    new WeightedChanceItem(Items.MITHRIL_DAGGER,1,1),
                    new WeightedChanceItem(Items.MITHRIL_LONGSWORD,1,1),
                    new WeightedChanceItem(Items.ADAMANT_MACE,1,1),
                    new WeightedChanceItem(Items.BLACK_SWORD,1,1),
                    new WeightedChanceItem(Items.BLACK_LONGSWORD,1,1),
                    new WeightedChanceItem(Items.BLACK_DAGGER,1,1),
                    new WeightedChanceItem(Items.ADAMANT_2H_SWORD,1,1),
                    new WeightedChanceItem(Items.COINS,3,102,31),
                    new WeightedChanceItem(Items.COINS,5,204,10),
                    new WeightedChanceItem(RareDropTable.SLOT_ITEM_ID,1,2)
            }),
    DAGGANOTHS(new int[]{1338, 1339, 1340, 1341, 1342, 1343, 1344, 1345, 1346, 1347, 2454, 2455, 2456, 2887, 2888, 3591},0,0,18,0,0,0,0,0,
            new Item[]{new Item(Items.BONES)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{
                    new WeightedChanceItem(Items.IRON_SPEAR,1,6),
                    new WeightedChanceItem(Items.BRONZE_SPEAR,1,5),
                    new WeightedChanceItem(Items.MITHRIL_SPEAR,1,1),
                    new WeightedChanceItem(Items.WATER_RUNE,15,8),
                    new WeightedChanceItem(Items.STEEL_ARROW,15,2),
                    new WeightedChanceItem(Items.MITHRIL_JAVELIN,3,1),
                    new WeightedChanceItem(Items.LOBSTER_POT_301,1,12),
                    new WeightedChanceItem(Items.RAW_HERRING_345,3,4),
                    new WeightedChanceItem(Items.RAW_SARDINE_327,5,4),
                    new WeightedChanceItem(Items.HARPOON_311,1,3),
                    new WeightedChanceItem(Items.FEATHER,15,4),
                    new WeightedChanceItem(Items.FISHING_BAIT,50,4),
                    new WeightedChanceItem(Items.RAW_LOBSTER,1,4),
                    new WeightedChanceItem(Items.RAW_TUNA_359,1,4),
                    new WeightedChanceItem(Items.SEAWEED,10,4),
                    new WeightedChanceItem(Items.OYSTER_PEARL,1,2,1)
            }),
    OOMLIE_BIRD(new int[]{48}, 0, 0, 0, 0, 0, 0, 0, 0,
            new Item[]{new Item(Items.BONES), new Item(Items.RAW_OOMLIE_2337)},
            new ChanceItem[]{},
            new WeightedChanceItem[]{});
    //WARPED_TERROR_BIRDS(new int[]{6285, 6286, 6287, 6288, 6289, 6290, 6291, 6292, 6293, 6294, 6295, 6322, 6323, 6324, 6325, 6326, 6327, 6328, 6329, 6330, 6331, 6332})
    //UNDEAD_CHICKEN(new int[]{1692})
    //map our npc ids to their drop table
    public static HashMap<Integer, DropTables> dropTableMap = new HashMap<>();

    static {
        for (DropTables table : DropTables.values()) {
            for (int npc_id : table.ids) {
                dropTableMap.putIfAbsent(npc_id, table);
            }
        }
    }

    public int[] ids;
    public WeightedChanceItem[] table;
    public Item[] always;
    public ChanceItem[] charms;
    public ChanceItem[] tertiary;
    int[] sharedTableWeights;

    DropTables(int[] ids, int commonSeed, int fixedAllot, int rareSeed, int treeHerb, int varAllot, int hops, int herbs, int usefulHerbs, Item[] always, ChanceItem[] charms, WeightedChanceItem[] table) {
        this.ids = ids;
        this.table = table;
        this.sharedTableWeights = new int[]{commonSeed, fixedAllot, rareSeed, treeHerb, varAllot, hops, herbs, usefulHerbs};
        this.always = always;
        this.charms = charms;
    }

    DropTables(int[] ids, int commonSeed, int fixedAllot, int rareSeed, int treeHerb, int varAllot, int hops, int herbs, int usefulHerbs, Item[] always, ChanceItem[] charms, WeightedChanceItem[] table, ChanceItem[] tertiary){
        this(ids,commonSeed,fixedAllot,rareSeed,treeHerb,varAllot,hops,herbs,usefulHerbs,always,charms,table);
        this.tertiary = tertiary;
    }

    public static DropTables forId(int id){
        return dropTableMap.get(id);
    }

    public List<Item> getDrops(){
        //roll all of our shared drop tables that this npc can roll on.
        List<WeightedChanceItem> sharedTablesRolls = new ArrayList<>();
        for(int i = 0; i < sharedTableWeights.length; i++){
            if(sharedTableWeights[i] == 0){
                continue;
            }
            //roll on the table and add a WeightedChanceItem with the table's weight to the list
            Item temp = RandomFunction.rollWeightedChanceTable(SharedTables.values()[i].table);
            sharedTablesRolls.add(new WeightedChanceItem(temp.getId(),temp.getAmount(),sharedTableWeights[i]));
        }
        //make a copy of our table and add shared table rolls with their weights into it
        List<WeightedChanceItem> tempCopy = new ArrayList<>(Arrays.asList(table));
        tempCopy.addAll(sharedTablesRolls);

        //build our rewards list
        List<Item> rewards = new ArrayList<>();
        rewards.addAll(Arrays.asList(always));
        rewards.add(RandomFunction.rollWeightedChanceTable(tempCopy));
        rewards.addAll(RandomFunction.rollChanceTable(false,charms));

        //roll our tertiary table (usually reserved for extremely rare drops, so not always present.)
        if(tertiary != null){
            rewards.addAll(RandomFunction.rollChanceTable(false,tertiary));
        }


        tempCopy.clear();
        return rewards;
    }
}
