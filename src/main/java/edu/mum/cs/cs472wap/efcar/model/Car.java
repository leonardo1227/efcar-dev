package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private Long id;
    private CarModel model;
    private  String plate;
    private Double milleage;
    private Boolean available;
    private String color;
    private List<String> pictures;
    private List<BookingCar> bookings;

    public Car() {
        this.pictures = new ArrayList<String>();
        this.bookings = new ArrayList<BookingCar>();
    }

    public Car(Long id, CarModel model, String plate, Double milleage, Boolean available, String color) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.milleage = milleage;
        this.available = available;
        this.color = color;
        this.pictures = new ArrayList<String>();
        this.bookings = new ArrayList<BookingCar>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Double getMilleage() {
        return milleage;
    }

    public void setMilleage(Double milleage) {
        this.milleage = milleage;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<BookingCar> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingCar> bookings) {
        this.bookings = bookings;
    }
}
