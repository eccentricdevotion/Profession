package me.eccentric_nz.plugins.profession;

import java.util.HashMap;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ProfessionWorldExecutor extends JavaPlugin implements CommandExecutor {

    private Profession plugin;
    private World worldName;
    private String profActive;
    private HashMap tma_hm;
    private HashMap tfa_hm;
    private HashMap wnf_hm;
    private HashMap ntf_hm;
    private HashMap vms_hm;
    private HashMap wss_hm;
    private List<World> worlds;

    public ProfessionWorldExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("worldprof")) {
            if (args.length > 2) {
                tma_hm = Constants.tma();
                String tma = (String) tma_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + tma);
                return false;
            }
            if (args.length < 2) {
                tfa_hm = Constants.tfa();
                String tfa = (String) tfa_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + tfa);
                return false;
            }
            worldName = plugin.getServer().getWorld(args[0]);
            //worlds = plugin.getServer().getWorlds();

            // check they typed a valid world
            if (plugin.getServer().getWorld(args[0]) == null) {
                wnf_hm = Constants.wnf();
                String wnf = (String) wnf_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + wnf);
                return false;
            }
            // check they typed true of false
            profActive = args[1].toLowerCase();

            if (!profActive.equals("true") && !profActive.equals("false")) {
                ntf_hm = Constants.ntf();
                String ntf = (String) ntf_hm.get(Constants.LANGUAGE);

                sender.sendMessage(ChatColor.RED + ntf);
                return false;
            }
            // set the config value
            plugin.config.set("worlds." + worldName.getName(), Boolean.valueOf(profActive));
            plugin.saveCustomConfig();
            plugin.loadConfig();
            wss_hm = (profActive.equals("false")) ? Constants.wds(args[0]) : Constants.wes(args[0]);
            String wss = (String) wss_hm.get(Constants.LANGUAGE);
            sender.sendMessage(wss);
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}