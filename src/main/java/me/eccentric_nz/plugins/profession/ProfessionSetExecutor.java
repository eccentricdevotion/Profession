package me.eccentric_nz.plugins.profession;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Villager;

public class ProfessionSetExecutor implements CommandExecutor {

    private final Profession plugin;

    public ProfessionSetExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("setprof")) {
            if (args.length > 2) {
                sender.sendMessage(ChatColor.RED + Constants.tma().get(plugin.getLanguage()));
                return false;
            }
            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED + Constants.tfa().get(plugin.getLanguage()));
                return false;
            }
            String villagerType = args[0].toUpperCase();
            // check they typed a valid villager type
            Villager.Profession v = null;
            try {
                v = Villager.Profession.valueOf(villagerType);
            } catch (IllegalArgumentException e) {
                if (!villagerType.equals("ZOMBIE")) {
                    sender.sendMessage(ChatColor.RED + Constants.nvv().get(plugin.getLanguage()) + " farmer | librarian | butcher | blacksmith | priest | zombie");
                    return false;
                }
            }
            // check they typed a valid material
            String setMaterial = args[1].toUpperCase();
            try {
                Material.valueOf(setMaterial);
            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + Constants.nvm().get(plugin.getLanguage()));
                return false;
            }
            // check the villager type
            if (v != null && !villagerType.equals("ZOMBIE")) {
                switch (v) {
                    case FARMER:
                        // set the config value
                        plugin.getConfig().set("farmer_material", setMaterial);
                        break;
                    case BUTCHER:
                        // set the config value
                        plugin.getConfig().set("butcher_material", setMaterial);
                        break;
                    case LIBRARIAN:
                        // set the config value
                        plugin.getConfig().set("librarian_material", setMaterial);
                        break;
                    case BLACKSMITH:
                        // set the config value
                        plugin.getConfig().set("smith_material", setMaterial);
                        break;
                    default:
                        // set the config value
                        plugin.getConfig().set("priest_material", setMaterial);
                        break;
                }
            } else {
                plugin.getConfig().set("zombie_material", setMaterial);
            }
            plugin.saveConfig();
            plugin.loadMaterials();
            sender.sendMessage(Constants.vms(villagerType, setMaterial).get(plugin.getLanguage()));
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}
