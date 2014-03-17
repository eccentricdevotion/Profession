package me.eccentric_nz.plugins.profession;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ProfessionListener implements Listener {

    private final Profession plugin;

    public ProfessionListener(Profession plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        // get player
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        Material material = player.getItemInHand().getType();

        if (entity.getType().equals(EntityType.VILLAGER)) {
            if (player.hasPermission("profession.change")) {

                // check if the config setting for this world allows profession changing
                String world = player.getWorld().getName();
                boolean worldcheck = plugin.getConfig().getBoolean("worlds." + world);
                if (worldcheck == true) {
                    if (material == plugin.getF() || material == plugin.getB() || material == plugin.getL() || material == plugin.getS() || material == plugin.getP() || material == plugin.getZ()) {
                        Villager.Profession profession = Villager.Profession.FARMER;
                        ChatColor colour = ChatColor.RESET;
                        Villager villager = (Villager) entity;

                        if (material == plugin.getF()) {
                            profession = Villager.Profession.FARMER;
                            colour = ChatColor.YELLOW;
                        }
                        if (material == plugin.getL()) {
                            profession = Villager.Profession.LIBRARIAN;
                            colour = ChatColor.BLUE;
                        }
                        if (material == plugin.getS()) {
                            profession = Villager.Profession.BLACKSMITH;
                            colour = ChatColor.GRAY;
                        }
                        if (material == plugin.getB()) {
                            profession = Villager.Profession.BUTCHER;
                            colour = ChatColor.RED;
                        }
                        if (material == plugin.getP()) {
                            profession = Villager.Profession.PRIEST;
                            colour = ChatColor.DARK_RED;
                        }
                        String message = profession.toString();
                        if (material == plugin.getZ() && player.hasPermission("profession.zombie")) {
                            message = "ZOMBIE VILLAGER";
                            Location loc = villager.getLocation();
                            villager.remove();
                            Zombie zombie = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                            zombie.setVillager(true);
                            colour = ChatColor.DARK_GREEN;
                        } else {
                            villager.setProfession(profession);
                        }
                        player.sendMessage(Constants.ssm(colour, message).get(plugin.getLanguage()));

                        // should the material be used up?
                        if (plugin.getConfig().getBoolean("consume")) {
                            int a = player.getInventory().getItemInHand().getAmount();
                            int a2 = new Integer(a - 1);
                            if (a2 > 0) {
                                player.getInventory().getItemInHand().setAmount(a2);
                            } else {
                                player.getInventory().removeItem(new ItemStack(material, 1));
                            }
                        }
                        event.setCancelled(true);
                    } else {
                        if (!(plugin.getServer().getPluginManager().getPlugin("Secretary") != null && (material.equals(Material.FEATHER) || material.equals(Material.INK_SACK) || material.equals(Material.PAPER)))) {
                            player.sendMessage(Constants.NO_MATS_MESSAGE);
                        }
                    }
                } else {
                    player.sendMessage(Constants.pna(world).get(plugin.getLanguage()));
                }
            } else {
                player.sendMessage(Constants.npm().get(plugin.getLanguage()));
            }
        }
    }
}
