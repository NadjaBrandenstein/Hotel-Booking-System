package dk.easv.hotelbookingsystem.GUI.Model;

import dk.easv.hotelbookingsystem.BE.Booking;
import dk.easv.hotelbookingsystem.BE.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingModel {

    private ObservableList<Rooms> rooms;


    public BookingModel(){
        rooms = FXCollections.observableArrayList();
    }

    public ObservableList<Rooms> getRooms() {
        return rooms;
    }
}
