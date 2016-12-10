package tk.brutalmaster9854.core.database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public interface Database {

    abstract Connection getConnection();

    abstract void openConnection();

    abstract void closeConnection();

    abstract PreparedStatement createStatement(String sql);
}
