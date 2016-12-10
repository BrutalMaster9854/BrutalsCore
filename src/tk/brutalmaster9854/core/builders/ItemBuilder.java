package tk.brutalmaster9854.core.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.brutalmaster9854.core.BrutalCore;
import tk.brutalmaster9854.core.utils.EnchantmentGlow;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    protected ItemStack item;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }
    public ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
    }
    public ItemBuilder(Material material, int amount, short data) {
        this.item = new ItemStack(material, amount, data);
    }
    public ItemBuilder setName(String name) {

        ItemMeta im = item.getItemMeta();
        im.setDisplayName(BrutalCore.get().toColor(name));
        item.setItemMeta(im);

        return this;
    }
    public ItemBuilder addLore(String msg) {

        ItemMeta im = item.getItemMeta();
        List<String> lore = im.getLore();

        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(BrutalCore.get().toColor(msg));
        im.setLore(lore);
        item.setItemMeta(im);

        return this;
    }
    public ItemBuilder addGlow() {
        item.addEnchantment(new EnchantmentGlow(), 1);
        return this;
    }
    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        item.addEnchantment(enchantment, level);
        return this;
    }
    public ItemStack build() {
        return item;
    }
}
