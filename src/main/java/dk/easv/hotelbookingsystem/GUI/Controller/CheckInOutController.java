package dk.easv.hotelbookingsystem.GUI.Controller;

// other import
import dk.easv.hotelbookingsystem.BE.Customer;
import dk.easv.hotelbookingsystem.GUI.Model.CustomerModel;
import dk.easv.hotelbookingsystem.GUI.Model.RoomModel;
import io.github.palexdev.mfxcore.controls.Label;

// JavaFX Import
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckInOutController implements Initializable {

    // JavaFX Instance Fields
    @FXML
    private Label lblName;
    @FXML
    private Label lblPhoneNo;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPostalCode;
    @FXML
    private Label lblCity;
    @FXML
    private Label lblRoomNo;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblCounrty;

    // Other Instance Fields
    private CustomerModel customerModel;
    private RoomModel roomModel;


    public CheckInOutController() {
        customerModel = new CustomerModel();
        roomModel = new RoomModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblName.setText(lblName.getText());
        lblPhoneNo.setText(lblPhoneNo.getText());
        lblEmail.setText(lblEmail.getText());
        lblAddress.setText(lblAddress.getText());
        lblPostalCode.setText(lblPostalCode.getText());
        lblCity.setText(lblCity.getText());
        lblRoomNo.setText(lblRoomNo.getText());
        lblPrice.setText(lblPrice.getText());
        lblCounrty.setText(lblCounrty.getText());
    }

    @FXML
    private void dropCustomer(ActionEvent actionEvent) {
    }

    @FXML
    private void dropRoom(ActionEvent actionEvent) {
    }

    @FXML
    private void dpCheckIn(ActionEvent actionEvent) {
    }

    @FXML
    private void dpCheckOut(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCheck(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }



}
