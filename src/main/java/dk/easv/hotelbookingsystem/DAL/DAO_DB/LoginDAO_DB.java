package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;
import dk.easv.hotelbookingsystem.DAL.Interface.ILogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO_DB implements ILogin {
    private final DBConnection dbConnection;

    public LoginDAO_DB(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public boolean validateLogin(String username, String password) {
        String sql = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString (1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserRole(String username) throws SQLException {
        String sql = "SELECT role FROM users WHERE username = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("role");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
