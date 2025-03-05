package dk.easv.hotelbookingsystem.BLL.Manager;

import dk.easv.hotelbookingsystem.DAL.DAO_DB.RoomDAO_DB;

public class RoomManager {

    private RoomDAO_DB roomDAO;

    public RoomManager() {
        roomDAO = new RoomDAO_DB()
    }
}
