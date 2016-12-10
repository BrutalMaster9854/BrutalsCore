package tk.brutalmaster9854.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import tk.brutalmaster9854.core.bungeecord.ServerConnector;
import tk.brutalmaster9854.core.entity.MetaDataManager;
import tk.brutalmaster9854.core.packet.actionbar.PacketActionbar;
import tk.brutalmaster9854.core.packet.tablist.PacketTabList;
import tk.brutalmaster9854.core.packet.title.PacketTitle;
import tk.brutalmaster9854.core.stats.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;

public class BrutalCore extends JavaPlugin {

    private static BrutalCore instance;
    private ServerConnector serverConnector;
    private MetaDataManager metaDataManager;
    private PacketTitle packetTitle;
    private PacketActionbar packetActionbar;
    private PacketTabList packetTabList;

    @Override
    public void onEnable() {

        instance = this;
        serverConnector = new ServerConnector();
        metaDataManager = new MetaDataManager();
        packetTitle = new PacketTitle();
        packetActionbar = new PacketActionbar();
        packetTabList = new PacketTabList();

        Metrics metrics = new Metrics(this);
    }
    @Override
    public void onDisable() {

    }
    public static BrutalCore get() {
        return instance;
    }
    public String toColor(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public void registerListeners(Plugin plugin, Listener... l) {
        Arrays.stream(l).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, plugin));
    }
    public ServerConnector getServerConnector() {
        return serverConnector;
    }
    public MetaDataManager getMetaDataManager() {
        return metaDataManager;
    }
    public PacketTitle getPacketTitle() {
        return packetTitle;
    }
    public PacketActionbar getPacketActionbar() {
        return packetActionbar;
    }
    public PacketTabList getPacketTabList() {
        return packetTabList;
    }
}
