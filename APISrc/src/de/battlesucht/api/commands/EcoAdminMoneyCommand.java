package de.battlesucht.api.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoAdminMoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        if(commandSender.hasPermission("battleapi.ecoadminCoins")){

            if(strings.length==0) {
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminCoins <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            } else if(strings.length==1){
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminCoins <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            } else if(strings.length==2){

                if(strings[0].equalsIgnoreCase("show")){
                    if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat aktuell "+ CoinsAPI.getCoins(Bukkit.getOfflinePlayer(strings[1])) + " Coins.");
                        return true;
                    }
                    p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat aktuell "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                    return true;
                } else if(strings[0].equalsIgnoreCase("reset")){
                    if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                        CoinsAPI.resetCoins(Bukkit.getOfflinePlayer(strings[1]));
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ CoinsAPI.getCoins(Bukkit.getOfflinePlayer(strings[1])) + " Coins.");
                        return true;
                    }
                    CoinsAPI.resetCoins(Bukkit.getPlayer(strings[1]));
                    p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                    return true;
                }
            } else if(strings.length==3){
                if(strings[0].equalsIgnoreCase("give")){
                    if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                        CoinsAPI.addCoins(Bukkit.getOfflinePlayer(strings[1]), Integer.valueOf(strings[2]));
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"$7 hat nun "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                        return true;
                    }
                    CoinsAPI.addCoins(Bukkit.getPlayer(strings[1]), Integer.valueOf(strings[2]));
                    p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                    return true;
                } else if(strings[0].equalsIgnoreCase("take")){
                    if(Bukkit.getPlayer(strings[1]).isOnline()==false){
                        CoinsAPI.removeCoins(Bukkit.getOfflinePlayer(strings[1]), Integer.valueOf(strings[2]));
                        p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"$7 hat nun "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                        return true;
                    }
                    CoinsAPI.removeCoins(Bukkit.getPlayer(strings[1]), Integer.valueOf(strings[2]));
                    p.sendMessage(Language.prefix+"Der Spieler §e"+strings[1]+"§7 hat nun "+ CoinsAPI.getCoins(Bukkit.getPlayer(strings[1])) + " Coins.");
                    return true;
                } else {
                    p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminCoins <show, give, take, reset> <Spieler>  [Anzahl]");
                    return false;
                }
            } else if(strings.length>=3){
                p.sendMessage(Language.prefix + "Bitte verwende: §a/ecoadminCoins <show, give, take, reset> <Spieler>  [Anzahl]");
                return false;
            }
        } else {
            p.sendMessage(Language.noPermissions);
        }

        return false;
    }
}
