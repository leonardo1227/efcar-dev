package edu.mum.cs.cs472wap.efcar.model;

import java.time.LocalDate;

public class BookingCar {

    private Long id;
    private Car car;
    private User user;
    private Double totalPrice;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private LocalDate realDropOffDate;
    private Double starMilleage;
    private Double finalMilleage;
    private Payment payment;

    public BookingCar(Long id, Car car, User user, Double totalPrice, LocalDate pickUpDate, LocalDate dropOffDate, LocalDate realDropOffDate, Double starMilleage, Double finalMilleage, Payment payment) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.totalPrice = totalPrice;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.realDropOffDate = realDropOffDate;
        this.starMilleage = starMilleage;
        this.finalMilleage = finalMilleage;
        this.payment = payment;
    }

    public BookingCar() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDate dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public LocalDate getRealDropOffDate() {
        return realDropOffDate;
    }

    public void setRealDropOffDate(LocalDate realDropOffDate) {
        this.realDropOffDate = realDropOffDate;
    }

    public Double getStarMilleage() {
        return starMilleage;
    }

    public void setStarMilleage(Double starMilleage) {
        this.starMilleage = starMilleage;
    }

    public Double getFinalMilleage() {
        return finalMilleage;
    }

    public void setFinalMilleage(Double finalMilleage) {
        this.finalMilleage = finalMilleage;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getRanMilleages(){
        return this.getFinalMilleage()-this.getStarMilleage();
    }

    public Integer getDaysOfRent(){
        //return this.realDropOffDate.minusDays(this.getStarMilleage().)
        return null;
    }
}
