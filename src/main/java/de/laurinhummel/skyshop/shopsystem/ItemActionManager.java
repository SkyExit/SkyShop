package de.laurinhummel.skyshop.shopsystem;

import de.laurinhummel.skyshop.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class ItemActionManager {
    public void performItemAction(ItemStack glassPane, ItemStack itemStack, Player player) {
        //Get action state: true = buy; false = sell
        boolean action = glassPane.getType().equals(Material.LIME_STAINED_GLASS_PANE);
        int amount = glassPane.getAmount();

        String[] buyPrice = glassPane.getItemMeta().getLore().get(0).split("\\$");
        int price = Integer.parseInt(buyPrice[1].replace(",", ""));

        if(action) {
            //Player wants to buy
            //Check if he has money
            double money = Main.getEconomy().getBalance(player);
            if(money < price) {
                player.sendMessage("You don't have enough money!");
                return;
            }
            Main.getEconomy().withdrawPlayer(player, money);
            Main.getEconomy().depositPlayer(player, money - price);
            player.sendMessage("You bought " + amount + " " + itemStack.getItemMeta().getDisplayName() + " for: " + Main.getEconomy().format(price));
            player.getWorld().dropItem(player.getLocation(), new ItemStack(itemStack.getType(), amount));
        } else {
            //Player wants to sell
            //Check if he has items
            int itemAmount = 0;
            for(ItemStack is : player.getInventory().all(itemStack.getType()).values())
            {
                itemAmount=itemAmount+is.getAmount();
            }

            if(itemAmount < amount) {
                player.sendMessage("You don't have enough items!");
                return;
            }

            Main.getEconomy().depositPlayer(player, price);
            player.sendMessage("You sold " + amount + " " + itemStack.getItemMeta().getDisplayName() + " for: " + Main.getEconomy().format(price));

            player.getInventory().removeItem(new ItemStack(itemStack.getType(), amount));
        }
    }
}
