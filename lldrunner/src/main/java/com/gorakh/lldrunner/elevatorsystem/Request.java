package com.gorakh.lldrunner.elevatorsystem;

public class Request {
    private final int startfloor;
    private final int destinationfloor;
    private final String name;


    public Request(int startfloor, int destinationfloor, String name) {
        this.startfloor = startfloor;
        this.destinationfloor = destinationfloor;
        this.name = name;
    }

    public int getStartfloor() {
        return startfloor;
    }

    public String getName() {
        return name;
    }

    public int getDestinationfloor() {
        return destinationfloor;
    }
}
