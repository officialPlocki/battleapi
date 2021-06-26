package de.battlesucht.api.utils.mysql;

import de.battlesucht.api.utils.server.Console;
import de.battlesucht.api.utils.server.ConsoleClassType;

import java.sql.*;

public class MySQLService {
    public static Connection con;
    public static void connect(String host, String user, String database, String password, String port){
        if(isConnected()){
            new Console("MySQL ist bereits verbunden.", ConsoleClassType.MySQL);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password + "&autoReconnect=true");
        } catch (SQLException throwables) {
            new Console(throwables.getMessage(), ConsoleClassType.MySQL);
        }
    }

    public static void setMaxConnections() {
        try {
            PreparedStatement st = con.prepareStatement("SET GLOBAL MAX_CONNECTIONS = 500");
            st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void disconnect(){
        if(isConnected()){
            try {
                con.close();
            } catch (SQLException throwables) {
                new Console(throwables.getMessage(), ConsoleClassType.MySQL);
            }
        } else {
            new Console("MySQL ist nicht verbunden.", ConsoleClassType.MySQL);
        }
    }
    public static boolean isConnected(){
        return (con ==null ? false : true);
    }

    public MySQLService() {}

    private PreparedStatement ps;

    public PreparedStatement prepareStatement(String sql) {
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            new Console(throwables.getMessage(), ConsoleClassType.MySQL);
        }
        return ps;
    }

    public MySQLService updateStatement(PreparedStatement preparedStatement) {
        ps = preparedStatement;
        return this;
    }

    public ResultSet getResult() {
        try {
            return ps.executeQuery();
        } catch (SQLException throwables) {
            new Console(throwables.getMessage(), ConsoleClassType.MySQL);
        }
        return null;
    }

    public void executeUpdate() {
        try {
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
