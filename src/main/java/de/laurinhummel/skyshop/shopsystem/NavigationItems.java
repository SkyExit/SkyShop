package de.laurinhummel.skyshop.shopsystem;

import de.laurinhummel.skyshop.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class NavigationItems {
    String PREFIX = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    String ArrowLeft = "ODY1MmUyYjkzNmNhODAyNmJkMjg2NTFkN2M5ZjI4MTlkMmU5MjM2OTc3MzRkMThkZmRiMTM1NTBmOGZkYWQ1ZiJ9fX0=";
    String ArrowRight = "MmEzYjhmNjgxZGFhZDhiZjQzNmNhZThkYTNmZTgxMzFmNjJhMTYyYWI4MWFmNjM5YzNlMDY0NGFhNmFiYWMyZiJ9fX0=";
    String Cross = "NWE2Nzg3YmEzMjU2NGU3YzJmM2EwY2U2NDQ5OGVjYmIyM2I4OTg0NWU1YTY2YjVjZWM3NzM2ZjcyOWVkMzcifX19";

    public ItemStack getArrowLeft() {
        ItemStack itemStack =  Main.createSkull(PREFIX + ArrowLeft, ChatColor.DARK_GRAY + "Previous Page", 11);
        return itemStack;
    }

    public ItemStack getArrowRight() {
        ItemStack itemStack =  Main.createSkull(PREFIX + ArrowRight, ChatColor.DARK_GRAY + "Next Page", 12);
        return itemStack;
    }

    public ItemStack getCrossItem() {
        ItemStack itemStack =  Main.createSkull(PREFIX + Cross, ChatColor.DARK_GRAY + "Nothing Here", 13);
        return itemStack;
    }

    public ItemStack getPocket(Player player) {
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

    public ItemStack getPlaceholderItem() {
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeholdermeta = placeholder.getItemMeta();
        assert placeholdermeta != null;
        placeholdermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        placeholdermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        placeholdermeta.setDisplayName(ChatColor.RED + "PLACEHOLDER");
        placeholder.setItemMeta(placeholdermeta);

        return placeholder;
    }

    public ItemStack getPlayerHeadWallet(Player player) {
        ItemStack headItem = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headSkullMeta = (SkullMeta) headItem.getItemMeta();
        assert headSkullMeta != null;
        headSkullMeta.setOwningPlayer(player);
        headSkullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        headSkullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        headSkullMeta.setDisplayName(ChatColor.GREEN + "YOUR WALLET");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatColor.AQUA + "Pocket Money: " + ChatColor.GOLD + Main.getEconomy().format(Main.getEconomy().getBalance(player)));
        headSkullMeta.setLore(itemLore);
        headItem.setItemMeta(headSkullMeta);

        return headItem;
    }

    public ItemStack buildSellGlassItem(boolean action, int amount, ItemStack item, Player player) {
        //action: true = buy; false = sell

        Economy economy = Main.getEconomy();

        //The Item to sell/buy
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        List<String> lores = itemMeta.getLore();
        assert lores != null;
        String[] buyPrice = lores.get(0).split("\\$");
        String[] sellPrice = lores.get(1).split("\\$");

        int buyInt = Integer.parseInt(buyPrice[1].replace(",", ""));
        int sellInt = Integer.parseInt(sellPrice[1].replace(",", ""));

        ItemStack glassItem;
        glassItem = action ? new ItemStack(Material.LIME_STAINED_GLASS_PANE, amount) : new ItemStack(Material.RED_STAINED_GLASS_PANE, amount);
        ItemMeta glassItemMeta = glassItem.getItemMeta();
        assert glassItemMeta != null;
        glassItemMeta.setDisplayName(action ? ChatColor.GREEN + "BUY " + amount : ChatColor.DARK_RED + "Sell " + amount);
        ArrayList<String> glassLore = new ArrayList<>();
        glassLore.add(action ? ChatColor.DARK_GREEN + "Buy for: " + economy.format(amount*buyInt) : ChatColor.RED + "Sell for: " + economy.format(amount*sellInt));
        glassItemMeta.setLore(glassLore);
        glassItem.setItemMeta(glassItemMeta);

        return glassItem;
    }


}
