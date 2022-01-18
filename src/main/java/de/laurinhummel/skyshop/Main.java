package de.laurinhummel.skyshop;

import com.mojang.authlib.properties.Property;
import de.laurinhummel.skyshop.commands.MoneyCommand;
import de.laurinhummel.skyshop.commands.ShopCommand;
import de.laurinhummel.skyshop.events.PlayerInventoryOpensListener;
import de.laurinhummel.skyshop.events.ShopClickListener;
import de.laurinhummel.skyshop.shopsystem.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import com.mojang.authlib.GameProfile;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    private static Main plugin;

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        PluginManager pluginManager = Bukkit.getPluginManager();

        getCommand("econ").setExecutor(new MoneyCommand());
        getCommand("shop").setExecutor(new ShopCommand());

        pluginManager.registerEvents((Listener) new PlayerInventoryOpensListener(), (Plugin) this);
        pluginManager.registerEvents((Listener) new ShopClickListener(), (Plugin) this);

        getShopItemLister().buildShop();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
    }

    public static Economy getEconomy() {
        return econ;
    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    public static ItemStack createSkull(String url, String displayName, int enLVL) {
        ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        if(url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }
        headMeta.setDisplayName(displayName);
        headMeta.addEnchant(Enchantment.DAMAGE_ALL, enLVL, true);
        headMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        head.setItemMeta(headMeta);
        return head;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static ShopItemBuilder getShopItemBuilder() {
        return new ShopItemBuilder();
    }

    public static ShopItemLister getShopItemLister() {
        return new ShopItemLister();
    }

    public static NavigationItems getNavigationItems() {
        return new NavigationItems();
    }

    public static ShopPageBuilder getShopPageBuilder() {
        return new ShopPageBuilder();
    }

    public static ShopCommand getShopCommand() { return new ShopCommand(); }

    public static ItemActionManager getItemActionManager() { return new ItemActionManager(); }
}
