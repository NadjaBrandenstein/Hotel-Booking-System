package dk.easv.hotelbookingsystem.DAL.Interface;

import dk.easv.hotelbookingsystem.BE.Customer;

import java.util.List;

public interface ICustomer {

    Customer createCustomer(Customer customer) throws Exception;
    Customer getCustomerById(int id) throws Exception;
    Customer updateCustomer (Customer customer) throws Exception;
    Customer deleteCustomer(int id) throws Exception;
}
