package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private Long id;
    private CarModel model;
    private String plate;
    private Double mileage;
    private Boolean available;
    private String color;
    private List<String> pictures;
    private List<BookingCar> bookings;

    public Car() {
        this.pictures = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.pictures.add(generateURL());
    }

    public Car(Long id, CarModel model, String plate, Double mileage, Boolean available, String color) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.mileage = mileage;
        this.available = available;
        this.color = color;
        this.pictures = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.pictures.add(generateURL());
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

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
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

    private String generateURL(){
        Random r = new Random();
        int rand = r.nextInt(5) + 1;
        switch (rand) {
            case 1:
                return "https://car-images.bauersecure.com/pagefiles/74108/toyota_hybrids_01.jpg";
            case 2:
                return "https://thebaynet.s3.amazonaws.com/media/photos/gallery/15fb6979-800f-4171-a6dc-b502c6152287.jpg";
            case 3:
                return "https://auto-uploads.ndtvimg.com/used/26959/big/hyundai-xcent-front-left-rim.jpg?v=1518874276";
            case 4:
                return "https://img2.carmax.com/img/vehicles/15655490/1/v-0x8d5e5ab5071cf2/1920.jpg";
            case 5:
                return "https://www.jeanchatzky.com/wp-content/uploads/2012/07/carforsale.jpg";
        }
        return "";
    }
}
