package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    // Replace these values with your Sequel Pro/MySQL database information
    private static final String URL = "jdbc:mysql://mariadb.qa.engati.local:3306/botengage"; // e.g., "jdbc:mysql://localhost:3306/test_db"
    private static final String USER = "bteng_user"; // Your database username
    private static final String PASSWORD = "bt!nrdr!$e"; // Your database password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static int executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}