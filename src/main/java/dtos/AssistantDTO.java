package dtos;

import entities.Assistant;

import java.util.ArrayList;
import java.util.List;

public class AssistantDTO {

    private String name;
    private String primaryLanguage;
    private int yrsOfExperience;
    private double hourlyWage;
    private Assistant assistant;
    private List<BookingDTO> bookingDTOList;

    public AssistantDTO(Assistant assistant){
        this.name = assistant.getName();
        this.primaryLanguage = assistant.getPrimaryLanguage();
        this.yrsOfExperience = assistant.getYrsOfExperience();
        this.hourlyWage = assistant.getHourlyWage();
    }

    public AssistantDTO(String name, String primaryLanguage, int yrsOfExperience, int hourlyWage) {
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yrsOfExperience = yrsOfExperience;
        this.hourlyWage = hourlyWage;
    }

    public static List<AssistantDTO> getDTO(List<Assistant> washingList){
        List<AssistantDTO> washingDTOs = new ArrayList();
        washingList.forEach(wash->washingDTOs.add(new AssistantDTO(wash)));
        return washingDTOs;
    }

    public List<BookingDTO> getBookingDTOList() {
        return bookingDTOList;
    }

    public void setBookingDTOList(List<BookingDTO> bookingDTOList) {
        this.bookingDTOList = bookingDTOList;
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

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}