package me.eccentric_nz.plugins.profession;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;

public class Constants {

    public static String MY_PLUGIN_NAME;
    public static String LANGUAGE;
    public static Boolean CONSUME;
    public static String CONFIG_FILE_NAME = "config.yml";
    public static String MAT_FILE_NAME = "Materials.txt";

    public static HashMap npm() {
        // permission messages
        HashMap NO_PERMS_MESSAGE = new HashMap<String, String>();
        NO_PERMS_MESSAGE.put("EN", "You do not have permission to change villager professions");
        NO_PERMS_MESSAGE.put("FR", "Vous n'avez pas la permission de changer les occupations des villageois");
        NO_PERMS_MESSAGE.put("DE", "Sie haben keine berechtigung, um die berufe der dorfbewohner ändern");
        NO_PERMS_MESSAGE.put("ES", "Usted no tiene permiso para cambiar las profesiones de los habitantes del pueblo");
        return NO_PERMS_MESSAGE;
    }

    public static HashMap nms() {
        // material messages
        HashMap NO_MATS_START = new HashMap<String, String>();
        NO_MATS_START.put("EN", "You do not have the right material to change the profession of this villager .\nTry:\n");
        NO_MATS_START.put("FR", "Vous n'avez pas le bon matériel pour changer la profession de ce villageois.\nEssayez:\n");
        NO_MATS_START.put("DE", "Sie verfügen nicht über das richtige material, um den beruf dieses dorfbewohnerin zu ändern.\nversuchen Sie:\n");
        NO_MATS_START.put("ES", "Usted no tiene el material correcto para cambiar de ocupación este aldeano.\nPruebe:\n");
        return NO_MATS_START;
    }

    public static HashMap tma() {
        // command too many arguments messages
        HashMap TOO_MANY_ARGS = new HashMap<String, String>();
        TOO_MANY_ARGS.put("EN", "There are too many command arguments!");
        TOO_MANY_ARGS.put("FR", "Il existe des arguments de commande trop nombreux!");
        TOO_MANY_ARGS.put("DE", "Zu viele argumente befehl!");
        TOO_MANY_ARGS.put("ES", "Hay argumentos del comando demasiados!");
        return TOO_MANY_ARGS;
    }

    public static HashMap tfa() {
        // command too few arguments messages
        HashMap TOO_FEW_ARGS = new HashMap<String, String>();
        TOO_FEW_ARGS.put("EN", "There are not enough command arguments!");
        TOO_FEW_ARGS.put("FR", "Les arguments de la commande sont trop peu nombreux!");
        TOO_FEW_ARGS.put("DE", "Es gibt nicht genügend argumente befehl!");
        TOO_FEW_ARGS.put("ES", "El número de argumentos del comando es demasiado escasa!");
        return TOO_FEW_ARGS;
    }

    public static HashMap nvv() {
        // command  not valid villager type messages
        HashMap NOT_VALID_VILLAGER = new HashMap<String, String>();
        NOT_VALID_VILLAGER.put("EN", "That is not a valid Villager type!\nTry:");
        NOT_VALID_VILLAGER.put("FR", "Ce n'est pas un type valide de Villager! Essayez:");
        NOT_VALID_VILLAGER.put("DE", "Das ist kein gültiger typ von Villager! versuchen Sie:");
        NOT_VALID_VILLAGER.put("ES", "Eso no es un tipo válido de Villager! Pruebe:");
        return NOT_VALID_VILLAGER;
    }

    public static HashMap nvm() {
        // command not valid material type messages
        HashMap NOT_VALID_MATERIAL = new HashMap<String, String>();
        NOT_VALID_MATERIAL.put("EN", "That is not a valid Material!\nTry checking the Materials.txt file in the plugins/Profession folder");
        NOT_VALID_MATERIAL.put("FR", "Ce n'est pas un matériau valide! Essayez de vérifier le fichier Materials.txt dans les dossier plugins/Profession");
        NOT_VALID_MATERIAL.put("DE", "Das ist keine gültige werkstoff! Versuchen Sie, die Materials.txt Datei in den Ordner plugins/Professions");
        NOT_VALID_MATERIAL.put("ES", "Eso no es un material válido! Prueba a revisar el archivo Materials.txt en los carpeta plugins/Profession");
        return NOT_VALID_MATERIAL;
    }

    public static HashMap ssm(ChatColor col, Villager.Profession str) {
        // profession set success messages
        HashMap SET_SUCCESS = new HashMap<String, String>();
        SET_SUCCESS.put("EN", "The villager was changed to a " + col + str);
        SET_SUCCESS.put("FR", "Le villageois a été changé à un " + col + str);
        SET_SUCCESS.put("DE", "Der dorfbewohner wurde zu einer " + col + str + ChatColor.WHITE + " geändert");
        SET_SUCCESS.put("ES", "El aldeano se cambió a un " + col + str);
        return SET_SUCCESS;
    }

