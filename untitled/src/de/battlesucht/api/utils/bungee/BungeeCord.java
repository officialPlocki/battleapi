package de.battlesucht.api.utils.bungee;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.battlesucht.api.BattleAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeeCord {

    public BungeeCord() {}

    public void sendPlayer(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(player.getPlayer().getName());
        out.writeUTF(server);
        Bukkit.getServer().sendPluginMessage(BattleAPI.getInstance(), "BungeeCord", out.toByteArray());
    }

    public void kickPlayer(Player player, String message) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("KickPlayer");
        out.writeUTF(player.getPlayer().getName());
        out.writeUTF(message);
        Bukkit.getServer().sendPluginMessage(BattleAPI.getInstance(), "BungeeCord", out.toByteArray());
    }

}
