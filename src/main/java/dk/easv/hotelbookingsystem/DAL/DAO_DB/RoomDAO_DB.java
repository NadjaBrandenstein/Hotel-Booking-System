package dk.easv.hotelbookingsystem.DAL.DAO_DB;

import dk.easv.hotelbookingsystem.DAL.DBConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoomDAO_DB {

    public class Room {
        private int id;
        private int roomNumber;
        private String type;
        private double price;
        private boolean isAvailable;

        public Room(int id, int roomNumber, String type, double price, boolean isAvailable) {
            this.id = id;
            this.roomNumber = roomNumber;
            this.type = type;
            this.price = price;
            this.isAvailable = isAvailable;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getRoomNumber() { return roomNumber; }
        public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public boolean isAvailable() { return isAvailable; }
        public void setAvailable(boolean available) { isAvailable = available; }
    }

    private final DBConnection dbConnection;

    public RoomDAO_DB(DBConnection dbConnection) {
        if (dbConnection == null) {
            throw new IllegalArgumentException("dbConnection is null");
        }
        this.dbConnection = dbConnection;
    }


    public void addRoom(Room room) {
        String sql = "INSERT INTO rooms (room_number, type, price, is_available) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getType());
            stmt.setDouble(3, room.getPrice());
            stmt.setBoolean(4, room.isAvailable());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to add room");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    room.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Room getRoomById(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Room(
                        rs.getInt("id"),
                        rs.getInt("room_number"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getBoolean("is_available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("id"),
                        rs.getInt("room_number"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }


    public void updateRoom(Room room) {
        String sql = "UPDATE rooms SET room_number = ?, type = ?, price = ?, is_available = ? WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getType());
            stmt.setDouble(3, room.getPrice());
            stmt.setBoolean(4, room.isAvailable());
            stmt.setInt(5, room.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(int id) {
        String sql = "DELETE FROM rooms WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean isRoomAvailable(int roomNumber) {
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

