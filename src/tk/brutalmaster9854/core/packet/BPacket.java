package tk.brutalmaster9854.core.packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BPacket {

    public String getNMSVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }
    public Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server." + getNMSVersion() + "." + name);
        } catch(Exception e) {

        }
        return null;
    }
    public void sendPacket(Player player, Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
            Object playerConnection = handle.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(player, null);
            playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
