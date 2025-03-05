package dk.easv.hotelbookingsystem.GUI.Controller;

import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.GUI.Model.BookingModel;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    // JavaFX UI Elements
    @FXML
    private TableView<Rooms> tblRoom;
    @FXML
    private TableColumn<Rooms, Integer> colRoomNo;
    @FXML
    private Label lblSelectDate;
    @FXML
    private MFXDatePicker dpDatePicker;
    @FXML
    private GridPane calendarGrid;

    // Other instance
    private BookingModel bookingModel;

    public BookingController() {
        bookingModel = new BookingModel();
        calendarGrid = new GridPane();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TableView setup
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tblRoom.setItems(bookingModel.getRooms());

        // Other UI setup
        lblSelectDate.setText("Select date");

        dpDatePicker.setValue(LocalDate.now());
        generateBookingGrid(LocalDate.now());

        dpDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                generateBookingGrid(newDate);
            }
        });
    }

    private void generateBookingGrid(LocalDate startDate) {
        calendarGrid.getChildren().clear();
        calendarGrid.getColumnConstraints().clear();

        List<Rooms> rooms = bookingModel.getRooms();


        ColumnConstraints roomColumn = new ColumnConstraints();
        roomColumn.setMinWidth(100);
        roomColumn.setHgrow(Priority.NEVER);
        calendarGrid.getColumnConstraints().add(roomColumn);

        for (int day = 0; day < 10; day++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMinWidth(100);
            column.setHgrow(Priority.ALWAYS);
            calendarGrid.getColumnConstraints().add(column);
        }

        for (int day = 0; day < 10; day++) {
            LocalDate currentDate = startDate.plusDays(day);
            Label dateLabel = new Label(currentDate.toString());


            HBox labelContainer = new HBox(dateLabel);
            labelContainer.setMinWidth(125);
            labelContainer.setAlignment(Pos.CENTER);

            dateLabel.setTextAlignment(TextAlignment.CENTER);
            calendarGrid.add(labelContainer, day + 1, 0);
        }


        for (int row = 0; row < rooms.size(); row++) {
            Rooms room = rooms.get(row);


            //Label roomLabel = new Label("Room " + room.getRoomNumber());
            //GridPane.setMargin(roomLabel, new Insets(5, 0, 5, 0));
            //calendarGrid.add(roomLabel, 0, row + 1);

            for (int day = 0; day < 10; day++) {
                LocalDate currentDate = startDate.plusDays(day);


                boolean isBooked = Math.random() > 0.5;

                Rectangle cell = new Rectangle(100, 40, isBooked ? Color.RED : Color.LIGHTGREEN);
                cell.setStroke(Color.BLACK);
                cell.setArcWidth(5);
                cell.setArcHeight(5);
                GridPane.setMargin(cell, new Insets(0, 0, 0, 0));
                calendarGrid.add(cell, day + 1, row + 1);
            }
        }
    }
}
