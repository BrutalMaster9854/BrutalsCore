package tk.brutalmaster9854.core.builders;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder {

    private ItemStack item;

    public SkullBuilder(ItemStack item) {
        this.item = item;
    }

    public SkullBuilder setOwner(String name) {

        if(item.getType() != Material.SKULL_ITEM) throw new IllegalArgumentException("Item Type Must be SKULL_ITEM");

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(name);
        item.setItemMeta(meta);

        return this;
    }
    public ItemStack build() {
        return item;
    }
}