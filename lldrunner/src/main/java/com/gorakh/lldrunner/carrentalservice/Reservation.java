package com.gorakh.lldrunner.carrentalservice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private final String id;
    private final LocalDate startdate;
    private final LocalDate enddate;
    private User user;
    private final Car car;
    private double totalprice;


    public Reservation(String id, LocalDate startdate, LocalDate enddate, Car car) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public User getUser() {
        return user;
    }
}
