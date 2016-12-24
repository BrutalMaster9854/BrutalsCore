package tk.brutalmaster9854.core.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentGlow extends Enchantment {

    public EnchantmentGlow() {
        super(165);
    }
    @Override
    public String getName() {
        return "";
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public int getStartLevel() {
        return 1;
    }
    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL;
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
