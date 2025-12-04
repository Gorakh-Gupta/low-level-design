package com.gorakh.lldrunner.fooddeliveryservice;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String  id;
    private final String name;
    private final String address;

    private List<MenuItem> menus;

    public Restaurant(String id, String name, String address,List<MenuItem>item) {
        this.id = id;
        this.name = name;
        this.address = address;
        menus = item;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getMenus() {
        return menus;
    }
}
