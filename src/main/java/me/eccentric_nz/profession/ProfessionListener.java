package me.eccentric_nz.profession;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
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
        Material material = player.getInventory().getItemInMainHand().getType();

        if (entity.getType().equals(EntityType.VILLAGER)) {
            if (player.hasPermission("profession.change")) {
                // check if the config setting for this world allows profession changing
                String world = player.getWorld().getName();
                boolean worldcheck = plugin.getConfig().getBoolean("worlds." + world);
                if (worldcheck == true) {
                    if (material == plugin.getFarm() || material == plugin.getButc() || material == plugin.getLibr() || material == plugin.getCart() || material == plugin.getCler() || material == plugin.getArmo() || material == plugin.getFish() || material == plugin.getFlet() || material == plugin.getLeat() || material == plugin.getNitw() || material == plugin.getShep() || material == plugin.getTool() || material == plugin.getWeap() || material == plugin.getZomb()) {
                        Villager.Profession profession = Villager.Profession.FARMER;
                        Villager.Career career = Villager.Career.FARMER;
                        ChatColor colour = ChatColor.RESET;
                        Villager villager = (Villager) entity;

                        if (material == plugin.getFarm()) {
                            profession = Villager.Profession.FARMER;
                            career = Villager.Career.FARMER;
                            colour = ChatColor.YELLOW;
                        }
                        if (material == plugin.getFish()) {
                            profession = Villager.Profession.FARMER;
                            career = Villager.Career.FISHERMAN;
                            colour = ChatColor.YELLOW;
                        }
                        if (material == plugin.getFlet()) {
                            profession = Villager.Profession.FARMER;
                            career = Villager.Career.FLETCHER;
                            colour = ChatColor.YELLOW;
                        }
                        if (material == plugin.getShep()) {
                            profession = Villager.Profession.FARMER;
                            career = Villager.Career.SHEPHERD;
                            colour = ChatColor.YELLOW;
                        }
                        if (material == plugin.getLibr()) {
                            profession = Villager.Profession.LIBRARIAN;
                            career = Villager.Career.LIBRARIAN;
                            colour = ChatColor.BLUE;
                        }
                        if (material == plugin.getCart()) {
                            profession = Villager.Profession.LIBRARIAN;
                            career = Villager.Career.CARTOGRAPHER;
                            colour = ChatColor.BLUE;
                        }
                        if (material == plugin.getArmo()) {
                            profession = Villager.Profession.BLACKSMITH;
                            career = Villager.Career.ARMORER;
                            colour = ChatColor.GRAY;
                        }
                        if (material == plugin.getTool()) {
                            profession = Villager.Profession.BLACKSMITH;
                            career = Villager.Career.TOOL_SMITH;
                            colour = ChatColor.GRAY;
                        }
                        if (material == plugin.getWeap()) {
                            profession = Villager.Profession.BLACKSMITH;
                            career = Villager.Career.WEAPON_SMITH;
                            colour = ChatColor.GRAY;
                        }
                        if (material == plugin.getButc()) {
                            profession = Villager.Profession.BUTCHER;
                            career = Villager.Career.BUTCHER;
                            colour = ChatColor.RED;
                        }
                        if (material == plugin.getLeat()) {
                            profession = Villager.Profession.BUTCHER;
                            career = Villager.Career.LEATHERWORKER;
                            colour = ChatColor.RED;
                        }
                        if (material == plugin.getCler()) {
                            profession = Villager.Profession.PRIEST;
                            career = Villager.Career.CLERIC;
                            colour = ChatColor.DARK_RED;
                        }
                        if (material == plugin.getNitw()) {
                            profession = Villager.Profession.NITWIT;
                            career = Villager.Career.NITWIT;
                            colour = ChatColor.GREEN;
                        }
                        String message;
                        if (material == plugin.getZomb() && player.hasPermission("profession.zombie")) {
                            Villager.Profession vprofession = villager.getProfession();
                            boolean adult = villager.isAdult();
//                            career = villager.getCareer();
                            villager.remove();
                            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                Location loc = villager.getLocation();
                                ZombieVillager zombie = (ZombieVillager) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE_VILLAGER);
                                zombie.setVillagerProfession(vprofession);
                                zombie.setBaby(!adult);
                            }, 2L);
                            message = "ZOMBIE VILLAGER";
                            colour = ChatColor.DARK_PURPLE;
                        } else {
                            message = career.toString();
                            villager.setProfession(profession);
                            villager.setCareer(career);
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
                        if (!(plugin.getServer().getPluginManager().getPlugin("Secretary") != null && (material.equals(Material.FEATHER) || material.equals(Material.INK_SAC) || material.equals(Material.PAPER))) && plugin.getConfig().getBoolean("message")) {
                            player.sendMessage(Constants.NO_MATS_MESSAGE);
                        }
                    }
                } else {
                    if (plugin.getConfig().getBoolean("message")) {
                        player.sendMessage(Constants.pna(world).get(plugin.getLanguage()));
                    }
                }
            } else {
                if (plugin.getConfig().getBoolean("message")) {
                    player.sendMessage(Constants.npm().get(plugin.getLanguage()));
                }
            }
        }
    }
}
