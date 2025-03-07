package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;
import dk.easv.hotelbookingsystem.DAL.Interface.ICustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO_DB implements ICustomer {
    private final DBConnection dbConnection;

    public CustomerDAO_DB(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Customer createCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO customer (FirstName, LastName, Email, PhoneNo, Adress, PostalCode,City,Country) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setInt(4, customer.getPhoneNumber());
            stmt.setString(5, customer.getAddress());
            stmt.setInt(6,customer.getPostalCode());
            stmt.setString(7, customer.getCity());
            stmt.setString(8, customer.getCountry());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                return new Customer(customer.getFirstName(), customer.getLastName(),customer.getEmail(),customer.getPhoneNumber(),customer.getAddress(),customer.getPostalCode(),customer.getCity(),customer.getCountry());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Customer";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                System.out.println("Fetched CustomerID: " + id);
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email = rs.getString("Email");
                int phoneNumber = rs.getInt("PhoneNo");
                String address = rs.getString("Adress");
                int postalCode = Integer.parseInt(rs.getString("PostalCode"));
                String city = rs.getString("City");
                String country = rs.getString("Country");

                Customer customer = new Customer(id,firstName,lastName,email,phoneNumber,address,postalCode,city,country);
                allCustomers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }


    public Customer updateCustomer (Customer customer) throws Exception{
        String sql = "UPDATE Customer SET (FirstName = ?, LastName = ?, Email = ?, PhoneNo = ?,  Adress = ?, PostalCode = ?, City = ?, Country = ?) WHERE CustomerID = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getEmail());
            stmt.setInt(5, customer.getPhoneNumber());
            stmt.setString(6, customer.getAddress());
            stmt.setInt(7,customer.getPostalCode());
            stmt.setString(8, customer.getCity());
            stmt.setString(9, customer.getCountry());


            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer)throws Exception{
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customer.getCustomerId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

