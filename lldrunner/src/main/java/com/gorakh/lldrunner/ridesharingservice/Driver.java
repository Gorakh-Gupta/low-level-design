package com.gorakh.lldrunner.ridesharingservice;

public class Driver {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final String licencePlate;
    private final Location location;
//    public boolean getStatus;
    private String status ;


    public Driver(String id, String name, String contactInfo, String licencePlate, Location location) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.licencePlate = licencePlate;
        this.location = location;
        this.status = "AVAILABLE";
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }
}
