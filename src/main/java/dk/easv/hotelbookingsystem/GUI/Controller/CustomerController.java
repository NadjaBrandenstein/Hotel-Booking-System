package dk.easv.hotelbookingsystem.GUI.Controller;

// other imports
import io.github.palexdev.materialfx.controls.MFXTextField;

// Javafx Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private void btnSave(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
    }

    @FXML
    private void btnBack(ActionEvent actionEvent) {
    }

    @FXML
    private void btnNew(ActionEvent actionEvent) {
    }

    @FXML
    private void btnEdit(ActionEvent actionEvent) {
    }

    @FXML
    private void btnDelete(ActionEvent actionEvent) {

    }
}