    public static HashMap vms(String vil, String typ) {
        // profession set success messages
        HashMap MAT_SET_OK = new HashMap<String, String>();
        MAT_SET_OK.put("EN", "The " + vil + " material was set to " + typ);
        MAT_SET_OK.put("FR", "Le matériel des " + vil + " a été changé pour " + typ);
        MAT_SET_OK.put("DE", "Die " + vil + " material wurde auf " + typ + " geändert");
        MAT_SET_OK.put("ES", "El material " + vil + " se cambió a " + typ);
        return MAT_SET_OK;
    }

    public static HashMap wnf() {
        // profession world not found messages
        HashMap WORLD_NOT_FOUND = new HashMap<String, String>();
        WORLD_NOT_FOUND.put("EN", "Could not find the specified world!");
        WORLD_NOT_FOUND.put("FR", "Impossible de trouver le monde spécifié!");
        WORLD_NOT_FOUND.put("DE", "Konnte nicht gefunden werden die angegebene Welt!");
        WORLD_NOT_FOUND.put("ES", "No se pudo encontrar el mundo especificado!");
        return WORLD_NOT_FOUND;
    }

    public static HashMap ntf() {
        // argument should be true or false messages
        HashMap NOT_TRUE_FALSE = new HashMap<String, String>();
        NOT_TRUE_FALSE.put("EN", "The second command argument should be true or false!");
        NOT_TRUE_FALSE.put("FR", "L'argument deuxième commande devrait être vraie ou fausse!");
        NOT_TRUE_FALSE.put("DE", "Der zweite befehl Argument sollte wahr oder falsch sein!");
        NOT_TRUE_FALSE.put("ES", "El argumento segundo comando debe ser verdadero o falso!");
        return NOT_TRUE_FALSE;
    }

    public static HashMap wds(String wor) {
        // profession toggled off messages
        HashMap WORLD_DISABLED = new HashMap<String, String>();
        WORLD_DISABLED.put("EN", "Profession has been disabled in " + wor);
        WORLD_DISABLED.put("FR", "Profession a été désactivé dans ");
        WORLD_DISABLED.put("DE", "Profession hat in " + wor + " wurde deaktiviert");
        WORLD_DISABLED.put("ES", "Profession ha sido desactivado en " + wor);
        return WORLD_DISABLED;
    }

    public static HashMap wes(String wor) {
        // profession toggled on messages
        HashMap WORLD_ENABLED = new HashMap<String, String>();
        WORLD_ENABLED.put("EN", "Profession has been enabled in " + wor);
        WORLD_ENABLED.put("FR", "Profession a été activé dans " + wor);
        WORLD_ENABLED.put("DE", "Profession hat in " + wor + " aktivierten wurde");
        WORLD_ENABLED.put("ES", "Profession ha sido habilitada en " + wor);
        return WORLD_ENABLED;
    }

    public static HashMap pna(String wor) {
        // profession not enabled messages
        HashMap NOT_ENABLED = new HashMap<String, String>();
        NOT_ENABLED.put("EN", "Profession is disabled in " + wor + ". Use /worldprof to enable it");
        NOT_ENABLED.put("FR", "Profession est désactivé dans " + wor + ". Utilisez / worldprof pour lui permettre");
        NOT_ENABLED.put("DE", "Profession wird in " + wor + " deaktiviert. Verwenden Sie /worldprof um es zu aktivieren");
        NOT_ENABLED.put("ES", "Profession está desactivado en " + wor + ". Utilice / worldprof para activarlo");
        return NOT_ENABLED;
    }

    public static HashMap cen() {
        // consume cofig enabled messages
        HashMap CONSUME_ENABLE = new HashMap<String, String>();
        CONSUME_ENABLE.put("EN", "Consuming materials was enabled");
        CONSUME_ENABLE.put("FR", "La consommation de matériaux a été activée");
        CONSUME_ENABLE.put("DE", "Der konsum von materialien war aktiviert");
        CONSUME_ENABLE.put("ES", "El consumo de materiales se ha habilitado");
        return CONSUME_ENABLE;
    }

