package de.laurinhummel.skyshop.shopsystem;

import org.bukkit.Material;

public class ShopItemLister extends ShopItemBuilder {

    public static Categories currentCategories;

    public void buildShop() {
        //ORES
        buildShopItem(Material.DIAMOND, "DIAMOND", 1000, 800, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.REDSTONE, "REDSTONE", 25, 5, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.EMERALD, "EMERALD", 200, 50, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.COAL, "COAL", 100, 30, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.IRON_INGOT, "IRON", 750, 400, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.GOLD_INGOT, "GOLD", 500, 400, ShopItemBuilder.Categories.ORES, false);
        buildShopItem(Material.NETHERITE_INGOT, "NETHERITE", 3000, 2400, ShopItemBuilder.Categories.ORES, false);
        //FORAGING
        buildShopItem(Material.OAK_LOG, "OAK", 100, 30, ShopItemBuilder.Categories.FORAGING, false);
        buildShopItem(Material.SPRUCE_LOG, "SPRUCE", 100, 30, ShopItemBuilder.Categories.FORAGING, false);
        buildShopItem(Material.BIRCH_LOG, "BIRCH", 100, 30, Categories.FORAGING, false);
        buildShopItem(Material.JUNGLE_LOG, "JUNGLE", 100, 30, ShopItemBuilder.Categories.FORAGING, false);
        buildShopItem(Material.ACACIA_LOG, "ACACIA", 100, 30, ShopItemBuilder.Categories.FORAGING, false);
        buildShopItem(Material.DARK_OAK_LOG, "DARK OAK", 100, 30, ShopItemBuilder.Categories.FORAGING, false);
        //BLOCKS
        buildShopItem(Material.OBSIDIAN, "OBSIDIAN", 500, 400, Categories.BLOCKS, false);
        buildShopItem(Material.STONE, "STONE", 10, 2, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.DIORITE, "DIORITE", 12, 2, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.ANDESITE, "ANDESITE", 12, 2, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.GRANITE, "GRANITE", 12, 2, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.SAND, "SAND", 25, 5, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.RED_SAND, "RED SAND", 25, 5, ShopItemBuilder.Categories.BLOCKS, false);
        buildShopItem(Material.GRAVEL, "GRAVEL", 25, 5, ShopItemBuilder.Categories.BLOCKS, false);
        //FOOD
        buildShopItem(Material.COOKED_BEEF, "BEEF", 40, 8, Categories.FOOD, false);
        buildShopItem(Material.COOKED_CHICKEN, "CHICKEN", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        buildShopItem(Material.COOKED_COD, "COD", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        buildShopItem(Material.COOKED_MUTTON, "MUTTON", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        buildShopItem(Material.COOKED_PORKCHOP, "PORKCHOP", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        buildShopItem(Material.COOKED_RABBIT, "RABBIT", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        buildShopItem(Material.COOKED_SALMON, "SALMOND", 40, 8, ShopItemBuilder.Categories.FOOD, false);
        //CROPS
    }

    public Categories getCurrentCategories() {
        return currentCategories == null ? Categories.HOMEPAGE : currentCategories;
    }

    public void setCurrentCategories(Categories categories) {
        currentCategories = categories;
    }
}
