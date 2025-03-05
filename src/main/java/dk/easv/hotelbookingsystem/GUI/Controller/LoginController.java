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
    private void btnLogIn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dk/easv/hotelbookingsystem/FXML/FXML/Overview.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Hotel Management System - Overview");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }

    @FXML
    private void btnCancel(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

}