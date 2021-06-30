package de.battlesucht.api.utils.player;

import de.battlesucht.api.utils.server.VersionChecker;
import de.battlesucht.api.utils.server.global.BitsAPI;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import yclans.api.yClansAPI;
import yclans.model.ClanPlayer;

public class BattlePlayer {

    private Player player;

    private String prefix;
    private String suffix;
    private int height;
    private net.minecraft.server.v1_12_R1.EnumChatFormat enumChatFormat12;
    private net.minecraft.server.v1_8_R3.EnumChatFormat enumChatFormat8;
    private net.minecraft.server.v1_16_R3.EnumChatFormat enumChatFormat16;

    public BattlePlayer(Player p) {
        yClansAPI clans = yClansAPI.yclansapi;
        ClanPlayer cp = clans.getPlayer(p);
        String clan = cp.getClanTag();
        suffix = "";
        if(clan != null || !clan.contains("none") || !clan.contains("null") || !clan.contains("[null]")) {
            suffix = ChatColor.GRAY+"["+ChatColor.GOLD+clan+ChatColor.GRAY+"]";
        }
        this.player = p;
        if(p.hasPermission("rank.owner")) {
            prefix = "&4Owner &8┃ &4";
            height = 0;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_RED;
            }
        } else if(p.hasPermission("rank.admin")) {
            prefix = "&cAdmin &8┃ &c";
            height = 1;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_RED;
            }
        } else if(p.hasPermission("rank.dev")) {
            prefix = "&bDev &8┃ &b";
            height = 2;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.BLUE;
            }
        } else if(p.hasPermission("rank.moderator")) {
            prefix = "&aMod &8┃ &a";
            height = 4;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.RED;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.RED;
            }
        } else if(p.hasPermission("rank.supporter")) {
            prefix = "&2Sup &8┃ &2";
            height = 5;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_GREEN;
            }
        } else if(p.hasPermission("rank.builder")) {
            prefix = "&3Builder &8┃ &3";
            height = 7;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.AQUA;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.AQUA;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.AQUA;
            }
        } else if(p.hasPermission("rank.t-dev")) {
            prefix = "&bT-Dev &8┃ &b";
            height = 3;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.BLUE;
            }
        } else if(p.hasPermission("rank.tsup")) {
            prefix = "&2T-Sup &8┃ &2";
            height = 6;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_GREEN;
            }
        } else if(p.hasPermission("rank.tbuilder")) {
            prefix = "&3T-Builder &8┃ &3";
            height = 8;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.AQUA;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.AQUA;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.AQUA;
            }
        } else if(p.hasPermission("rank.youtuber")) {
            prefix = "&5YT &8┃ &5";
            height = 9;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_PURPLE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_PURPLE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_PURPLE;
            }
        } else if(p.hasPermission("rank.king")) {
            prefix = "&eKing &8┃ &e";
            height = 10;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.YELLOW;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.YELLOW;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.YELLOW;
            }
        } else if(p.hasPermission("rank.prime")) {
            prefix = "&dPrime &8┃ &d";
            height = 11;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.LIGHT_PURPLE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.LIGHT_PURPLE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.LIGHT_PURPLE;
            }
        } else if(p.hasPermission("rank.gold")) {
            prefix = "&6Gold &8┃ &6";
            height = 12;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.GOLD;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.GOLD;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.GOLD;
            }
        } else if(p.hasPermission("rank.titan")) {
            prefix = "&9Titan &8┃ &9";
            height = 13;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.DARK_BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.DARK_BLUE;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.DARK_BLUE;
            }
        } else if(p.hasPermission("rank.premium")) {
            prefix = "&aPremium &8┃ &a";
            height = 14;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.GREEN;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.GREEN;
            }
        } else {
            prefix = "&7Spieler &8┃ &7";
            height = 15;
            if(VersionChecker.getVersion().equalsIgnoreCase("1.8")) {
                enumChatFormat8 = net.minecraft.server.v1_8_R3.EnumChatFormat.GRAY;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.12")) {
                enumChatFormat12 = net.minecraft.server.v1_12_R1.EnumChatFormat.GRAY;
            } else if(VersionChecker.getVersion().equalsIgnoreCase("1.16")) {
                enumChatFormat16 = net.minecraft.server.v1_16_R3.EnumChatFormat.GRAY;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return player.getName();
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

    public String getPrefix() {
        return prefix.replaceAll("&", "§");
    }

    public String getSuffix() {
        return suffix.replaceAll("&", "§");
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix.replaceAll("&", "§");
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix.replaceAll("&", "§");
    }

    public net.minecraft.server.v1_16_R3.EnumChatFormat getNameColor16() {
        return enumChatFormat16;
    }

    public net.minecraft.server.v1_12_R1.EnumChatFormat getNameColor12() {
        return enumChatFormat12;
    }
    public net.minecraft.server.v1_8_R3.EnumChatFormat getNameColor8() {
        return enumChatFormat8;
    }
    public void setNameColor16(net.minecraft.server.v1_16_R3.EnumChatFormat enumChatFormat) {
        this.enumChatFormat16 = enumChatFormat;
    }
    public void setNameColor12(net.minecraft.server.v1_12_R1.EnumChatFormat enumChatFormat) {
        this.enumChatFormat12 = enumChatFormat;
    }
    public void setNameColor8(net.minecraft.server.v1_8_R3.EnumChatFormat enumChatFormat) {
        this.enumChatFormat8 = enumChatFormat;
    }

    public int getTablistHeight() {
        return height;
    }

    public void setTablistHeight(int height) {
        this.height = height;
    }

}
