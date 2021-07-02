package de.battlesucht.api.utils.player.prefix;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TablistPrefix_8 {

    private static TablistPrefix_8 instance;

    public static TablistPrefix_8 getInstance() {
        if(instance == null) {
            instance = new TablistPrefix_8();
        }
        return instance;
    }

    private Scoreboard scoreboard;
    private HashMap<UUID, String> teams;

    public TablistPrefix_8() {
        scoreboard = new Scoreboard();
        teams = new HashMap<>();
    }

    public void registerTeam(Player p, String prefix, EnumChatFormat color, String suffix, int level) {
        String s = level + p.getUniqueId().toString().substring(3,6);
        if(scoreboard.getTeam(s) != null) {
            scoreboard.removeTeam(scoreboard.getTeam(s));
        }
        ScoreboardTeam team = scoreboard.createTeam(s);
        team.setPrefix(prefix);
        if(!suffix.equalsIgnoreCase("")) {
            team.setSuffix(suffix);
        }
        teams.put(p.getUniqueId(), s);
        update();

    }

    private void update() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(!scoreboard.getTeam(teams.get(p.getUniqueId())).getPlayerNameSet().contains(p.getName())) {
                scoreboard.getTeam(teams.get(p.getUniqueId())).getPlayerNameSet().add(p.getName());
            }
            sendPacket(new PacketPlayOutScoreboardTeam(scoreboard.getTeam(teams.get(p.getUniqueId())), 1));
            sendPacket(new PacketPlayOutScoreboardTeam(scoreboard.getTeam(teams.get(p.getUniqueId())), 0));
        }
    }

    private void sendPacket(Packet<?> packet) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            CraftPlayer cp = (CraftPlayer) p;
            cp.getHandle().playerConnection.sendPacket(packet);
        }
    }

}
