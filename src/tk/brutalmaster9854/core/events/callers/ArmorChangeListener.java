package tk.brutalmaster9854.core.events.callers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.events.PlayerEquipArmorEvent;
import tk.brutalmaster9854.core.events.PlayerUnEquipArmorEvent;

import java.util.HashMap;
import java.util.UUID;

public class ArmorChangeListener implements Listener {

    private final HashMap<UUID, ItemStack[]> contents = new HashMap<>();

    public ArmorChangeListener() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            UUID uuid = pl.getUniqueId();

            this.contents.put(uuid, pl.getEquipment().getArmorContents());
        }
    }

    @EventHandler
    public final void onEvent(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Inventory inventory = event.getClickedInventory();
        if ((inventory != null) &&
                ((inventory.getType() == InventoryType.CRAFTING) || (inventory.getType() == InventoryType.PLAYER)) && (
                (event.getSlotType() == InventoryType.SlotType.ARMOR) || (event.isShiftClick()))) {
            check((Player)event.getWhoClicked());
        }
    }

    @EventHandler
    public final void onEvent(PlayerInteractEvent event) {
        Action action = event.getAction();
        if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)) {
            ItemStack item = event.getItem();
            if (item == null) {
                return;
            }
            String name = item.getType().name();
            if ((name.contains("_HELMET")) || (name.contains("_CHESTPLATE")) || (name.contains("_LEGGINGS")) ||
                    (name.contains("_BOOTS"))) {
                check(event.getPlayer());
            }
        }
    }

    @EventHandler
    public final void onEvent(PlayerDeathEvent event) {
        check(event.getEntity());
    }
    @EventHandler
    public final void onEvent(PlayerJoinEvent event) {
        check(event.getPlayer());
    }

    @EventHandler
    public final void onEvent(PlayerQuitEvent event) {
        if (getContents().containsKey(event.getPlayer().getUniqueId())) {
            getContents().remove(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public final void onEvent(BlockDispenseEvent event) {
        ItemStack item = event.getItem();
        Location location = event.getBlock().getLocation();
        if (item != null) {
            for (Entity e : location.getWorld().getNearbyEntities(location, 6.0D, 6.0D, 6.0D)) {
                if ((e instanceof Player)) {
                    check((Player)e);
                }
            }
        }
    }

    @EventHandler
    public final void onEvent(PlayerItemBreakEvent event) {
        check(event.getPlayer());
    }

    private void check(final Player player) {
        new BukkitRunnable() {
            public void run() {
                ItemStack[] now = player.getEquipment().getArmorContents();
                ItemStack[] saved = (ItemStack[])ArmorChangeListener.this.getContents().get(player.getUniqueId());
                for (int i = 0; i < now.length; i++) {
                    try {
                        if ((now[i] == null) && (saved != null) && (saved[i] != null)) {
                            Bukkit.getPluginManager().callEvent(new PlayerEquipArmorEvent(player, saved[i]));
                        }
                        else if ((now[i] != null) && ((saved == null) || (saved[i] == null))) {
                            Bukkit.getPluginManager().callEvent(new PlayerEquipArmorEvent(player, now[i]));
                        }
                        else if ((saved != null) && (!now[i].toString().equalsIgnoreCase(saved[i].toString()))) {
                            Bukkit.getPluginManager().callEvent(new PlayerUnEquipArmorEvent(player, saved[i]));
                            Bukkit.getPluginManager().callEvent(new PlayerUnEquipArmorEvent(player, now[i]));
                        }
                    }
                    catch (Exception localException) {}
                }
                ArmorChangeListener.this.getContents().put(player.getUniqueId(), now);
            }
        }.runTaskLater(BrutalCore.get(), 1L);
    }
    public HashMap<UUID, ItemStack[]> getContents() {
        return this.contents;
    }
}
