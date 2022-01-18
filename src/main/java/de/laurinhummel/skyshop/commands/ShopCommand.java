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

            //SHOP ITEMS
            Main.getShopPageBuilder().buildHomepage(player);
        }
        return false;
    }
}
