package de.battlesucht.api.utils.server;

import org.bukkit.Bukkit;

public class VersionChecker {

    public static String getVersion() {
        if(Bukkit.getVersion().contains("8")) {
            return "1.8";
        } else {
            return "1.16";
        }
    }

}
