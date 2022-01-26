package entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plateNumber", nullable = false, length = 17)
    private String plateNumber;
    private String make;
    private String model;
    private int modelYear;
    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;

    @OneToOne
    private User user;

    public Car() {
    }

    public Car(String plateNumber, String model, String make, int modelYear) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.make = make;
        this.modelYear = modelYear;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        if (booking != null) {
            booking.setCar(this);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
