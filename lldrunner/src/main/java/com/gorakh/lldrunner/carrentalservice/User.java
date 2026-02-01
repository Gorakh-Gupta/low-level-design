package com.gorakh.lldrunner.carrentalservice;

public class User {
    private final String id;
    private final String name;
    private final String contactNumber;
    private final String licenceNumber;

    public User(String id, String name, String contactNumber, String licenceNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.licenceNumber = licenceNumber;
    }

    public String getId() {
        return id;
    }
}
