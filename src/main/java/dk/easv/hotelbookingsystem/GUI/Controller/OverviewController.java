package dk.easv.hotelbookingsystem.GUI.Controller;

import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OverviewController {


    @FXML
    private MFXTextField txtSearch;
    @FXML
    private Label lblUser;


    // TableView customer
    @FXML
    private ScrollPane spCustomer;
    @FXML
    private TableView tblCustomer;
    @FXML
    private TableColumn colFName;
    @FXML
    private TableColumn colLName;
    @FXML
    private TableColumn colPhoneNo;
    @FXML
    private TableColumn colEmail;

    // TableView Rooms
    @FXML
    private ScrollPane spRoom;
    @FXML
    private TableView tblRoom;
    @FXML
    private TableColumn colRoomNo;
    @FXML
    private TableColumn colRoomSize;
    @FXML
    private TableColumn colPrice;
    @FXML
    private TableColumn colAvailable;
    @FXML
    private Label lblName;


    @FXML
    private void btnLogout(ActionEvent actionEvent) {
    }

    @FXML
    private void btnNew(ActionEvent actionEvent) {
    }

    public void btnEdit(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    @FXML
    private void btnBooking(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCustomer(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCheckIn(ActionEvent actionEvent) {
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent) {
    }

    @FXML
    private void btnCheckOut(ActionEvent actionEvent) {

    }
}
