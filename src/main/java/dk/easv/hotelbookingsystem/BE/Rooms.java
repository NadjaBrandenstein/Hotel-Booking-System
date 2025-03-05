package dk.easv.hotelbookingsystem.BE;

public class Rooms {

    private int roomNumber;
    private String roomType;
    private Double price;

    public Rooms(int roomNumber, String roomType, Double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    public Rooms(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public Rooms(int id, int roomNumber, String type, double price, boolean isAvailable) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }

    public String getType() {
        return roomType;
    }

    public boolean isAvailable() {
        return roomNumber > 0;
    }

    public void setId(int anInt) {
        roomNumber = anInt;
    }

    public int getId() {
        return roomNumber;
    }
}
