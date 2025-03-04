package dk.easv.hotelbookingsystem.GUI.Controller;

import dk.easv.hotelbookingsystem.Main;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private MFXTextField txtUsername;
    @FXML
    private MFXPasswordField txtPassword;


    @FXML
    private void btnSave(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/Customer.fxml"));
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