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

    // Model instance
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

        // Load the initial booking grid
        dpDatePicker.setValue(LocalDate.now()); // Set default date
        generateBookingGrid(LocalDate.now());

        // Update grid when DatePicker changes
        dpDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                generateBookingGrid(newDate);
            }
        });
    }

    private void generateBookingGrid(LocalDate startDate) {
        calendarGrid.getChildren().clear(); // Clear old data
        calendarGrid.getColumnConstraints().clear(); // Clear column constraints

        List<Rooms> rooms = bookingModel.getRooms();

        // Set up column constraints for even spacing
        ColumnConstraints roomColumn = new ColumnConstraints();
        roomColumn.setMinWidth(100); // Set fixed width for the Room No column
        roomColumn.setHgrow(Priority.NEVER); // Prevent resizing
        calendarGrid.getColumnConstraints().add(roomColumn);

        for (int day = 0; day < 5; day++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMinWidth(120); // Ensures equal column spacing
            column.setHgrow(Priority.ALWAYS); // Allow resizing
            calendarGrid.getColumnConstraints().add(column);
        }

        // Generate column headers (dates)
        for (int day = 0; day < 5; day++) {
            LocalDate currentDate = startDate.plusDays(day);
            Label dateLabel = new Label(currentDate.toString());

            // Wrap in HBox to properly space it
            HBox labelContainer = new HBox(dateLabel);
            labelContainer.setMinWidth(120);
            labelContainer.setAlignment(Pos.CENTER);

            dateLabel.setTextAlignment(TextAlignment.CENTER);
            calendarGrid.add(labelContainer, day + 1, 0); // Add to first row
        }

        // Populate the grid with room booking statuses
        for (int row = 0; row < rooms.size(); row++) {
            Rooms room = rooms.get(row);

            // Add room number in the first column
            Label roomLabel = new Label("Room " + room.getRoomNumber());
            GridPane.setMargin(roomLabel, new Insets(5, 5, 5, 5)); // Adds spacing
            calendarGrid.add(roomLabel, 0, row + 1);

            for (int day = 0; day < 5; day++) {
                LocalDate currentDate = startDate.plusDays(day);

                // Placeholder: Replace with actual booking data check
                boolean isBooked = Math.random() > 0.5; // Simulated random booking

                Rectangle cell = new Rectangle(100, 40, isBooked ? Color.RED : Color.LIGHTGREEN);
                cell.setStroke(Color.BLACK);
                cell.setArcWidth(5);
                cell.setArcHeight(5);
                GridPane.setMargin(cell, new Insets(5, 5, 5, 5)); // Adds consistent spacing
                calendarGrid.add(cell, day + 1, row + 1);
            }
        }
    }
}
