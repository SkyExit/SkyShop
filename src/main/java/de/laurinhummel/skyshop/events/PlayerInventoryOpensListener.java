package de.laurinhummel.skyshop.events;

import de.laurinhummel.skyshop.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class PlayerInventoryOpensListener implements Listener {

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent event) {
        if(event.getInventory().getType() == InventoryType.CRAFTING || event.getInventory().getType() == InventoryType.PLAYER) {
            Player player = (Player) event.getWhoClicked();
            player.getInventory().setItem(17, Main.getNavigationItems().getPocket(player));
        }

        if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR)) || (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE))) {
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getNavigationItems().getPocket((Player) event.getWhoClicked()).getItemMeta().getDisplayName()) && event.getSlot() == 17) {
            event.setCancelled(true);
        }
        if(event.isShiftClick() && (event.getSlot() == 17)) {
            event.setCancelled(true);
        }
    }
}
