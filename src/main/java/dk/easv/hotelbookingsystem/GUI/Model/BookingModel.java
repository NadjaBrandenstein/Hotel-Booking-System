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
        rooms.add(new Rooms(1));
        rooms.add(new Rooms(2));
        rooms.add(new Rooms(3));
        rooms.add(new Rooms(4));
        rooms.add(new Rooms(5));
        rooms.add(new Rooms(6));
        rooms.add(new Rooms(7));
        rooms.add(new Rooms(8));
        rooms.add(new Rooms(9));
        rooms.add(new Rooms(10));
        rooms.add(new Rooms(11));
        rooms.add(new Rooms(12));
        rooms.add(new Rooms(13));
        rooms.add(new Rooms(14));
        rooms.add(new Rooms(15));
        rooms.add(new Rooms(16));
        rooms.add(new Rooms(17));
        rooms.add(new Rooms(18));
        rooms.add(new Rooms(19));
        rooms.add(new Rooms(20));





    }
}
