package dk.easv.hotelbookingsystem.DAL.Interface;

import dk.easv.hotelbookingsystem.BE.Rooms;

import java.util.List;

public interface IRoom {


    void addRoom(Rooms room) throws Exception;
    void updateRoom(Rooms room) throws Exception;
    List<Rooms> getAllRooms() throws Exception;
    void deleteRoom(int id) throws Exception;
    boolean isRoomAvailable(int roomNumber) throws Exception;



}
