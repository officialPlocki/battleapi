package de.battlesucht.api.utils.events;

import de.battlesucht.api.BattleAPI;
import de.battlesucht.api.utils.player.BattlePlayer;
import de.battlesucht.api.utils.player.prefix.TablistPrefix_12;
import de.battlesucht.api.utils.player.prefix.TablistPrefix_16;
import de.battlesucht.api.utils.player.prefix.TablistPrefix_8;
import de.battlesucht.api.utils.server.VersionChecker;
import de.battlesucht.api.utils.server.global.BitsAPI;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        BitsAPI.validateJoin(e.getPlayer());
        CoinsAPI.getCoins(e.getPlayer());
        BattlePlayer bp = new BattlePlayer(e.getPlayer());
        if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
            TablistPrefix_16.getInstance().registerTeam(e.getPlayer(), bp.getPrefix(), bp.getNameColor16(), bp.getSuffix(), bp.getTablistHeight());
        } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
            TablistPrefix_12.getInstance().registerTeam(e.getPlayer(), bp.getPrefix(), bp.getNameColor12(), bp.getSuffix(), bp.getTablistHeight());
        } else if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
            TablistPrefix_8.getInstance().registerTeam(e.getPlayer(), bp.getPrefix(), bp.getNameColor8(), bp.getSuffix(), bp.getTablistHeight());
        }
    }

}
