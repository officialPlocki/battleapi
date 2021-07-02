package de.battlesucht.api.utils.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class CommandTab_b12 implements Listener {

    @EventHandler
    public void onTab(TabCompleteEvent e) {
        if(!e.getSender().hasPermission("battleapi.command.tab.bypass")) {
            e.setCancelled(true);
        }
    }
}
