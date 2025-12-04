package com.gorakh.lldrunner.fooddeliveryservice;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final String phone_number;

    public Customer(String id, String name, String email, String phone_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getId() {
        return id;
    }


    public String getPhone_number() {
        return phone_number;
    }
}
