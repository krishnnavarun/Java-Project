package service;

import util.DBConnection;
import java.sql.*;

public class LogService {
    public void logAction(String username, String action) {
        String sql = "INSERT INTO logs (username, action) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, action);
            stmt.executeUpdate();
    }
}
