package dk.easv.hotelbookingsystem.DAL.Interface;

import dk.easv.hotelbookingsystem.BE.Customer;

public interface ICustomer {


    Customer createCustomer(Customer customer) throws Exception;
    Customer getCustomerById(int id) throws Exception;
    Customer updateCustomer (Customer customer) throws Exception;
    void deleteCustomer(int id) throws Exception;
}
