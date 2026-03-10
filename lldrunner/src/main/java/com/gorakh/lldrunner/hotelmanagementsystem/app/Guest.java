package com.gorakh.lldrunner.hotelmanagementsystem.app;

public class Guest {
     private final String id;
     private final String namel;
     private final String email;
     private final String phoneNumber;

    public Guest(String id, String namel, String email, String phoneNumber) {
        this.id = id;
        this.namel = namel;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getNamel() {
        return namel;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
