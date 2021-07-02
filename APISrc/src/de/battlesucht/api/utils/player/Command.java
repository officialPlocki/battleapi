package de.battlesucht.api.utils.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Command implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if(e.getMessage().contains("minecraft") || e.getMessage().contains("bukkit") || e.getMessage().contains("plugins") || e.getMessage().equalsIgnoreCase("pl") || e.getMessage().contains("?") || e.getMessage().contains("tell") || e.getMessage().contains("tellraw") || e.getMessage().contains("me")) { {
                if(!e.getPlayer().hasPermission("battleapi.command.block.bypass")) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(Language.noPermissions);
                    return;
                }
                return;
            }
        } else if(e.getMessage().equalsIgnoreCase("bukkit:help") || e.getMessage().equalsIgnoreCase("bukkit:?") || e.getMessage().equalsIgnoreCase("help") || e.getMessage().equalsIgnoreCase("?")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(
                    "§8§m-----------------§b§lBATTLE§5§lSUCHT§8§m------------------\n\n"
                    + "§8» §e/p auto §8[§bErstelle dein Plot/Grundstück.§8]\n"
                    + "§8» §e/p h §7oder §e/p h [NAME] §8[§bGelange zu deinen/anderen Plots.§8]"
                    + "§8» §e/p help §8[§bHilfe über das Grundstück/Plot-System.§8]"
                    + "§8» §e/warp §8[§bWarps/Welten: Farmwelt,Nether.§8]"
                    + "§8» §e/tpa [SPIELER] §8[§bTeleportiere dich zu Spieler.§8]"
                    + "§8» §e/tpaccept §8[§bNimm die gesendete TPA an.§8]"
                    + "§8» §e/pay [BETRAG] [SPIELER] §8[§bGeld überweisen an einem Spieler.§8]"
                    + "§8» §e/baltop §8[§bUm zu sehen wer das meiste Geld hat.§8]\n\n"
                    + "§8§m-----------------§b§lBATTLE§5§lSUCHT§8§m------------------");
            return;

        }
        return;
    }

}
