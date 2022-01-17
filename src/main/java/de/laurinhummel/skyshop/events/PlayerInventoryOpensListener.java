package de.laurinhummel.skyshop.events;

import de.laurinhummel.skyshop.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerInventoryOpensListener implements Listener {

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent event) {
        if(event.getInventory().getType() == InventoryType.CRAFTING || event.getInventory().getType() == InventoryType.PLAYER) {
            Player player = (Player) event.getWhoClicked();
            player.getInventory().setItem(17, getChestItem(player));
        }

        if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR)) || (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE))) {
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equals(getChestItem((Player) event.getWhoClicked()).getItemMeta().getDisplayName()) && event.getSlot() == 17) {
            event.setCancelled(true);
        }
        if(event.isShiftClick() && (event.getSlot() == 17)) {
            event.setCancelled(true);
        }
    }

    private ItemStack getChestItem(Player player) {
        ItemStack itemStack = new ItemStack(Material.BROWN_SHULKER_BOX);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setDisplayName(ChatColor.AQUA + "Bank " + ChatColor.GOLD + "Manager");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatColor.AQUA + "Pocket Money: " + ChatColor.GOLD + Main.getEconomy().format(Main.getEconomy().getBalance(player)));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}