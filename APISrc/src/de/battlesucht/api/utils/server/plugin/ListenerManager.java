package de.battlesucht.api.utils.server.plugin;

import de.battlesucht.api.BattleAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerManager {

    private Listener lis;

    public ListenerManager(Listener listener) {
        lis = listener;
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(lis, BattleAPI.getInstance());
    }

}
