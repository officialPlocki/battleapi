package de.battlesucht.api.utils.player;

import de.battlesucht.api.utils.mysql.MySQLService;
import de.battlesucht.api.utils.server.global.BitsAPI;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class BattlePlayer {

    private Player player;

    public BattlePlayer(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return player.getName();
    }

    public String getPrefix() {
        return "";
    }

    public int getBits() {
        return BitsAPI.getBits(player);
    }

    public void addBits(int amount) {
        BitsAPI.addBits(player, amount);
    }

    public void removeBits(int amount) {
        BitsAPI.removeBits(player, amount);
    }

    public void setBits(int amount) {
        BitsAPI.setBits(player, amount);
    }

    public void resetBits() {
        BitsAPI.setBits(player, 0);
    }

    public double getCoins() {
        return CoinsAPI.getCoins(player);
    }

    public void addCoins(double amount) {
        CoinsAPI.addCoins(player, amount);
    }

    public void removeCoins(int amount) {
        CoinsAPI.removeCoins(player, amount);
    }

    public void setCoins(int amount) {
        CoinsAPI.setCoins(player, amount);
    }

    public void resetCoins() {
        CoinsAPI.setCoins(player, 0.0);
    }

    public GameMode getGameMode() {
        return player.getGameMode();
    }

    public boolean allowFlight() {
        return player.getAllowFlight();
    }

    public void setAllowFlight(boolean allow) {
        player.setAllowFlight(allow);
    }

}
