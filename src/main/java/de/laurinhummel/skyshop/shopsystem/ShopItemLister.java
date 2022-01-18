package de.laurinhummel.skyshop.shopsystem;

import org.bukkit.Material;

public class ShopItemLister extends ShopItemBuilder {

    Categories currentCategories = Categories.HOMEPAGE;

    public void buildShop() {
        buildShopItem(Material.DIAMOND, "DIAMOND", 100, 80, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.REDSTONE, "REDSTONE", 5, 1, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.EMERALD, "EMERALD", 20, 5, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.COAL, "COAL", 10, 3, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.IRON_INGOT, "IRON", 75, 40, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.GOLD_INGOT, "GOLD", 50, 40, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.NETHERITE_INGOT, "NETHERITE", 300, 240, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.OBSIDIAN, "OBSIDIAN", 50, 40, Categories.BLOCKS, true);
        buildShopItem(Material.OAK_LOG, "OAK", 10, 3, ShopItemBuilder.Categories.FORAGING, true);
        buildShopItem(Material.SPRUCE_LOG, "SPRUCE", 10, 3, ShopItemBuilder.Categories.FORAGING, true);
        buildShopItem(Material.BIRCH_LOG, "BIRCH", 10, 3, Categories.FORAGING, true);
        buildShopItem(Material.JUNGLE_LOG, "JUNGLE", 10, 3, ShopItemBuilder.Categories.FORAGING, true);
        buildShopItem(Material.ACACIA_LOG, "ACACIA", 10, 3, ShopItemBuilder.Categories.FORAGING, true);
        buildShopItem(Material.DARK_OAK_LOG, "DARK OAK", 10, 3, ShopItemBuilder.Categories.FORAGING, true);
    }

    public Categories getCurrentCategories() {
        return currentCategories;
    }

    public void setCurrentCategories(Categories categories) {
        currentCategories = categories;
    }


}
