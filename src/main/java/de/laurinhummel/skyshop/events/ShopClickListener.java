package de.laurinhummel.skyshop.events;

import de.laurinhummel.skyshop.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ShopClickListener implements Listener {
    String PREFIX = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    String ArrowLeft = "ODY1MmUyYjkzNmNhODAyNmJkMjg2NTFkN2M5ZjI4MTlkMmU5MjM2OTc3MzRkMThkZmRiMTM1NTBmOGZkYWQ1ZiJ9fX0=";
    String ArrowRight = "MmEzYjhmNjgxZGFhZDhiZjQzNmNhZThkYTNmZTgxMzFmNjJhMTYyYWI4MWFmNjM5YzNlMDY0NGFhNmFiYWMyZiJ9fX0=";

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent event) {
        if(event.getView().getTitle().equals(ChatColor.AQUA + "Sky" + ChatColor.GOLD + "Shop")) {
            if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR)) || (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE))) {
                event.setCancelled(true);
                return;
            }
            if(event.getCurrentItem().getType() == Material.BARRIER) {
                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
                return;
            }

            //SWITCH PAGE TO LEFT
            if(event.getSlot() == 46 && event.getCurrentItem().getItemMeta().getEnchantLevel(Enchantment.DAMAGE_ALL) == 11) {
               event.setCancelled(true);
            }

            //SWITCH PAGE TO RIGHT
            if(event.getSlot() == 52 && event.getCurrentItem().getItemMeta().getEnchantLevel(Enchantment.DAMAGE_ALL) == 12) {
                event.setCancelled(true);
            }
        }
    }
}
