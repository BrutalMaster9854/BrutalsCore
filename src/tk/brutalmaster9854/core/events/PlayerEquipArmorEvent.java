package tk.brutalmaster9854.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerEquipArmorEvent extends Event {


    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final ItemStack itemStack;

    public PlayerEquipArmorEvent(Player player, ItemStack itemStack) {
        this.player = player;
        this.itemStack = itemStack;
    }
    public Player getPlayer() {
        return this.player;
    }
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
