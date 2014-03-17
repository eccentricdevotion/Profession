/*
 *  Copyright 2014 eccentric_nz.
 */
package me.eccentric_nz.plugins.profession;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author eccentric_nz
 */
public class ProfessionConfiguration {

    private final Profession plugin;
    private FileConfiguration config = null;
    private File configFile = null;

    public ProfessionConfiguration(Profession plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void checkConfig() {
        if (!config.contains("zombie_material")) {
            plugin.getConfig().set("zombie_material", "ROTTEN_FLESH");
            plugin.saveConfig();
        }
    }
}
