package tk.brutalmaster9854.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQL implements Database {

    private String ip, database, user, pass;
    private int port;
    private Connection connection;

    public MySQL(String ip, int port, String database, String user, String pass) {

        this.ip = ip;
        this.port = port;
        this.database = database;
        this.user = user;
        this.pass = pass;
    }
    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void openConnection() {

        try {
            connection = DriverManager.getConnection("jdbc://" + ip + ":" + port + "/" + database, user, pass);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void closeConnection() {

        try {
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public PreparedStatement createStatement(String sql) {

        try {
            connection.prepareStatement(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
