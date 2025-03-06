package dk.easv.hotelbookingsystem.GUI.Controller;

// project imports
import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.GUI.Model.BookingModel;
import dk.easv.hotelbookingsystem.GUI.Model.RoomModel;

// other imports
import dk.easv.hotelbookingsystem.Main;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.mfxcore.controls.Label;

// Javafx import
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

// Java imports
import java.io.IOException;
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
    private GridPane calendarGrid;
    @FXML
    private DatePicker dpDatePicker;

    // Other instance
    private BookingModel bookingModel;
    private RoomModel roomModel;

    public BookingController() throws Exception {
        bookingModel = new BookingModel();
        calendarGrid = new GridPane();
        roomModel = new RoomModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TableView setup
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tblRoom.setItems(roomModel.getTblRoom());

        // Other UI setup
        lblSelectDate.setText("Select date");


        dpDatePicker.setValue(LocalDate.now());
        try {
            generateBookingGrid(LocalDate.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        dpDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                try {
                    generateBookingGrid(newDate);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void generateBookingGrid(LocalDate startDate) throws Exception {
        calendarGrid.getChildren().clear();
        calendarGrid.getColumnConstraints().clear();
        calendarGrid.getRowConstraints().clear();

        List<Rooms> rooms = roomModel.getTblRoom();

        // Create columns for each day (first column is for room numbers)
        for (int day = 0; day <= 10; day++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMinWidth(100);
            column.setHgrow(Priority.ALWAYS);
            calendarGrid.getColumnConstraints().add(column);
        }

        // Add date labels in the first row
        for (int day = 0; day < 10; day++) {
            LocalDate currentDate = startDate.plusDays(day);
            Label dateLabel = new Label(currentDate.toString());

            HBox labelContainer = new HBox(dateLabel);
            labelContainer.setMinWidth(125);
            labelContainer.setAlignment(Pos.CENTER);
            dateLabel.setTextAlignment(TextAlignment.CENTER);

            calendarGrid.add(labelContainer, day + 1, 0);
        }

        // Populate grid with room status
        for (int row = 0; row < rooms.size(); row++) {
            Rooms room = rooms.get(row);
            int roomNo = room.getRoomNumber();

            for (int day = 0; day < 10; day++) {
                LocalDate currentDate = startDate.plusDays(day);
                boolean isBooked = roomModel.isRoomAvailable(roomNo, currentDate);

                // Create rectangle with color based on availability
                Rectangle cellBackground = new Rectangle(100, 40, isBooked ? Color.RED : Color.LIGHTGREEN);
                cellBackground.setStroke(Color.BLACK);
                cellBackground.setArcWidth(5);
                cellBackground.setArcHeight(5);

                // Label for availability status
                Label statusLabel = new Label(isBooked ? "Occupied" : "Available");
                statusLabel.setTextFill(Color.BLACK);

                // Stack both the rectangle and label
                StackPane cellContainer = new StackPane(cellBackground, statusLabel);
                cellContainer.setOnMouseClicked(event -> handleRoomClick(roomNo, currentDate, isBooked));

                calendarGrid.add(cellContainer, day, row + 1);
            }
        }
    }


    private void handleRoomClick(int roomNo, LocalDate date, boolean isBooked) {
        try {
            FXMLLoader loader;
            if (isBooked) {
                // Open check-out form if the room is occupied
                loader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/CheckInOut.fxml"));
            } else {
                // Open check-in form if the room is available
                loader = new FXMLLoader(Main.class.getResource("/dk/easv/hotelbookingsystem/FXML/FXML/CheckInOut.fxml"));
            }

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(isBooked ? "Check Out" : "Check In");
            stage.show();

            System.out.println("Opened " + (isBooked ? "Check-Out" : "Check-In") + " form for Room " + roomNo + " on " + date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
