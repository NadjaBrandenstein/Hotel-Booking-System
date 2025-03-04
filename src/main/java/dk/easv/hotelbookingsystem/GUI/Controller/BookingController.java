package dk.easv.hotelbookingsystem.GUI.Controller;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class BookingController {
    @FXML
    private TableView tblRoom;
    @FXML
    private TableColumn colRoomNo;
    @FXML
    private Label lblSelectDate;
    @FXML
    private MFXDatePicker dpDatePicker;
    @FXML
    private GridPane calendarGrid;
}
