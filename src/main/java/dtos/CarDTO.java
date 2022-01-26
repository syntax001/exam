package dtos;
import entities.Car;
import java.util.List;

public class CarDTO {
    private String plateNumber;
    private String make;
    private String model;
    private int modelYear;
    private Car car;
    private List<BookingDTO> bookingDTOList;
    private UserDTO userDTO;

    public CarDTO(Car car) {
        this.plateNumber = car.getPlateNumber();
        this.make = car.getMake();
        this.model = car.getModel();
        this.modelYear = car.getModelYear();
        this.bookingDTOList = BookingDTO.getDTOs(car.getBookings());
        this.userDTO = new UserDTO(car.getUser().getUserName());
    }

    public CarDTO(String plateNumber, String make, String model, int modelYear) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<BookingDTO> getBookingDTOList() {
        return bookingDTOList;
    }

    public void setBookingDTOList(List<BookingDTO> bookingDTOList) {
        this.bookingDTOList = bookingDTOList;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
}
