package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/task_manager?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // change to your MySQL user
    private static final String PASSWORD = "K.Krishnavarun@sql";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


