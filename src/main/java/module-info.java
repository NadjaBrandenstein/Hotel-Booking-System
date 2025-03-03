module dk.easv.hotelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.hotelbookingsystem to javafx.fxml;
    exports dk.easv.hotelbookingsystem;
}