package de.battlesucht.api.utils.events;

import de.battlesucht.api.utils.player.BattlePlayer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(e.getPlayer().hasPermission("refluxo.chat.color")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('§', new BattlePlayer(e.getPlayer()).getPrefix()) + e.getPlayer().getName() + ": " + ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        } else {
            e.setFormat(ChatColor.translateAlternateColorCodes('§', new BattlePlayer(e.getPlayer()).getPrefix()) + e.getPlayer().getName() + ": " + e.getMessage());
        }
    }

}
