package tk.brutalmaster9854.core.placeholders.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.placeholders.PlaceHolderHook;

public class ServerPlaceHolderHook implements PlaceHolderHook {

    @Override
    public String[] getIdentifiers() {
        return new String[] {"{server_players}", "{server_maxplayers}", "{server_worldcount}"};
    }

    @Override
    public String hook(Player player, String string) {

        for(String identifier : getIdentifiers()) {

            if(string.contains(identifier)) {

                switch (identifier) {

                    case "{server_players}":
                        string = string.replace(identifier, String.valueOf(Bukkit.getOnlinePlayers().size()));
                        break;
                    case "{server_maxplayers}":
                        string = string.replace(identifier, String.valueOf(Bukkit.getMaxPlayers()));
                        break;
                    case "{server_worldcount}":
                        string = string.replace(identifier, String.valueOf(Bukkit.getWorlds().size()));
                        break;
                }
            }
        }
        return string;
    }
}
