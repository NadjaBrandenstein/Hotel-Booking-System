package dk.easv.hotelbookingsystem.BLL.Manager;

import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.DAL.DAO_DB.CustomerDAO_DB;
import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;

import java.io.IOException;
import java.util.List;

public class CustomerManager {
    private CustomerDAO_DB customerDAODb;

    public CustomerManager() throws Exception {
        DBConnection dbConnection = new DBConnection();
        customerDAODb = new CustomerDAO_DB(dbConnection);
    }


    public List<Customer> getAllCustomers() throws Exception {
        return customerDAODb.getAllCustomers();
    }

    public Customer getCustomerById(int id) throws Exception {
        return customerDAODb.getCustomerById(id);
    }
    public Customer createCustomer(Customer customer) throws Exception{
        return customerDAODb.createCustomer(customer);
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        return customerDAODb.updateCustomer(customer);
    }

    public Customer deleteCustomer(int id) throws Exception {
        return customerDAODb.deleteCustomer(id);
    }


}
