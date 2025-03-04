package dk.easv.hotelbookingsystem.BE;

public class Rooms {

    private int roomNumber;
    private String roomType;

    public Rooms(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
