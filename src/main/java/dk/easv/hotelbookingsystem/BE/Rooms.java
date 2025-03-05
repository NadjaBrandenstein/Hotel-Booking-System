package dk.easv.hotelbookingsystem.BE;

public class Rooms {

    private int roomNumber;
    private String roomType;
    private Double price;
    private boolean isAvailable;

    public Rooms(int roomNumber, String roomType, Double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    public Rooms(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public Rooms(int roomNumber, String type, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = type;
        this.price = price;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }


}
