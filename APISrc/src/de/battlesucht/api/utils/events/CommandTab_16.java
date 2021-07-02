package de.battlesucht.api.utils.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class CommandTab_16 implements Listener {

    @EventHandler
    public void onTab(PlayerChatTabCompleteEvent e) {
        if(!e.getPlayer().hasPermission("battleapi.command.tab.bypass")) {
            e.getTabCompletions().clear();
            for(Player p : Bukkit.getOnlinePlayers()) {
                e.getTabCompletions().add(p.getName());
            }
        }
    }

}
