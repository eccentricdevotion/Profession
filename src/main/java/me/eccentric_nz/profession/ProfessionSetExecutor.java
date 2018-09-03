package me.eccentric_nz.profession;

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
            if (!villagerType.equals("ZOMBIE")) {
                // check they typed a valid villager career
                try {
                    Villager.Career c = Villager.Career.valueOf(villagerType);
                } catch (IllegalArgumentException e) {
                    sender.sendMessage(ChatColor.RED + Constants.nvv().get(plugin.getLanguage()) + " farmer | fisherman | shepard | librarian | cartographer | cleric | armorer | weapon_smith | tool_smith | butcher | leatherworker | nitwit | zombie");
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
            // set the config
            plugin.getConfig().set(villagerType.toLowerCase() + "_material", setMaterial);
            plugin.saveConfig();
            plugin.loadMaterials();
            sender.sendMessage(Constants.vms(villagerType, setMaterial).get(plugin.getLanguage()));
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}
