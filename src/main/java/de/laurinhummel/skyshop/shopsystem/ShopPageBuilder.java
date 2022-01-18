package de.laurinhummel.skyshop.shopsystem;

import de.laurinhummel.skyshop.Main;
import de.laurinhummel.skyshop.commands.ShopCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopPageBuilder extends ShopCommand {
    public void buildHomepage(Inventory shop, Player player) {
        clearPage(player);
        Main.getShopItemLister().setCurrentCategories(ShopItemBuilder.Categories.HOMEPAGE);

        shop.setItem(19, new ItemStack(Material.GRASS_BLOCK));
        shop.setItem(22, new ItemStack(Material.IRON_INGOT));
        shop.setItem(25, new ItemStack(Material.BEEF));
        shop.setItem(29, new ItemStack(Material.JUNGLE_SAPLING));
        shop.setItem(33, new ItemStack(Material.WHEAT));


    }

    public void clearPage(Player player) {
        Inventory shop = getShopInv(player);
        for(int a = 9; a <= 44; a++) {
            shop.setItem(a, new ItemStack(Material.AIR));
        }
    }
}
