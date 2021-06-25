package de.battlesucht.api;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BattleAPI extends JavaPlugin {
    private static Plugin pl;

    @Override
    public void onEnable() {
        pl = this;
    }

    @Override
    public void onDisable() {

    }

    public static Plugin getInstance() {
        return pl;
    }

}
