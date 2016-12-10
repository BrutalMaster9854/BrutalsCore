package tk.brutalmaster9854.core.packet.actionbar;

import org.bukkit.entity.Player;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.packet.BPacket;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PacketActionbar extends BPacket {

    public void sendActionBar(Player player, String message) {
        message = BrutalCore.get().toColor(message);

        String nmsver = getNMSVersion();
        try {
            Class<?> c1 = Class.forName("org.bukkit.craftbukkit." + nmsver + ".entity.CraftPlayer");
            Object p = c1.cast(player);

            Class<?> c4 = Class.forName("net.minecraft.server." + nmsver + ".PacketPlayOutChat");
            Class<?> c5 = Class.forName("net.minecraft.server." + nmsver + ".Packet");

            Class<?> c2 = Class.forName("net.minecraft.server." + nmsver + ".ChatComponentText");
            Class<?> c3 = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
            Object o = c2.getConstructor(new Class[] { String.class }).newInstance(new Object[] { message });
            Object ppoc = c4.getConstructor(new Class[] { c3, Byte.TYPE }).newInstance(new Object[] { o, Byte.valueOf("2") });

            Method m1 = c1.getDeclaredMethod("getHandle", new Class[0]);
            Object h = m1.invoke(p, new Object[0]);
            Field f1 = h.getClass().getDeclaredField("playerConnection");
            Object pc = f1.get(h);
            Method m5 = pc.getClass().getDeclaredMethod("sendPacket", new Class[] { c5 });
            m5.invoke(pc, new Object[] { ppoc });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
