package de.battlesucht.api.commands.activateable;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        p.sendMessage(Language.prefix+"Du hast §e" + CoinsAPI.getCoins(p) + "§7 Coins.");
        return true;
    }
}
