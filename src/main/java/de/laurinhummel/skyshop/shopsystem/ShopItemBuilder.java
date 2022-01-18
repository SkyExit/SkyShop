package de.laurinhummel.skyshop.shopsystem;

import de.laurinhummel.skyshop.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.*;

public class ShopItemBuilder {

    public static ArrayList<ItemStack> shopItemsOres = new ArrayList<>();
    public static ArrayList<ItemStack> shopItemsBlocks = new ArrayList<>();
    public static ArrayList<ItemStack> shopItemsCrops = new ArrayList<>();
    public static ArrayList<ItemStack> shopItemsFood = new ArrayList<>();
    public static ArrayList<ItemStack> shopItemsForaging = new ArrayList<>();

    public enum Categories {
        HOMEPAGE,
        ORES,
        BLOCKS,
        CROPS,
        FOOD,
        FORAGING
    }

    public final void buildShopItem(Material material, String title, int priceBuy, int priceSell, Categories categories, boolean enchanted) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        if(enchanted) itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setDisplayName(title);
        ArrayList<String> itemLore = new ArrayList<>();
            itemLore.add(ChatColor.AQUA + "Buy Price: " + Main.getEconomy().format(priceBuy));
            itemLore.add(ChatColor.AQUA + "Sell Price: " + Main.getEconomy().format(priceSell));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        switch (categories) {
            case ORES -> shopItemsOres.add(itemStack);
            case BLOCKS -> shopItemsBlocks.add(itemStack);
            case CROPS -> shopItemsCrops.add(itemStack);
            case FOOD -> shopItemsFood.add(itemStack);
            case FORAGING -> shopItemsForaging.add(itemStack);
        }
    }

    public ArrayList<ItemStack> getShopItemsOres() {
        return shopItemsOres;
    }

    public ArrayList<ItemStack> getShopItemsBlocks() {
        return shopItemsBlocks;
    }

    public ArrayList<ItemStack> getShopItemsCrops() {
        return shopItemsCrops;
    }

    public ArrayList<ItemStack> getShopItemsFood() {
        return shopItemsFood;
    }

    public ArrayList<ItemStack> getShopItemsForaging() {
        return shopItemsForaging;
    }
}
