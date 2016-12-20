package tk.brutalmaster9854.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tk.brutalmaster9854.core.bungeecord.ServerConnector;
import tk.brutalmaster9854.core.entity.MetaDataManager;
import tk.brutalmaster9854.core.example.Example;
import tk.brutalmaster9854.core.packet.actionbar.PacketActionbar;
import tk.brutalmaster9854.core.packet.tablist.PacketTabList;
import tk.brutalmaster9854.core.packet.title.PacketTitle;
import tk.brutalmaster9854.core.placeholders.PlaceHolderAPI;
import tk.brutalmaster9854.core.stats.Metrics;
import tk.brutalmaster9854.core.updater.Updater;

import java.util.Arrays;

public class BrutalCore extends JavaPlugin {

    private static BrutalCore instance;
    private ServerConnector serverConnector;
    private MetaDataManager metaDataManager;
    private PacketTitle packetTitle;
    private PacketActionbar packetActionbar;
    private PacketTabList packetTabList;
    private PlaceHolderAPI placeHolderAPI;

    @Override
    public void onEnable() {

        instance = this;
        serverConnector = new ServerConnector();
        metaDataManager = new MetaDataManager();
        packetTitle = new PacketTitle();
        packetActionbar = new PacketActionbar();
        packetTabList = new PacketTabList();
        placeHolderAPI = new PlaceHolderAPI();

        System.out.println();

        registerListeners(this, new Example());

        getServer().getScheduler().runTaskAsynchronously(this, new Runnable() {
            @Override
            public void run() {

                Metrics metrics = new Metrics(BrutalCore.get());

                Updater updater = new Updater(BrutalCore.get(), "29715");
                Updater.UpdateResults result = updater.checkForUpdates();

                switch(result.getResult()) {

                    case UPDATE_AVAILABLE:
                        getLogger().info("An update has been found please update https://www.spigotmc.org/resources/brutalcore.29715/");
                        break;
                    case DISABLED:
                        getLogger().info("The updater is disabled to enable please enable in the config");
                        break;
                    case NO_UPDATE:
                        getLogger().info("No update has been found");
                        break;
                    default:
                        getLogger().info("An error has occured with the updater please try again later!");
                }
            }
        });
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

    public PlaceHolderAPI getPlaceHolderAPI() {
        return placeHolderAPI;
    }
}