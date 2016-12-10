package tk.brutalmaster9854.core.packet.tablist;

import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.packet.BPacket;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PacketTabList extends BPacket {

    public void sendTabTitle(Player player, String header, String footer) {
        if (header == null) {
            header = "";
        }
        header = BrutalCore.get().toColor(header);
        if (footer == null) {
            footer = "";
        }
        footer = BrutalCore.get().toColor(footer);
        try {
            Object tabHeader = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + header + "\"}" });
            Object tabFooter = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + footer + "\"}" });
            Constructor<?> titleConstructor = getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[] { getNMSClass("IChatBaseComponent") });
            Object packet = titleConstructor.newInstance(new Object[] { tabHeader });
            Field field = packet.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(packet, tabFooter);
            sendPacket(player, packet);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
