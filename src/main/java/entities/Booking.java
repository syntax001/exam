package entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Date creationDate;
    private int durationInMinutes;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    @ManyToMany(mappedBy = "bookings")
    private List<Assistant> assistants;

    public Booking() {
    }

    public Booking(int durationInMinutes) {
        this.creationDate = new Date();
        this.durationInMinutes = durationInMinutes;
        this.assistants = new ArrayList<>();
    }

    public void addAssistant(Assistant assistant) {
        if (assistant != null) {
            this.assistants.add(assistant);
            assistant.getBookings().add(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Assistant> assistants) {
        this.assistants = assistants;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
