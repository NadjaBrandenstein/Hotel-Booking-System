package dk.easv.hotelbookingsystem.GUI.Controller;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NewCustomerController {
    @FXML
    private MFXTextField txtFName;
    @FXML
    private MFXTextField txtLName;
    @FXML
    private MFXTextField txtPhoneNo;
    @FXML
    private MFXTextField txtEmail;
    @FXML
    private MFXTextField txtAddress;
    @FXML
    private MFXTextField txtPostalCode;
    @FXML
    private MFXTextField txtCountry;
    @FXML
    private MFXTextField txtCity;

    @FXML
    private void btnSave(ActionEvent actionEvent) {

    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
    }
}
