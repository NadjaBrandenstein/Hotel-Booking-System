package dk.easv.hotelbookingsystem.BLL.Manager;

import dk.easv.hotelbookingsystem.DAL.DAO_DB.LoginDAO_DB;

import java.io.IOException;
import java.sql.SQLException;

public class LoginManager {
    private LoginDAO_DB loginDAO;

    public LoginManager() throws IOException {
        loginDAO = new LoginDAO_DB();
    }

    public boolean validateLogin(String username, String password) throws Exception {
        return loginDAO.validateLogin(username, password);
    }

    public String getUserRole(String username) throws Exception {
        return loginDAO.getUserRole(username);
    }


}



