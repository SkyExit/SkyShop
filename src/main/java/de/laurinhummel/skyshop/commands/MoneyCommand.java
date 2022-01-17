package de.laurinhummel.skyshop.commands;

import de.laurinhummel.skyshop.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    Economy eco = Main.getEconomy();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage(ChatColor.AQUA + "Your Balance: " + ChatColor.GOLD + eco.format(eco.getBalance(player)));
            return true;
        }
        switch (args[0]) {
            case "add" -> {
                if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) return false;
                    double currEco = eco.getBalance(target);
                    double toAdd = Double.parseDouble(args[2]);
                    double newCurr = currEco + toAdd;
                    eco.withdrawPlayer(target, eco.getBalance(target));
                    eco.depositPlayer(target, newCurr);
                    player.sendMessage(ChatColor.GOLD + eco.format(toAdd) + ChatColor.AQUA + " were added to " +
                            ChatColor.GOLD + target.getName());
                }
            }
            case "get" -> {
                if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) return false;
                    player.sendMessage(ChatColor.AQUA + "The Balance of " + ChatColor.GOLD + target.getName() +
                            ChatColor.AQUA + " is: " + ChatColor.GOLD + eco.format(eco.getBalance(target)));
                }
            }
            case "set" -> {
                if (args.length == 3) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) return false;
                    eco.withdrawPlayer(target, eco.getBalance(target));
                    eco.depositPlayer(target, Double.parseDouble(args[2]));
                    player.sendMessage(ChatColor.AQUA + "Money was set!");
                }
            }
            case "help" -> {
                player.sendMessage(ChatColor.BLUE + "Valid arguments: " + "\n" + ChatColor.GREEN + "/econ [Name / add, get, set] <Name> <Amount>");
            }
            default -> {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    player.sendMessage(ChatColor.AQUA + "The Balance of " + ChatColor.GOLD + target.getName() +
                            ChatColor.AQUA + " is: " + ChatColor.GOLD + eco.format(eco.getBalance(target)));
                } else {
                    player.sendMessage(ChatColor.RED + "Requested player isn't online!");
                }
            }
        }

        return false;
    }
}