package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;
import dk.easv.hotelbookingsystem.DAL.Interface.ILogin;

import java.io.IOException;
import java.sql.*;

public class LoginDAO_DB implements ILogin {
    private static final String URL = "jdbc:mysql://localhost:3306/hotelbookingsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    private DBConnection dbConnection = new DBConnection();

    public LoginDAO_DB() throws IOException {

    }

    public boolean validateLogin(String username, String password) throws Exception {
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

    public String getUserRole(String username) throws Exception {
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
        return getUserRole(username);
    }



}
