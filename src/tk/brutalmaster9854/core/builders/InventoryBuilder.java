package tk.brutalmaster9854.core.builders;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tk.brutalmaster9854.core.BrutalCore;

public class InventoryBuilder {

    private Inventory inventory;

    public InventoryBuilder(int size) {
        inventory = Bukkit.createInventory(null, size);
    }
    public InventoryBuilder(int size, String name) {
        inventory = Bukkit.createInventory(null, size, BrutalCore.get().toColor(name));
    }
    public InventoryBuilder addItem(ItemStack... stack) {
        inventory.addItem(stack);
        return this;
    }
    public InventoryBuilder setItem(ItemStack stack, int slot) {
        inventory.setItem(slot, stack);
        return this;
    }
    public Inventory build() {
        return inventory;
    }
}
