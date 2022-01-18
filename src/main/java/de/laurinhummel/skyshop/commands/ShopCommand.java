package de.laurinhummel.skyshop.commands;

import de.laurinhummel.skyshop.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            FileConfiguration config = Main.getPlugin().getConfig();
            Player player = (Player) sender;

            Inventory shopInv = getShopInv(player);

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

            //SHOP ITEMS
            Main.getShopPageBuilder().buildHomepage(shopInv, player);

            /* for(int a = 0; a < Main.getShopItemBuilder().getShopItemsOres().size(); a++) {
                shopInv.setItem(a+9, Main.getShopItemBuilder().getShopItemsOres().get(a));
            } */

            player.openInventory(shopInv);

        }
        return false;
    }

    public Inventory getShopInv(Player player) {
        Inventory shopInv = Bukkit.getServer().createInventory(player, 54, ChatColor.AQUA + "Sky" + ChatColor.GOLD + "Shop");
        return shopInv;
    }
}
