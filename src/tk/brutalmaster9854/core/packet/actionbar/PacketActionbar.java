package tk.brutalmaster9854.core.packet.actionbar;

import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.packet.BPacket;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PacketActionbar extends BPacket {

    public void sendActionBar(Player player, String message) {

        try {

            Class<?> craftPlayer = getNMSClass("CraftPlayer");
            Class<?> packetPlayOutChat = getNMSClass("PacketPlayOutChat");
            Class<?> packet = getNMSClass("Packet");

            Object p = craftPlayer.cast(player);

            Class<?> chatComponentText = getNMSClass("ChatComponentText");
            Class<?> iChatBaseComponent = getNMSClass("IChatBaseComponent");

            Object o = chatComponentText.getConstructor(new Class<?>[]{String.class}).newInstance(message);
            Object ppoc = packetPlayOutChat.getConstructor(new Class<?>[]{iChatBaseComponent, byte.class}).newInstance(o, (byte)2);

            sendPacket(player, ppoc);

        } catch (Exception ex) {

        }
    }
}
