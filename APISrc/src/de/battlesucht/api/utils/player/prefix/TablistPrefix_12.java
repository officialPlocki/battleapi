package de.battlesucht.api.utils.player.prefix;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TablistPrefix_12 {

    private static TablistPrefix_12 instance;

    public static TablistPrefix_12 getInstance() {
        if(instance == null) {
            instance = new TablistPrefix_12();
        }
        return instance;
    }

    private Scoreboard scoreboard;
    private HashMap<UUID, String> teams;

    public TablistPrefix_12() {
        scoreboard = new Scoreboard();
        teams = new HashMap<>();
    }

    public void registerTeam(Player p, String prefix, EnumChatFormat color, String suffix, int level) {
        String s = level + p.getUniqueId().toString().substring(3,6);
        if(scoreboard.getTeam(s) != null) {
            scoreboard.removeTeam(scoreboard.getTeam(s));
        }
        ScoreboardTeam team = scoreboard.createTeam(s);
        team.setColor(color);
        team.setPrefix(prefix);
        team.setSuffix(suffix);

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
            cp.getHandle().playerConnection.networkManager.sendPacket(packet);
        }
    }

}
