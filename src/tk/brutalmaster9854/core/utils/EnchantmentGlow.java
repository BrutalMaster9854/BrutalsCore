package tk.brutalmaster9854.core.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentGlow extends Enchantment {

    public EnchantmentGlow() {
        super(100);
    }
    @Override
    public String getName() {
        return "";
    }
    @Override
    public int getMaxLevel() {
        return 0;
    }
    @Override
    public int getStartLevel() {
        return 0;
    }
    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }
    @Override
    public boolean isTreasure() {
        return false;
    }
    @Override
    public boolean isCursed() {
        return false;
    }
    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }
    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }
}
