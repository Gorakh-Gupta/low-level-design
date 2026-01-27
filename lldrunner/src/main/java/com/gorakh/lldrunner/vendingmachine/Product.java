package com.gorakh.lldrunner.vendingmachine;

public class Product {
    private final String name;
    private final double  price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


}
