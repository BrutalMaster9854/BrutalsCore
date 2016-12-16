package tk.brutalmaster9854.core.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private Plugin plugin;
    private FileConfiguration config;
    private File file;

    public Config(Plugin plugin, String name) {

        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), name);
        config = YamlConfiguration.loadConfiguration(file);
    }
    public FileConfiguration get() {
        return config;
    }
    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
    public void save() throws IOException {
        config.save(file);
    }
}
