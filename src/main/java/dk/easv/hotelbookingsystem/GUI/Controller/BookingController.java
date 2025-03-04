package dk.easv.hotelbookingsystem.GUI.Controller;

import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.GUI.Model.BookingModel;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    // JavaFX Instance Fields
    @FXML
    private TableView<Rooms> tblRoom;
    @FXML
    private TableColumn<Rooms,Integer> colRoomNo;
    @FXML
    private Label lblSelectDate;
    @FXML
    private MFXDatePicker dpDatePicker;
    @FXML
    private GridPane calendarGrid;


    // instance fields

    private BookingModel bookingModel;

    public BookingController() {
        bookingModel = new BookingModel();

        calendarGrid = new GridPane();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // TableView
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tblRoom.setItems(bookingModel.getRooms());


        // Other
        lblSelectDate.setText("Select date");

        dpDatePicker.getCurrentDate();

        calendarGrid.add(lblSelectDate, 0, 0);
    }
}