    public static HashMap cds() {
        // consume config disabled messages
        HashMap CONSUME_ENABLE = new HashMap<String, String>();
        CONSUME_ENABLE.put("EN", "Consuming materials was disabled");
        CONSUME_ENABLE.put("FR", "La consommation de matériaux a été désactivé");
        CONSUME_ENABLE.put("DE", "Der konsum von materialien war deaktiviert");
        CONSUME_ENABLE.put("ES", "El consumo de materiales se ha desactivado");
        return CONSUME_ENABLE;
    }
    public static String NO_MATS_MESSAGE;
    public static String SECRETARY_ENABLED = "You have the Secretary plugin installed!";
    // arrays for command checking
    public static String[] V_TYPES = {
        "BLACKSMITH",
        "BUTCHER",
        "FARMER",
        "LIBRARIAN",
        "PRIEST"
    };
    public static String[] MATERIAL_LIST = {
        "AIR",
        "ANVIL",
        "APPLE",
        "ARROW",
        "BAKED_POTATO",
        "BEACON",
        "BED",
        "BED_BLOCK",
        "BEDROCK",
        "BIRCH_WOOD_STAIRS",
        "BLAZE_POWDER",
        "BLAZE_ROD",
        "BOAT",
        "BONE",
        "BOOK",
        "BOOK_AND_QUILL",
        "BOOKSHELF",
        "BOW",
        "BOWL",
        "BREAD",
        "BREWING_STAND",
        "BREWING_STAND_ITEM",
        "BRICK",
        "BRICK_STAIRS",
        "BROWN_MUSHROOM",
        "BUCKET",
        "BURNING_FURNACE",
        "CACTUS",
        "CAKE",
        "CAKE_BLOCK",
        "CARROT",
        "CARROT_ITEM",
        "CARROT_STICK",
        "CAULDRON",
        "CAULDRON_ITEM",
        "CHAINMAIL_BOOTS",
        "CHAINMAIL_CHESTPLATE",
        "CHAINMAIL_HELMET",
        "CHAINMAIL_LEGGINGS",
        "CHEST",
        "CLAY",
        "CLAY_BALL",
        "CLAY_BRICK",
        "COAL",
        "COAL_ORE",
        "COBBLE_WALL",
        "COBBLESTONE",
        "COBBLESTONE_STAIRS",
        "COCOA",
        "COMMAND",
        "COMPASS",
        "COOKED_BEEF",
        "COOKED_CHICKEN",
        "COOKED_FISH",
        "COOKIE",
        "CROPS",
        "DEAD_BUSH",
        "DETECTOR_RAIL",
        "DIAMOND",
        "DIAMOND_AXE",
        "DIAMOND_BLOCK",
        "DIAMOND_BOOTS",
        "DIAMOND_CHESTPLATE",
        "DIAMOND_HELMET",
        "DIAMOND_HOE",
        "DIAMOND_LEGGINGS",
        "DIAMOND_ORE",
        "DIAMOND_PICKAXE",
        "DIAMOND_SPADE",
        "DIAMOND_SWORD",
        "DIODE",
        "DIODE_BLOCK_OFF",
        "DIODE_BLOCK_ON",
        "DIRT",
        "DISPENSER",
        "DOUBLE_STEP",
        "DRAGON_EGG",
        "EGG",
        "EMERALD",
        "EMERALD_BLOCK",
        "EMERALD_ORE",
        "EMPTY_MAP",
        "ENCHANTMENT_TABLE",
        "ENDER_CHEST",
        "ENDER_PEARL",
        "ENDER_PORTAL",
        "ENDER_PORTAL_FRAME",
        "ENDER_STONE",
        "EXP_BOTTLE",
        "EYE_OF_ENDER",
        "FEATHER",
        "FENCE",
        "FENCE_GATE",
        "FERMENTED_SPIDER_EYE",
        "FIRE",
        "FIREBALL",
        "FISHING_ROD",
        "FLINT",
        "FLINT_AND_STEEL",
        "FLOWER_POT",
        "FLOWER_POT_ITEM",
        "FURNACE",
        "GHAST_TEAR",
        "GLASS",
        "GLASS_BOTTLE",
        "GLOWING_REDSTONE_ORE",
        "GLOWSTONE",
        "GLOWSTONE_DUST",
        "GOLD_AXE",
        "GOLD_BLOCK",
        "GOLD_BOOTS",
        "GOLD_CHESTPLATE",
        "GOLD_HELMET",
        "GOLD_HOE",
        "GOLD_INGOT",
        "GOLD_LEGGINGS",
        "GOLD_NUGGET",
        "GOLD_ORE",
        "GOLD_PICKAXE",
        "GOLD_RECORD",
        "GOLD_SPADE",
        "GOLD_SWORD",
        "GOLDEN_APPLE",
        "GOLDEN_CARROT",
        "GRASS",
        "GRAVEL",
        "GREEN_RECORD",
        "GRILLED_PORK",
        "HUGE_MUSHROOM_1",
        "HUGE_MUSHROOM_2",
        "ICE",
        "INK_SACK",
        "IRON_AXE",
        "IRON_BLOCK",
        "IRON_BOOTS",
        "IRON_CHESTPLATE",
        "IRON_DOOR",
        "IRON_DOOR_BLOCK",
        "IRON_FENCE",
        "IRON_HELMET",
        "IRON_HOE",
        "IRON_INGOT",
        "IRON_LEGGINGS",
        "IRON_ORE",
        "IRON_PICKAXE",
        "IRON_SPADE",
        "IRON_SWORD",
        "ITEM_FRAME",
        "JACK_O_LANTERN",
        "JUKEBOX",
        "JUNGLE_WOOD_STAIRS",
        "LADDER",
        "LAPIS_BLOCK",
        "LAPIS_ORE",
        "LAVA",
        "LAVA_BUCKET",
        "LEATHER",
        "LEATHER_BOOTS",
        "LEATHER_CHESTPLATE",
        "LEATHER_HELMET",
        "LEATHER_LEGGINGS",
        "LEAVES",
        "LEVER",
        "LOCKED_CHEST",
        "LOG",
        "LONG_GRASS",
        "MAGMA_CREAM",
        "MAP",
        "MELON",
        "MELON_BLOCK",
        "MELON_SEEDS",
        "MELON_STEM",
        "MILK_BUCKET",
        "MINECART",
        "MOB_SPAWNER",
        "MONSTER_EGG",
        "MONSTER_EGGS",
        "MOSSY_COBBLESTONE",
        "MUSHROOM_SOUP",
        "MYCEL",
        "NETHER_BRICK",
        "NETHER_BRICK_STAIRS",
        "NETHER_FENCE",
        "NETHER_STALK",
        "NETHER_STAR",
        "NETHER_WARTS",
        "NETHERRACK",
        "NOTE_BLOCK",
        "OBSIDIAN",
        "PAINTING",
        "PAPER",
        "PISTON_BASE",
        "PISTON_EXTENSION",
        "PISTON_MOVING_PIECE",
        "PISTON_STICKY_BASE",
        "POISONOUS_POTATO",
        "PORK",
        "PORTAL",
        "POTATO",
        "POTATO_ITEM",
        "POTION",
        "POWERED_MINECART",
        "POWERED_RAIL",
        "PUMPKIN",
        "PUMPKIN_PIE",
        "PUMPKIN_SEEDS",
        "PUMPKIN_STEM",
        "RAILS",
        "RAW_BEEF",
        "RAW_CHICKEN",
        "RAW_FISH",
        "RECORD_10",
        "RECORD_11",
        "RECORD_3",
        "RECORD_4",
        "RECORD_5",
        "RECORD_6",
        "RECORD_7",
        "RECORD_8",
        "RECORD_9",
        "RED_MUSHROOM",
        "RED_ROSE",
        "REDSTONE",
        "REDSTONE_LAMP_OFF",
        "REDSTONE_LAMP_ON",
        "REDSTONE_ORE",
        "REDSTONE_TORCH_OFF",
        "REDSTONE_TORCH_ON",
        "REDSTONE_WIRE",
        "ROTTEN_FLESH",
        "SADDLE",
        "SAND",
        "SANDSTONE",
        "SANDSTONE_STAIRS",
        "SAPLING",
        "SEEDS",
        "SHEARS",
        "SIGN",
        "SIGN_POST",
        "SKULL",
        "SKULL_ITEM",
        "SLIME_BALL",
        "SMOOTH_BRICK",
        "SMOOTH_STAIRS",
        "SNOW",
        "SNOW_BALL",
        "SNOW_BLOCK",
        "SOIL",
        "SOUL_SAND",
        "SPECKLED_MELON",
        "SPIDER_EYE",
        "SPONGE",
        "SPRUCE_WOOD_STAIRS",
        "STATIONARY_LAVA",
        "STATIONARY_WATER",
        "STEP",
        "STICK",
        "STONE",
        "STONE_AXE",
        "STONE_BUTTON",
        "STONE_HOE",
        "STONE_PICKAXE",
        "STONE_PLATE",
        "STONE_SPADE",
        "STONE_SWORD",
        "STORAGE_MINECART",
        "STRING",
        "SUGAR",
        "SUGAR_CANE",
        "SUGAR_CANE_BLOCK",
        "SULPHUR",
        "THIN_GLASS",
        "TNT",
        "TORCH",
        "TRAP_DOOR",
        "TRIPWIRE",
        "TRIPWIRE_HOOK",
        "VINE",
        "WALL_SIGN",
        "WATCH",
        "WATER",
        "WATER_BUCKET",
        "WATER_LILY",
        "WEB",
        "WHEAT",
        "WOOD",
        "WOOD_AXE",
        "WOOD_BUTTON",
        "WOOD_DOOR",
        "WOOD_DOUBLE_STEP",
        "WOOD_HOE",
        "WOOD_PICKAXE",
        "WOOD_PLATE",
        "WOOD_SPADE",
        "WOOD_STAIRS",
        "WOOD_STEP",
        "WOOD_SWORD",
        "WOODEN_DOOR",
        "WOOL",
        "WORKBENCH",
        "WRITTEN_BOOK",
        "YELLOW_FLOWER"
    };
}