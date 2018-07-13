package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private Long id;
    private CarBrand brand;
    private CarType type;
    private String name;
    private Integer year;
    private String motorPotency;
    private Double pricePerDay;
    private Integer capacityOfPeople;
    private List<Car> cars;

    public CarModel() {
        this.cars = new ArrayList<Car>();
    }

    public CarModel(Long id, CarBrand brand, CarType type, String name, Integer year, String motorPotency, Double pricePerDay, Integer capacityOfPeople) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.name = name;
        this.year = year;
        this.motorPotency = motorPotency;
        this.pricePerDay = pricePerDay;
        this.capacityOfPeople = capacityOfPeople;
        this.cars = new ArrayList<Car>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMotorPotency() {
        return motorPotency;
    }

    public void setMotorPotency(String motorPotency) {
        this.motorPotency = motorPotency;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getCapacityOfPeople() {
        return capacityOfPeople;
    }

    public void setCapacityOfPeople(Integer capacityOfPeople) {
        this.capacityOfPeople = capacityOfPeople;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
