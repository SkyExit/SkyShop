package de.laurinhummel.skyshop.shopsystem;

import org.bukkit.Material;

public class ShopItemLister extends ShopItemBuilder {

    Categories currentCategories = Categories.HOMEPAGE;

    public void buildShop() {
        buildShopItem(Material.DIAMOND, "DIAMOND", 100, 80, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.REDSTONE, "REDSTONE", 5, 1, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.EMERALD, "EMERALD", 20, 5, ShopItemBuilder.Categories.ORES, true);
        buildShopItem(Material.COAL, "COAL", 10, 3, ShopItemBuilder.Categories.ORES, true);
    }

    public Categories getCurrentCategories() {
        return currentCategories;
    }

    public void setCurrentCategories(Categories categories) {
        currentCategories = categories;
    }


}
