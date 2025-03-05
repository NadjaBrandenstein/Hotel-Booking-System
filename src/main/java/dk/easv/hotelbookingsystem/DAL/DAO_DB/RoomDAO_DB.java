package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.BE.Rooms;
import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;
import dk.easv.hotelbookingsystem.DAL.Interface.IRoom;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoomDAO_DB implements IRoom {


    private DBConnection dbConnection = new DBConnection();

    public RoomDAO_DB() throws IOException {

    }


    public Rooms addRoom(Rooms room) throws Exception {
        String sql = "INSERT INTO rooms (room_number, type, price, is_available) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getRoomType());
            stmt.setDouble(3, room.getPrice());
            stmt.setBoolean(4, room.isAvailable());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to add room");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }




    // Get all rooms
    public List<Rooms> getAllRooms() throws Exception {
        ArrayList<Rooms> allRooms = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Room";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int roomNumber = rs.getInt("RoomNo");
                String roomType = rs.getString("Room Type");
                double price = rs.getDouble("Price");
                boolean isAvailable = rs.getBoolean("Is_Available");

                Rooms rooms = new Rooms(roomNumber, roomType, price, isAvailable);
                allRooms.add(rooms);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRooms;
    }


    public void updateRoom(Rooms room) throws Exception {
        String sql = "UPDATE rooms SET type = ?, price = ?, is_available = ? WHERE room_number = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, room.getRoomType());  // Room type should be first
            stmt.setDouble(2, room.getPrice());
            stmt.setBoolean(3, room.isAvailable());
            stmt.setInt(4, room.getRoomNumber());   // Room number should be last

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int roomNumber) throws Exception {
        String sql = "DELETE FROM rooms WHERE RoomNo = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roomNumber);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean isRoomAvailable(int roomNumber) throws Exception {
        String sql = "SELECT is_available FROM rooms WHERE room_number = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roomNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("is_available");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

