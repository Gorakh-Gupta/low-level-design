package com.gorakh.lldrunner.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private final String id;
    private final String name;
    private final String address;
    private final List<Show> shows;

    public Theater(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.shows = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
}
