package tk.brutalmaster9854.core.placeholders.player;

import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.placeholders.PlaceHolderHook;

public class PlayerPlaceHolderHook implements PlaceHolderHook {

    @Override
    public String[] getIdentifiers() {
        return new String[] {"{player_name}", "{player_displayname}", "{player_uuid}", "{player_local}", "{player_health}", "{player_isop}", "{player_world}", "{player_x}", "{player_y}", "player_z", "{player_xp}", "{player_ip}", "{player_issneaking}", "player_hunger}"};
    }

    @Override
    public String hook(Player player, String string) {

        for(String identifier : getIdentifiers()) {

            if(string.contains(identifier)) {

                switch(identifier) {

                    case "{player_name}":
                        string = string.replace(identifier, player.getName());
                        break;
                    case "{player_displayname}":
                        string = string.replace(identifier, player.getDisplayName());
                        break;
                    case "{player_uuid}":
                        string = string.replace(identifier, player.getUniqueId().toString());
                        break;
                    case "{player_local":
                        string = string.replace(identifier, player.spigot().getLocale());
                        break;
                    case "{player_health}":
                        string = string.replace(identifier, String.valueOf(player.getHealth()));
                        break;
                    case "{player_isop}":
                        string = string.replace(identifier, String.valueOf(player.isOp()));
                    case "{player_world}":
                        string = string.replace(identifier, player.getLocation().getWorld().getName());
                        break;
                    case "{player_x}":
                        string = string.replace(identifier, String.valueOf(player.getLocation().getX()));
                        break;
                    case "{player_y}":
                        string = string.replace(identifier, String.valueOf(player.getLocation().getY()));
                        break;
                    case "{player_z}":
                        string = string.replace(identifier, String.valueOf(player.getLocation().getZ()));
                        break;
                    case "{player_xp}":
                        string = string.replace(identifier, String.valueOf(player.getExpToLevel()));
                        break;
                    case "{player_ip}":
                        string = string.replace(identifier, String.valueOf(player.getAddress().getAddress()));
                        break;
                    case "{player_issneaking}":
                        string = string.replace(identifier, String.valueOf(player.isSneaking()));
                        break;
                    case "{player_hunger}":
                        string = string.replace(identifier, String.valueOf(player.getExhaustion()));
                }

            }
        }
        return string;
    }
}
