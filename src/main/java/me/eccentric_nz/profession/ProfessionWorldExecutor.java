package me.eccentric_nz.profession;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ProfessionWorldExecutor implements CommandExecutor {

    private final Profession plugin;

    public ProfessionWorldExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("worldprof")) {
            if (args.length > 2) {
                sender.sendMessage(ChatColor.RED + Constants.tma().get(plugin.getLanguage()));
                return false;
            }
            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED + Constants.tfa().get(plugin.getLanguage()));
                return false;
            }
            World worldName = plugin.getServer().getWorld(args[0]);
            // check they typed a valid world
            if (worldName == null) {
                sender.sendMessage(ChatColor.RED + Constants.wnf().get(plugin.getLanguage()));
                return false;
            }
            // check they typed true of false
            String profActive = args[1].toLowerCase();
            if (!profActive.equals("true") && !profActive.equals("false")) {
                sender.sendMessage(ChatColor.RED + Constants.ntf().get(plugin.getLanguage()));
                return false;
            }
            // set the config value
            plugin.getConfig().set("worlds." + worldName.getName(), Boolean.valueOf(profActive));
            plugin.saveConfig();
            plugin.loadMaterials();
            String wss = (profActive.equals("false")) ? Constants.wds(args[0]).get(plugin.getLanguage()) : Constants.wes(args[0]).get(plugin.getLanguage());
            sender.sendMessage(wss);
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}
