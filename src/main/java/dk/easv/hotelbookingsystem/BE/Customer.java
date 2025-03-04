package dk.easv.hotelbookingsystem.BE;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String adress;
    private int postalCode;
    private String city;
    private String Country;


    public Customer(int customerId, String firstName, String lastName, String email, String phoneNumber, String adress,int postalCode, String city, String country) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.postalCode = postalCode;
        this.city = city;
        Country = country;
    }

    public Customer(int id, String firstName, String lastName) {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public int getId() {
        return customerId;
    }
}
