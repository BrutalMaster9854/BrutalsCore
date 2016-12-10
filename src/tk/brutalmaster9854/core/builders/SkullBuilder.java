package tk.brutalmaster9854.core.builders;

import org.bukkit.Material;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder extends ItemBuilder {

    public SkullBuilder(Material material) {
        super(material);
    }
    public SkullBuilder(Material material, int amount) {
        super(material, amount);
    }
    public SkullBuilder(Material material, int amount, short data) {
        super(material, amount, data);
    }
    public SkullBuilder setOwner(String owner) {
        if(item.getType() != Material.SKULL_ITEM) throw new IllegalArgumentException("The Item Must Be A Skull to set the owner");
        if(!(item.getItemMeta() instanceof SkullMeta)) throw new IllegalArgumentException("The Item Must Be A Skull To set the owner");

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(owner);
        item.setItemMeta(meta);

        return this;
    }
}
