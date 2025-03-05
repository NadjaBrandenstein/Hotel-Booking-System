package dk.easv.hotelbookingsystem.BLL.Manager;

import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.DAL.DAO_DB.RoomDAO_DB;

import java.io.IOException;
import java.util.List;

public class RoomManager {

    private RoomDAO_DB roomDAO;

    public RoomManager() throws IOException {
        roomDAO = new RoomDAO_DB();
    }

    private Rooms addRoom(Rooms room) throws Exception{

        return roomDAO.addRoom(room);
    }

    private Rooms updateRoom(Rooms room) throws Exception{
        return roomDAO.updateRoom(room);
    }

    private List<Rooms> getAllRooms() throws Exception{
        return roomDAO.getAllRooms();
    }

    private void deleteRoom(int id) throws Exception{
        roomDAO.deleteRoom(id);
    }

    boolean isRoomAvailable(int roomNumber) throws Exception{
        return roomDAO.isRoomAvailable(roomNumber);
    }
}
