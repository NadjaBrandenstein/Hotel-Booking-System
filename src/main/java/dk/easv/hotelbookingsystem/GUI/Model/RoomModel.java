package dk.easv.hotelbookingsystem.GUI.Model;

import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.BLL.Manager.RoomManager;
import dk.easv.hotelbookingsystem.GUI.Controller.BookingController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class RoomModel {

    private RoomManager roomManager;
    private ObservableList<Rooms> tblRoom;

    public RoomModel() throws Exception {
        roomManager = new RoomManager();

        tblRoom = FXCollections.observableArrayList();
        tblRoom.addAll(roomManager.getAllRooms());
    }

    public ObservableList<Rooms> getTblRoom() {
        return tblRoom;
    }

    private Rooms addRoom(Rooms room) throws Exception{
        Rooms roomsCreated = roomManager.addRoom(room);
        tblRoom.add(roomsCreated);
        return roomsCreated;

    }

    private void updateRoom(Rooms room) throws Exception{

    }

    private List<Rooms> getAllRooms() throws Exception{
        return roomManager.getAllRooms();
    }

    private void deleteRoom(int id) throws Exception{
        roomManager.deleteRoom(id);
    }

    public boolean isRoomAvailable(int roomNumber) throws Exception{
        return roomManager.isRoomAvailable(roomNumber);
    }
}
