package dk.easv.hotelbookingsystem.GUI.Model;

import dk.easv.hotelbookingsystem.BE.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingModel {

    private ObservableList<Rooms> rooms;

    public BookingModel() {
        rooms = FXCollections.observableArrayList();
        mockDataRooms(); 
    }

    public ObservableList<Rooms> getRooms() {
        return rooms;
    }

    public void mockDataRooms() {
        // Add mock Rooms instances
        rooms.add(new Rooms(1));
        rooms.add(new Rooms(2));
        rooms.add(new Rooms(3));
        rooms.add(new Rooms(4));
        rooms.add(new Rooms(5));
    }
}
