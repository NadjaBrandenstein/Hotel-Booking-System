module dk.easv.hotelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;


    opens dk.easv.hotelbookingsystem to javafx.fxml;
    exports dk.easv.hotelbookingsystem;
    exports dk.easv.hotelbookingsystem.GUI;
    opens dk.easv.hotelbookingsystem.GUI to javafx.fxml;
}