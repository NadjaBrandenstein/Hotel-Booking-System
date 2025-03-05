package dk.easv.hotelbookingsystem.GUI.Controller;

import dk.easv.hotelbookingsystem.Main;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
    private void btnBooking(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/Booking.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        Stage stage = new Stage();
        stage.setTitle("Hotel Management System - Overview");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void btnCustomer(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 430);
        Stage stage = new Stage();
        stage.setTitle("Hotel Management System - Overview");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnCheckIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/CheckInOut.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Hotel Management System - Overview");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnLogOut(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void btnCheckOut(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/CheckInOut.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Hotel Management System - Overview");
        stage.setScene(scene);
        stage.show();
    }


}