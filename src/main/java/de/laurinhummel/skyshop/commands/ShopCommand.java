package de.laurinhummel.skyshop.commands;

import de.laurinhummel.skyshop.Main;
import de.laurinhummel.skyshop.shopsystem.ShopItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            FileConfiguration config = Main.getPlugin().getConfig();
            Player player = (Player) sender;
            String PREFIX = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
            String ArrowLeft = "ODY1MmUyYjkzNmNhODAyNmJkMjg2NTFkN2M5ZjI4MTlkMmU5MjM2OTc3MzRkMThkZmRiMTM1NTBmOGZkYWQ1ZiJ9fX0=";
            String ArrowRight = "MmEzYjhmNjgxZGFhZDhiZjQzNmNhZThkYTNmZTgxMzFmNjJhMTYyYWI4MWFmNjM5YzNlMDY0NGFhNmFiYWMyZiJ9fX0=";
            Inventory shopInv = Bukkit.getServer().createInventory(player, 54, ChatColor.AQUA + "Sky" + ChatColor.GOLD + "Shop");

            //PLACEHOLDER
            ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholdermeta = placeholder.getItemMeta();
            assert placeholdermeta != null;
            placeholdermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            placeholdermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            placeholdermeta.setDisplayName(ChatColor.RED + "PLACEHOLDER");
            placeholder.setItemMeta(placeholdermeta);

            //Close Shop
            ItemStack closeShop = new ItemStack(Material.BARRIER);
            ItemMeta closeShopMeta = closeShop.getItemMeta();
            assert closeShopMeta != null;
            closeShopMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            closeShopMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            closeShopMeta.setDisplayName(ChatColor.RED + "CLOSE SHOP");
            closeShop.setItemMeta(closeShopMeta);

            //PLACEHOLDERS
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
            shopInv.setItem(46, Main.createSkull(PREFIX + ArrowLeft, ChatColor.DARK_GRAY + "Previous Page", 11));
            shopInv.setItem(52, Main.createSkull(PREFIX + ArrowRight, ChatColor.DARK_GRAY + "Next Page", 12));
            shopInv.setItem(49, closeShop);

            //SHOP ITEMS
            for(int a = 0; a < Main.getShopItemBuilder().getShopItemsOres().size(); a++) {
                shopInv.setItem(a+9, Main.getShopItemBuilder().getShopItemsOres().get(a));
            }

            System.out.println(Main.getShopItemBuilder().getShopItemsOres().size());

            player.openInventory(shopInv);

        }
        return false;
    }
}
