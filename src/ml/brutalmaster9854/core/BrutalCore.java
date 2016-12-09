package ml.brutalmaster9854.core;

import ml.brutalmaster9854.core.stats.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class BrutalCore extends JavaPlugin {

    private static BrutalCore instance;

    @Override
    public void onEnable() {

        instance = this;

        Metrics metrics = new Metrics(this);
    }
    @Override
    public void onDisable() {

    }
    public static BrutalCore get() {
        return instance;
    }

}
