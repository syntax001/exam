package entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String primaryLanguage;
    private int yrsOfExperience;
    private double hourlyWage;

    @ManyToMany
    private List<Booking> bookings;

    public Assistant() {
    }

    public Assistant(String name, String primaryLanguage, int yrsOfExperience, double hourlyWage) {
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yrsOfExperience = yrsOfExperience;
        this.hourlyWage = hourlyWage;
        this.bookings = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public int getYrsOfExperience() {
        return yrsOfExperience;
    }

    public void setYrsOfExperience(int yrsOfExperience) {
        this.yrsOfExperience = yrsOfExperience;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
