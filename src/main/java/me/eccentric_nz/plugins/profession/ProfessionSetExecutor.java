package me.eccentric_nz.plugins.profession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;

public class ProfessionSetExecutor extends JavaPlugin implements CommandExecutor {

    private Profession plugin;
    private String villagerType;
    private String setMaterial;
    private static Logger log;
    private Villager.Profession v;
    private HashMap tma_hm;
    private HashMap tfa_hm;
    private HashMap nvv_hm;
    private HashMap nvm_hm;
    private HashMap vms_hm;

    public ProfessionSetExecutor(Profession plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /setprof then do the following...
        // check there is the right number of arguments
        if (cmd.getName().equalsIgnoreCase("setprof")) {
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
				villagerType = args[0].toUpperCase();

				// check they typed a valid villager type
				if (!Arrays.asList(Constants.V_TYPES).contains(villagerType)) {
                nvv_hm = Constants.nvv();
                String nvv = (String) nvv_hm.get(Constants.LANGUAGE);
                sender.sendMessage(ChatColor.RED + nvv +" farmer | librarian | butcher | blacksmith | priest");
                return false;
            }
            // check they typed a valid material
            setMaterial = args[1].toUpperCase();
            if (!Arrays.asList(Constants.MATERIAL_LIST).contains(setMaterial)) {
                nvm_hm = Constants.nvm();
                String nvm = (String) nvm_hm.get(Constants.LANGUAGE);

                sender.sendMessage(ChatColor.RED + nvm);
                return false;
            }

            // check the villager type
            v = Villager.Profession.valueOf(villagerType);
            switch (v) {
                case FARMER:
                   // set the config value
                   plugin.config.set("farmer_material", setMaterial);
                   break;
                case BUTCHER:
                   // set the config value
                   plugin.config.set("butcher_material", setMaterial);
                   break;
                case LIBRARIAN:
                   // set the config value
                   plugin.config.set("librarian_material", setMaterial);
                   break;
                case BLACKSMITH:
                   // set the config value
                   plugin.config.set("smith_material", setMaterial);
                   break;
                case PRIEST:
                   // set the config value
                   plugin.config.set("priest_material", setMaterial);
                   break;
            }
            plugin.saveCustomConfig();
            plugin.loadConfig();
            vms_hm = Constants.vms(villagerType, setMaterial);
            String vms = (String) vms_hm.get(Constants.LANGUAGE);
            sender.sendMessage(vms);
            return true;
        }
        // If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
        return false;
    }
}