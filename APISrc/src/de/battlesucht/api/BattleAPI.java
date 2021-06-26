package de.battlesucht.api;

import de.battlesucht.api.commands.*;
import de.battlesucht.api.commands.activateable.MoneyCommand;
import de.battlesucht.api.commands.activateable.PayCommand;
import de.battlesucht.api.utils.events.Chat;
import de.battlesucht.api.utils.events.Death;
import de.battlesucht.api.utils.events.Join;
import de.battlesucht.api.utils.events.Quit;
import de.battlesucht.api.utils.files.FileBuilder;
import de.battlesucht.api.utils.mysql.MySQLService;
import de.battlesucht.api.utils.server.Console;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import de.battlesucht.api.utils.server.local.VaultEconomy;
import de.battlesucht.api.utils.server.plugin.ListenerManager;
import de.battlesucht.api.utils.server.plugin.PermissionManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BattleAPI extends JavaPlugin {
    private static Plugin pl;

    private static FileBuilder fb;
    private static YamlConfiguration yml;

    @Override
    public void onEnable() {
        pl = this;
        fb = new FileBuilder("mysql.mcfg");
        yml = fb.getYaml();
        if(!yml.isSet("mysql.host")) {
            yml.set("mysql.host", "localhost");
            yml.set("mysql.user", "root");
            yml.set("mysql.database", "BattleAPIDataBase");
            yml.set("mysql.password", "abc123");
            yml.set("mysql.port", "3306");
            fb.save();
        }
        new ListenerManager(new Chat()).registerListener();
        new ListenerManager(new Death()).registerListener();
        new ListenerManager(new Join()).registerListener();
        new ListenerManager(new Quit()).registerListener();
        CoinsAPI.setup();
        registerEconomy();
        MySQLService service = new MySQLService();
        service.prepareStatement("CREATE TABLE IF NOT EXISTS bits(playerBits int(16), UUID varchar(36))");
        service.executeUpdate();
        MySQLService.connect(yml.getString("mysql.host"), yml.getString("mysql.user"), yml.getString("mysql.database"), yml.getString("mysql.password"), yml.getString("mysql.user"));
        if(!MySQLService.isConnected()) {
            new Console("MySQL ist nicht verbunden. API wird deaktiviert.", "BattleAPI.java");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        MySQLService.setMaxConnections();
        PermissionManager permissionManager = new PermissionManager("BattleAPI");
        permissionManager.addPermission("battleapi.cmd");
        permissionManager.addPermission("battleapi.gamemode.survival");
        permissionManager.addPermission("battleapi.gamemode.creative");
        permissionManager.addPermission("battleapi.gamemode.spectator");
        permissionManager.addPermission("battleapi.gamemode.other");
        permissionManager.addPermission("battleapi.gamemode");
        permissionManager.addPermission("battleapi.ecoadminbits");
        permissionManager.addPermission("battleapi.ecoadminmoney");
        permissionManager.build();
        if(!yml.isSet("command.activated.pay")) {
            yml.set("command.activated.pay", false);
            yml.set("command.activated.money", false);
            fb.save();
        }

        if(yml.getBoolean("command.activated.pay")) {
            getCommand("pay").setExecutor(new PayCommand());
            getCommand("zahlen").setExecutor(new PayCommand());
        }

        if(yml.getBoolean("command.activated.money")) {
            getCommand("money").setExecutor(new MoneyCommand());
            getCommand("euro").setExecutor(new MoneyCommand());
            getCommand("dollar").setExecutor(new MoneyCommand());
            getCommand("balance").setExecutor(new MoneyCommand());
            getCommand("bal").setExecutor(new MoneyCommand());
            getCommand("geld").setExecutor(new MoneyCommand());
            getCommand("bargeld").setExecutor(new MoneyCommand());
        }

        getCommand("battleapi").setExecutor(new BattleAPICommand());
        getCommand("bapi").setExecutor(new BattleAPICommand());
        getCommand("api").setExecutor(new BattleAPICommand());
        getCommand("bits").setExecutor(new BitsCommand());
        getCommand("bit").setExecutor(new BitsCommand());
        getCommand("ecoadminmoney").setExecutor(new EcoAdminMoneyCommand());
        getCommand("ecoadminbits").setExecutor(new EcoAdminBitsCommand());
        getCommand("eam").setExecutor(new EcoAdminMoneyCommand());
        getCommand("eab").setExecutor(new EcoAdminBitsCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamem").setExecutor(new GamemodeCommand());
    }

    @Override
    public void onDisable() {
        MySQLService.disconnect();
    }

    public static Plugin getInstance() {
        return pl;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void registerEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") != null) {
            final ServicesManager sm = this.getServer().getServicesManager();
            sm.register(Economy.class, new VaultEconomy(), this, ServicePriority.Highest);
        } else {
            System.out.println("Vault not found.");
        }
    }

}
