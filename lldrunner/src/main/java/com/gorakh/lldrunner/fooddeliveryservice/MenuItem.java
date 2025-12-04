package com.gorakh.lldrunner.fooddeliveryservice;

public class MenuItem {

    private final String  id;
    private final String name;
    private final String description;
    private final double price;
    private boolean availability;

    public MenuItem(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = true;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
