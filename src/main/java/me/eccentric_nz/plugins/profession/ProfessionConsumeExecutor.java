package me.eccentric_nz.plugins.profession;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ProfessionConsumeExecutor implements CommandExecutor {

    private final Profession plugin;

    public ProfessionConsumeExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("consumeprof")) {
            if (args.length > 1) {
                sender.sendMessage(ChatColor.RED + Constants.tma().get(plugin.getLanguage()));
                return false;
            }
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + Constants.tfa().get(plugin.getLanguage()));
                return false;
            }
            // check they typed true of false
            String consume = args[0].toLowerCase();
            if (!consume.equals("true") && !consume.equals("false")) {
                sender.sendMessage(ChatColor.RED + Constants.ntf().get(plugin.getLanguage()));
                return false;
            }
            // set the config value
            plugin.getConfig().set("consume", Boolean.valueOf(consume));
            plugin.saveConfig();
            plugin.loadMaterials();
            String css = (consume.equals("false")) ? Constants.cds().get(plugin.getLanguage()) : Constants.cen().get(plugin.getLanguage());
            sender.sendMessage(css);
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}
