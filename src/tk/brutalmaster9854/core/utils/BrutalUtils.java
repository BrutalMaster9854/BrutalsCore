package tk.brutalmaster9854.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.builders.InventoryBuilder;
import tk.brutalmaster9854.core.builders.ItemBuilder;
import tk.brutalmaster9854.core.stats.Metrics;
import tk.brutalmaster9854.core.updater.Updater;

import java.util.HashMap;
import java.util.Map;

public class BrutalUtils {

    public static void printConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(BrutalCore.get().toColor(message));
    }

    public static boolean isPlayer(Object object) {
        return object instanceof Player;
    }

    public static void sendTitle(Player player, String title, String subtitle, int fadein, int stay, int fadeout) {
        BrutalCore.get().getPacketTitle().sendTitle(player, title, subtitle, fadein, stay, fadeout);
    }

    public static void sendActionbar(Player player, String msg) {
        BrutalCore.get().getPacketActionbar().sendActionBar(player, msg);
    }

    public static void sendTabList(Player player, String header, String footer) {
        BrutalCore.get().getPacketTabList().sendTabTitle(player, header, footer);
    }

    public static ItemStack createItem(Material material) {
        return new ItemBuilder(material).build();
    }

    public static ItemStack createItem(Material material, String name) {
        return new ItemBuilder(material).setName(name).build();
    }

    public static ItemStack createItem(Material material, String... lore) {
        return new ItemBuilder(material).addLore(lore).build();
    }

    public static ItemStack createItem(Material material, String name, String... lore) {
        return new ItemBuilder(material).setName(name).addLore(lore).build();
    }

    public static Inventory createInventory(int size, ItemStack... items) {
        return new InventoryBuilder(size).addItem(items).build();
    }

    public static Inventory createInventory(int size, String title, ItemStack... items) {
        return new InventoryBuilder(size, title).addItem(items).build();
    }

    public static Inventory createInventory(int size, String title, HashMap<ItemStack, Integer> items) {
        InventoryBuilder builder = new InventoryBuilder(size, title);
        for(Map.Entry<ItemStack, Integer> itemStackIntegerEntry : items.entrySet()) {
            builder.setItem(itemStackIntegerEntry.getKey(), itemStackIntegerEntry.getValue());
        }
        return builder.build();
    }

    public static void setMetaData(Entity entity, String data) {
        BrutalCore.get().getMetaDataManager().setData(entity, data);
    }

    public static boolean hasMetaData(Entity entity, String data) {
        return BrutalCore.get().getMetaDataManager().hasData(entity, data);
    }

    public static void removeMetaData(Entity entity, String data) {
        BrutalCore.get().getMetaDataManager().removeData(entity, data);
    }

    public static void connectPlayer(Player player, String server) {
        BrutalCore.get().getServerConnector().connect(player, server);
    }

    public static Updater createUpdater(JavaPlugin plugin, int resource) {
        return new Updater(plugin, String.valueOf(resource));
    }

    public static Metrics createMetrics(JavaPlugin plugin) {
        return new Metrics(plugin);
    }
}
