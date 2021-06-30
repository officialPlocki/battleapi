package de.battlesucht.api.utils.events;

import de.battlesucht.api.utils.player.BattlePlayer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import yclans.api.yClansAPI;
import yclans.model.Clan;
import yclans.model.ClanPlayer;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(e.getPlayer().hasPermission("battleapi.chat.color")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('§', new BattlePlayer(e.getPlayer()).getSuffix() + " " + new BattlePlayer(e.getPlayer()).getPrefix()) + e.getPlayer().getName() + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        } else {
            e.setFormat(ChatColor.translateAlternateColorCodes('§', new BattlePlayer(e.getPlayer()).getSuffix() + " " + new BattlePlayer(e.getPlayer()).getPrefix()) + e.getPlayer().getName() + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + e.getMessage());
        }
    }

}
