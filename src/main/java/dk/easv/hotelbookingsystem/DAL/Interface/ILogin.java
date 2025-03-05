package dk.easv.hotelbookingsystem.DAL.Interface;

public interface ILogin {

    boolean validateLogin(String username, String password) throws Exception;
    String getUserRole(String username) throws Exception;


}
