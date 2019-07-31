package me.eccentric_nz.profession;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Profession extends JavaPlugin implements Listener {

    private Material farm;
    private Material fish;
    private Material shep;
    private Material flet;
    private Material libr;
    private Material cart;
    private Material cler;
    private Material armo;
    private Material weap;
    private Material tool;
    private Material butc;
    private Material leat;
    private Material maso;
    private Material nitw;
    private Material zomb;
    private String language;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadMaterials();
        getServer().getPluginManager().registerEvents(new ProfessionListener(this), this);
        getCommand("setprof").setExecutor(new ProfessionSetExecutor(this));
        getCommand("worldprof").setExecutor(new ProfessionWorldExecutor(this));
        ProfessionConsumeExecutor professionConsumeExecutor = new ProfessionConsumeExecutor(this);
        getCommand("consumeprof").setExecutor(professionConsumeExecutor);
        getCommand("messageprof").setExecutor(professionConsumeExecutor);
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void loadMaterials() {
        // read the material values
        try {
            farm = Material.valueOf(getConfig().getString("farmer_material", "WHEAT"));
            fish = Material.valueOf(getConfig().getString("fisherman_material", "COD"));
            shep = Material.valueOf(getConfig().getString("shepard_material", "WHITE_WOOL"));
            flet = Material.valueOf(getConfig().getString("fletcher_material", "ARROW"));
            libr = Material.valueOf(getConfig().getString("librarian_material", "BOOK"));
            cart = Material.valueOf(getConfig().getString("cartographer_material", "FILLED_MAP"));
            cler = Material.valueOf(getConfig().getString("cleric_material", "REDSTONE"));
            armo = Material.valueOf(getConfig().getString("armorer_material", "GOLD_INGOT"));
            weap = Material.valueOf(getConfig().getString("weapon_smith_material", "IRON_INGOT"));
            tool = Material.valueOf(getConfig().getString("tool_smith__material", "STICK"));
            butc = Material.valueOf(getConfig().getString("butcher_material", "BEEF"));
            leat = Material.valueOf(getConfig().getString("leatherworker_material", "LEATHER"));
            maso = Material.valueOf(getConfig().getString("mason_material", "STONE"));
            nitw = Material.valueOf(getConfig().getString("nitwit_material", "RED_MUSHROOM"));
            zomb = Material.valueOf(getConfig().getString("zombie_material", "ROTTEN_FLESH"));
        } catch (IllegalArgumentException ignore) {
        }

        // read the language value
        language = getConfig().getString("lang");
        if (!getConfig().contains("message")) {
            getConfig().set("message", true);
            saveConfig();
        }

        Constants.NO_MATS_MESSAGE = Constants.nms().get(language) + ChatColor.YELLOW + farm.toString() + " -> FARMER\n" + ChatColor.YELLOW + fish.toString() + " -> FISHERMAN\n" + ChatColor.YELLOW + shep.toString() + " -> SHEPHERD\n" + ChatColor.YELLOW + flet.toString() + " -> FLETCHER\n" + ChatColor.RED + butc.toString() + " -> BUTCHER\n" + ChatColor.RED + leat.toString() + " -> LEATHERWORKER\n" + ChatColor.BLUE + libr.toString() + " -> LIBRARIAN\n" + ChatColor.BLUE + cart.toString() + " -> CARTOGRAPHER\n" + ChatColor.GRAY + armo.toString() + " -> ARMORER\n" + ChatColor.GRAY + weap.toString() + " -> WEAPON_SMITH\n" + ChatColor.GRAY + tool.toString() + " -> TOOL_SMITH\n" + ChatColor.GRAY + maso.toString() + "  -> MASON\n" + ChatColor.DARK_RED + cler + " -> CLERIC\n" + ChatColor.DARK_GREEN + nitw.toString() + " -> NITWIT\n" + ChatColor.DARK_PURPLE + zomb.toString() + " -> ZOMBIE_VILLAGER";
    }

    public Material getFarm() {
        return farm;
    }

    public Material getFish() {
        return fish;
    }

    public Material getShep() {
        return shep;
    }

    public Material getFlet() {
        return flet;
    }

    public Material getLibr() {
        return libr;
    }

    public Material getCart() {
        return cart;
    }

    public Material getCler() {
        return cler;
    }

    public Material getArmo() {
        return armo;
    }

    public Material getWeap() {
        return weap;
    }

    public Material getTool() {
        return tool;
    }

    public Material getMaso() {
        return maso;
    }

    public Material getButc() {
        return butc;
    }

    public Material getLeat() {
        return leat;
    }

    public Material getNitw() {
        return nitw;
    }

    public Material getZomb() {
        return zomb;
    }

    public String getLanguage() {
        return language;
    }
}
