package de.battlesucht.api.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.api.utils.server.global.BitsAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BitsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        p.sendMessage(Language.prefix+"Du hast §e" + BitsAPI.getBits(p) + "§7 Bits.");
        return true;
    }
}
