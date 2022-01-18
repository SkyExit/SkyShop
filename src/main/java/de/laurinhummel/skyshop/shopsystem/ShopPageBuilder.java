package de.laurinhummel.skyshop.shopsystem;

import de.laurinhummel.skyshop.Main;
import de.laurinhummel.skyshop.commands.ShopCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopPageBuilder extends ShopCommand {
    public void buildHomepage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.HOMEPAGE);
        Inventory shop = getEmptyShop(player);

        shop.setItem(20, new ItemStack(Material.BRICKS));
        shop.setItem(22, new ItemStack(Material.IRON_INGOT));
        shop.setItem(24, new ItemStack(Material.SPRUCE_SAPLING));
        shop.setItem(30, new ItemStack(Material.BEEF));
        shop.setItem(32, new ItemStack(Material.WHEAT));

        shop.setItem(46, Main.getNavigationItems().getCrossItem());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

        reloadShop(shop, player);
    }

    public void buildOresPage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.ORES);
        Inventory shop = getEmptyShop(player);

         for(int a = 0; a < Main.getShopItemBuilder().getShopItemsOres().size(); a++) {
                shop.setItem(a+9, Main.getShopItemBuilder().getShopItemsOres().get(a));
         }

        shop.setItem(46, Main.getNavigationItems().getArrowLeft());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

         reloadShop(shop, player);
    }

    public void buildBlocksPage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.BLOCKS);
        Inventory shop = getEmptyShop(player);

        for(int a = 0; a < Main.getShopItemBuilder().getShopItemsBlocks().size(); a++) {
            shop.setItem(a+9, Main.getShopItemBuilder().getShopItemsBlocks().get(a));
        }

        shop.setItem(46, Main.getNavigationItems().getArrowLeft());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

        reloadShop(shop, player);
    }

    public void buildCropsPage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.CROPS);
        Inventory shop = getEmptyShop(player);

        for(int a = 0; a < Main.getShopItemBuilder().getShopItemsCrops().size(); a++) {
            shop.setItem(a+9, Main.getShopItemBuilder().getShopItemsCrops().get(a));
        }

        shop.setItem(46, Main.getNavigationItems().getArrowLeft());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

        reloadShop(shop, player);
    }

    public void buildFoodPage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.FOOD);
        Inventory shop = getEmptyShop(player);

        for(int a = 0; a < Main.getShopItemBuilder().getShopItemsFood().size(); a++) {
            shop.setItem(a+9, Main.getShopItemBuilder().getShopItemsFood().get(a));
        }

        shop.setItem(46, Main.getNavigationItems().getArrowLeft());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

        reloadShop(shop, player);
    }

    public void buildForagingPage(Player player) {
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.FORAGING);
        Inventory shop = getEmptyShop(player);

        for(int a = 0; a < Main.getShopItemBuilder().getShopItemsForaging().size(); a++) {
            shop.setItem(a+9, Main.getShopItemBuilder().getShopItemsForaging().get(a));
        }

        shop.setItem(46, Main.getNavigationItems().getArrowLeft());
        shop.setItem(52, Main.getNavigationItems().getCrossItem());

        reloadShop(shop, player);
    }

    public void reloadShop(Inventory shop, Player player) {
        //player.closeInventory();
        player.openInventory(shop);
    }

    public Inventory getEmptyShop(Player player) {
        Inventory shopInv = Bukkit.getServer().createInventory(player, 54, ChatColor.AQUA + "Sky" + ChatColor.GOLD + "Shop");

        //PLACEHOLDERS
        ItemStack placeholder = Main.getNavigationItems().getPlaceholderItem();
        shopInv.setItem(0, placeholder);
        shopInv.setItem(1, placeholder);
        shopInv.setItem(2, placeholder);
        shopInv.setItem(3, placeholder);
        shopInv.setItem(4, placeholder);
        shopInv.setItem(5, placeholder);
        shopInv.setItem(6, placeholder);
        shopInv.setItem(7, placeholder);
        shopInv.setItem(8, placeholder);
        shopInv.setItem(45, placeholder);
        shopInv.setItem(47, placeholder);
        shopInv.setItem(48, placeholder);
        shopInv.setItem(50, placeholder);
        shopInv.setItem(51, placeholder);
        shopInv.setItem(53, placeholder);

        //NAVIGATION
        shopInv.setItem(46, Main.getNavigationItems().getArrowLeft());
        shopInv.setItem(52, Main.getNavigationItems().getArrowRight());
        shopInv.setItem(49, Main.getNavigationItems().getPlayerHeadWallet(player));

        return shopInv;
    }
}
