package dk.easv.hotelbookingsystem.GUI.Controller;

// Project Imports
import dk.easv.hotelbookingsystem.Main;

// other imports
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;

// javafx import
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// Java Imports
import java.io.IOException;

public class LoginController {
    @FXML
    private MFXTextField txtUsername;
    @FXML
    private MFXPasswordField txtPassword;


    @FXML
    private void btnSave(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/Overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        Stage stage = new Stage();
        stage.setTitle("Hotel Management System - Overview");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {

    }
}