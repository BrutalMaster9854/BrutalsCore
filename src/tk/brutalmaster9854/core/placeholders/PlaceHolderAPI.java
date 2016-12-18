package tk.brutalmaster9854.core.placeholders;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.placeholders.player.PlayerPlaceHolderHook;
import tk.brutalmaster9854.core.placeholders.server.ServerPlaceHolderHook;

import java.util.ArrayList;
import java.util.List;

public class PlaceHolderAPI {

    private List<PlaceHolderHook> validHooks;

    public PlaceHolderAPI() {

        validHooks = new ArrayList<>();

        validHooks.add(new PlayerPlaceHolderHook());
        validHooks.add(new ServerPlaceHolderHook());
    }
    private boolean isPluginEnabled(String name) {
        return Bukkit.getPluginManager().getPlugin(name) != null;
    }
    public String setPlaceHolders(Player player, String string) {

        for(PlaceHolderHook placeHolderHook : validHooks) {

            for(String identifier : placeHolderHook.getIdentifiers()) {

                if(string.contains(identifier)) {
                    string = placeHolderHook.hook(player, string);
                }
            }
        }
        return string;
    }
}
