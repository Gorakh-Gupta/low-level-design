package com.gorakh.lldrunner.carrentalservice;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final double rate;
    private CarStatus status;

    public Car(String make, String model, int year, double rate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rate = rate;
        this.status = CarStatus.AVAILABLE;
    }

    public String getId() {
        return make;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getRate() {
        return rate;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
