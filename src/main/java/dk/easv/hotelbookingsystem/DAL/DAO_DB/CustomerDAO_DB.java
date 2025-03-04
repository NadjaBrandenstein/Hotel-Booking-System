package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;

import java.sql.*;

public class CustomerDAO_DB {
    private final DBConnection dbConnection;

    public CustomerDAO_DB(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (first_name, last_name) VALUES (?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                return new Customer(id, customer.getFirstName(), customer.getLastName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        public Customer getCustomerById(int id) {
            String sql = "SELECT * FROM Customer WHERE id = ?";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void updateCustomer (Customer customer){
            String sql = "UPDATE Customer SET name = ?, email = ?, phone = ? WHERE id = ?";
            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, customer.getName());
                stmt.setString(2, customer.getEmail());
                stmt.setString(3, customer.getPhone());
                stmt.setInt(4, customer.getId());

                stmt.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteCustomer(int id){
            String sql = "DELETE FROM Customers WHERE id = ?";

            try (Connection conn = dbConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

