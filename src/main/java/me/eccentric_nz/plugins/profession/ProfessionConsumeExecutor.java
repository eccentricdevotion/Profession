package me.eccentric_nz.plugins.profession;

import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ProfessionConsumeExecutor extends JavaPlugin implements CommandExecutor {

    private Profession plugin;
    private String consume;
    private static Logger log;
    private HashMap tma_hm;
    private HashMap tfa_hm;
    private HashMap ntf_hm;
    private HashMap css_hm;

    public ProfessionConsumeExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("consumeprof")) {
            if (args.length > 1) {
                tma_hm = Constants.tma();
                String tma = (String) tma_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + tma);
                return false;
            }
            if (args.length < 1) {
                tfa_hm = Constants.tfa();
                String tfa = (String) tfa_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + tfa);
                return false;
            }

            // check they typed true of false
            consume = args[0].toLowerCase();

            if (!consume.equals("true") && !consume.equals("false")) {
                ntf_hm = Constants.ntf();
                String ntf = (String) ntf_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + ntf);
                return false;
            }
            // set the config value
            plugin.config.set("consume",Boolean.valueOf(consume));

            plugin.saveCustomConfig();
            plugin.loadConfig();
            css_hm =  (consume.equals("false")) ? Constants.cds() : Constants.cen();
            String css = (String) css_hm.get(Constants.LANGUAGE);
            sender.sendMessage(css);
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}