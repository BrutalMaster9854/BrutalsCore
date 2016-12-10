package tk.brutalmaster9854.core.bungeecord;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.BrutalCore;

public class ServerConnector {

    public void connect(Player player, String server) {

        ByteArrayDataOutput data = ByteStreams.newDataOutput();

        data.writeUTF("Connect");
        data.writeUTF(server);

        player.sendPluginMessage(BrutalCore.get(), "BungeeCord", data.toByteArray());
    }
}
