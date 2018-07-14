package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String username;
    private String password;
    private List<BookingCar> bookings;

    public User() {
        this.bookings = new ArrayList<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public User(String username, String password, Person person) {
        super(person);
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BookingCar> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingCar> bookings) {
        this.bookings = bookings;
    }
}
