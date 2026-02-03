package com.gorakh.lldrunner.ridesharingservice;

public class Passenger {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final Location location;

    public Passenger(String id, String name, String contactInfo, Location location) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }
}
