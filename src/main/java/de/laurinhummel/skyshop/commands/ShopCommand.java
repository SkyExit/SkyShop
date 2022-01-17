package de.laurinhummel.skyshop.commands;

import de.laurinhummel.skyshop.Main;
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
            String MASK = "NGQ4MjU3ZTExNzVhOWFhMTgyMTgxODg5MTI3ZTVhNTQzMGM4MWMzMTViNjNiMjI2ZDAyOTEzZDEyNDk0NSJ9fX0=";
            String FACE = "YmE4YTU1ZmZlNjNhMWZjOTZkYzYyNzA1YzY5Nzc0OWQ2NWY1OTRmMTY2NDM4N2JjODg3NmZlM2FkMzViNzI3MCJ9fX0=";
            Inventory shopInv = Bukkit.getServer().createInventory(player, 54, ChatColor.AQUA + "Sky" + ChatColor.GOLD + "Shop");

            //PLACEHOLDER
            ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta placeholdermeta = placeholder.getItemMeta();
            assert placeholdermeta != null;
            placeholdermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            placeholdermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            placeholdermeta.setDisplayName(ChatColor.RED + "PLACEHOLDER");
            placeholder.setItemMeta(placeholdermeta);

            shopInv.setItem(0, placeholder);
            shopInv.setItem(1, placeholder);
            shopInv.setItem(2, placeholder);
            shopInv.setItem(3, placeholder);
            shopInv.setItem(4, placeholder);
            shopInv.setItem(5, placeholder);
            shopInv.setItem(6, placeholder);
            shopInv.setItem(7, placeholder);
            shopInv.setItem(8, placeholder);
            
            player.openInventory(shopInv);
        }
        return false;
    }
}
