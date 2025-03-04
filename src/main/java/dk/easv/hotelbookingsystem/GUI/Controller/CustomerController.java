package dk.easv.hotelbookingsystem.GUI.Controller;

// other imports
import dk.easv.hotelbookingsystem.BE.Customer;
import io.github.palexdev.materialfx.controls.MFXTextField;

// Javafx Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
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
    private TableView tblCustomer;
    @FXML
    private TableColumn colCustomerID;
    @FXML
    private TableColumn colLName;
    @FXML
    private TableColumn colFName;
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
