package dtos;
import entities.Booking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDTO {
    private Integer id;
    private Date creationDate;
    private int durationInMinutes;
    private List<AssistantDTO> assistantDTOList;
    private CarDTO carDTO;
    private Booking booking;

    public BookingDTO(Booking booking){
        this.id = booking.getId();
        this.creationDate = booking.getCreationDate();
        this.durationInMinutes = booking.getDurationInMinutes();
        this.assistantDTOList = AssistantDTO.getDTO(booking.getAssistants());
        this.carDTO = new CarDTO(booking.getCar().getPlateNumber(), booking.getCar().getMake(), booking.getCar().getModel(), booking.getCar().getModelYear());
    }

    public BookingDTO(Date creationDate, int durationInMinutes, List<AssistantDTO> assistantDTOList, CarDTO carDTO) {
        this.creationDate = creationDate;
        this.durationInMinutes = durationInMinutes;
        this.assistantDTOList = assistantDTOList;
        this.carDTO = carDTO;
    }

    public static List<BookingDTO> getDTOs(List<Booking> bookingList) {
        List<BookingDTO> bookingDTOs = new ArrayList();
        bookingList.forEach(booking->bookingDTOs.add(new BookingDTO(booking)));
        return bookingDTOs;
    }

    public List<AssistantDTO> getAssistantDTOList() {
        return assistantDTOList;
    }

    public void setAssistantDTOList(List<AssistantDTO> assistantDTOList) {
        this.assistantDTOList = assistantDTOList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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
}
