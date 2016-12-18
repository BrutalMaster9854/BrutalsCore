package tk.brutalmaster9854.core.database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Database {

    Connection getConnection();

    void openConnection();

    void closeConnection();

    PreparedStatement createStatement(String sql);

    ResultSet query(String sql);
}
