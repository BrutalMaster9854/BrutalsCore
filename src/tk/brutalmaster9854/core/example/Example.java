package tk.brutalmaster9854.core.example;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tk.brutalmaster9854.core.BrutalCore;

public class Example implements Listener {

    @EventHandler
    void example(AsyncPlayerChatEvent event) {

        if(event.getPlayer().getName().equalsIgnoreCase("BrutalMaster9854")) {

            event.getPlayer().sendMessage(BrutalCore.get().toColor(BrutalCore.get().getPlaceHolderAPI().setPlaceHolders(event.getPlayer(), "{player_name}, {server_worldcount}")));
        }
    }
}
