package dk.easv.hotelbookingsystem.GUI;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    private void btnSave(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
    }
}
