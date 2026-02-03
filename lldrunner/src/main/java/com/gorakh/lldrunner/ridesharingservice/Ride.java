package com.gorakh.lldrunner.ridesharingservice;

public class Ride {
    private final String id;
    private final Passenger passenger;
    private final Driver driver;
    private final Location destinationLocation;
    private double fare;

    public Ride(String id, Passenger passenger, Driver driver, Location destinationLocation, double fare) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.destinationLocation = destinationLocation;
        this.fare = fare;;
    }

    public String getId() {
        return id;
    }

    public double getFare() {
        return fare;
    }

    public Driver getDriver() {
        return driver;
    }
}
