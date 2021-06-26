package de.battlesucht.api.utils.events;

import de.battlesucht.api.utils.server.global.BitsAPI;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        BitsAPI.validateJoin(e.getPlayer());
        CoinsAPI.getCoins(e.getPlayer());
    }

}
