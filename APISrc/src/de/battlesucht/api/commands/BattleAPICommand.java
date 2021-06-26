package de.battlesucht.api.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.api.utils.server.plugin.PermissionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BattleAPICommand extends Language implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(p.hasPermission("battleapi.cmd")) {
            if(strings.length==0) {
                p.sendMessage(prefix+"Bitte benutze: §e/battleapi <showPermissions, version>");
                return true;
            } else if(strings.length==1) {
                if(strings[0].equalsIgnoreCase("showpermissions")) {
                    p.sendMessage(prefix+"Diese Permissions sind registriert: §e\n");
                    for(String project : PermissionManager.getProjects()) {
                        p.sendMessage("§c"+project+"\n\n");
                        p.sendMessage("§b"+PermissionManager.getPermissions(project).toString()+"\n");
                    }
                    return true;
                } else if(strings[0].equalsIgnoreCase("version")) {
                    p.sendMessage(prefix+"§eBattleAPI v1, es sind "+ PermissionManager.getProjects().size()+ " Projekte registriert.");
                    return true;
                } else {
                    p.sendMessage(prefix+"Bitte benutze: §e/battleapi <showPermissions, version>");
                    return true;
                }
            } else {
                p.sendMessage(prefix+"Bitte benutze: §e/battleapi <showPermissions, version>");
                return true;
            }
        } else {
            p.sendMessage(prefix+"§eBattleAPI v1, es sind "+ PermissionManager.getProjects().size()+ " Projekte registriert.");
            return false;
        }
    }
}
