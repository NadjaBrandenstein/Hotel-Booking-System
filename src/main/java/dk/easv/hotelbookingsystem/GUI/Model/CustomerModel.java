package dk.easv.hotelbookingsystem.GUI.Model;

import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.BLL.Manager.CustomerManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CustomerModel {

    private CustomerManager customerManager;
    private ObservableList<Customer> tblCustomers;

    public CustomerModel() throws Exception {
        customerManager = new CustomerManager();
        tblCustomers = FXCollections.observableArrayList();
        tblCustomers.addAll(customerManager.getAllCustomers()); // Load customers here
    }

    public ObservableList<Customer> getTblCustomers() {
        return tblCustomers;
    }


    public Customer addCustomer(Customer customer) throws Exception {
        Customer createdCustomer = customerManager.createCustomer(customer);
        tblCustomers.add(createdCustomer);
        return createdCustomer;
    }

    public void createCustomer(Customer customer) throws Exception {
        customerManager.createCustomer(customer);
    }



    /*public void updateCustomer(Customer customer) throws Exception {
        customerManager.updateCustomer(customer);

        for(int i = 0; i < tblCustomers.size(); i++) {
            if(tblCustomers.get(i).getId() == customer.get()) {
                tblCustomers.set(i, customer);
                break;
            }
        }
    }*/


}
