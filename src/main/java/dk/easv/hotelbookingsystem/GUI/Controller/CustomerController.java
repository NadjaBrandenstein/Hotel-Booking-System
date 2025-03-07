package dk.easv.hotelbookingsystem.GUI.Controller;

// other imports
import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.GUI.Model.CustomerModel;
import io.github.palexdev.materialfx.controls.MFXTextField;

// Javafx Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private MFXTextField txtFName;
    @FXML
    private MFXTextField txtLName;
    @FXML
    private MFXTextField txtPhoneNo;
    @FXML
    private MFXTextField txtEmail;
    @FXML
    private MFXTextField txtAdress;
    @FXML
    private MFXTextField txtPostalCode;
    @FXML
    private MFXTextField txtCity;
    @FXML
    private MFXTextField txtCountry;
    @FXML
    private MFXTextField txtSearchCustomer;
    @FXML
    private ScrollPane spCustomer;
    @FXML
    private TableView<Customer> tblCustomer;
    @FXML
    private TableColumn<Customer,Integer> colCustomerID;
    @FXML
    private TableColumn<Customer,String> colLName;
    @FXML
    private TableColumn<Customer,String> colFName;
    @FXML
    private Label lblFName;
    @FXML
    private Label lblLName;
    @FXML
    private Label lblPhoneNo;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPostalCode;
    @FXML
    private Label lblCountry;
    @FXML
    private Label lblCity;


    // other Instance fields
    private CustomerModel customerModel;
    private Customer customer;

    public CustomerController() throws Exception {
        customerModel = new CustomerModel();
        customer = new Customer();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // tableView
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tblCustomer.setItems(customerModel.getTblCustomers());

        showCustomerDetails(null);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showCustomerDetails(newValue));

        // Label



    }

    private void showCustomerDetails(Customer customer){
        if(customer != null){
            lblFName.setText(customer.getFirstName());
            lblLName.setText(customer.getLastName());
            lblAddress.setText(customer.getAddress());
            lblCity.setText(customer.getCity());
            lblCountry.setText(customer.getCountry());
            lblPhoneNo.setText(String.valueOf(customer.getPhoneNumber()));
            lblEmail.setText(customer.getEmail());
            lblPostalCode.setText(String.valueOf(customer.getPostalCode()));

        }else {
            lblFName.setText(" ");
            lblLName.setText(" ");
            lblAddress.setText(" ");
            lblCity.setText(" ");
            lblCountry.setText(" ");
            lblPhoneNo.setText(" ");
            lblEmail.setText(" ");
            lblPostalCode.setText(" ");

        }
    }


    @FXML
    private void btnBack(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void btnNew(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dk/easv/hotelbookingsystem/FXML/FXML/NewCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void btnEdit(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dk/easv/hotelbookingsystem/FXML/FXML/NewCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnDelete(ActionEvent actionEvent) {

    }


}
