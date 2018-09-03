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
        getCommand("consumeprof").setExecutor(new ProfessionConsumeExecutor(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void loadMaterials() {
        // read the material values
        try {
            farm = Material.getMaterial(getConfig().getString("farmer_material"));
            fish = Material.getMaterial(getConfig().getString("fisherman_material"));
            shep = Material.getMaterial(getConfig().getString("shepard_material"));
            flet = Material.getMaterial(getConfig().getString("fletcher_material"));
            libr = Material.getMaterial(getConfig().getString("librarian_material"));
            cart = Material.getMaterial(getConfig().getString("cartographer_material"));
            cler = Material.getMaterial(getConfig().getString("cleric_material"));
            armo = Material.getMaterial(getConfig().getString("armorer_material"));
            weap = Material.getMaterial(getConfig().getString("weapon_smith_material"));
            tool = Material.getMaterial(getConfig().getString("tool_smith__material"));
            butc = Material.getMaterial(getConfig().getString("butcher_material"));
            leat = Material.getMaterial(getConfig().getString("leatherworker_material"));
            nitw = Material.getMaterial(getConfig().getString("nitwit_material"));
            zomb = Material.getMaterial(getConfig().getString("zombie_material"));
        } catch (IllegalArgumentException ignore) {
        }

        // read the language value
        language = getConfig().getString("lang");

        Constants.NO_MATS_MESSAGE = Constants.nms().get(language) + ChatColor.YELLOW + farm.toString() + " -> FARMER\n" + ChatColor.YELLOW + fish.toString() + " -> FISHERMAN\n" + ChatColor.YELLOW + shep.toString() + " -> SHEPHERD\n" + ChatColor.YELLOW + flet.toString() + " -> FLETCHER\n" + ChatColor.RED + butc.toString() + " -> BUTCHER\n" + ChatColor.RED + leat.toString() + " -> LEATHERWORKER\n" + ChatColor.BLUE + libr.toString() + " -> LIBRARIAN\n" + ChatColor.BLUE + cart.toString() + " -> CARTOGRAPHER\n" + ChatColor.GRAY + armo.toString() + " -> ARMORER\n" + ChatColor.GRAY + weap.toString() + " -> WEAPON_SMITH\n" + ChatColor.GRAY + tool.toString() + " -> TOOL_SMITH\n" + ChatColor.DARK_RED + cler + " -> CLERIC\n" + ChatColor.DARK_GREEN + nitw.toString() + " -> NITWIT\n" + ChatColor.DARK_PURPLE + zomb.toString() + " -> ZOMBIE_VILLAGER";
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
