package dk.easv.hotelbookingsystem.DAL.Interface;

import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.BE.Rooms;

import java.util.List;

public interface ICustomer {


    Customer createCustomer(Customer customer) throws Exception;
    List<Customer> getAllCustomers()throws Exception;
    Customer updateCustomer (Customer customer) throws Exception;
    void deleteCustomer(Customer customer)throws Exception;
}
