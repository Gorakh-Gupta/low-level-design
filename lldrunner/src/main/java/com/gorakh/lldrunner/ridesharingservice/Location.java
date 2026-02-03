package com.gorakh.lldrunner.ridesharingservice;

public class Location {
    private double latitude;
    private double langitude;

    public Location(double latitude, double langitude) {
        this.latitude = latitude;
        this.langitude = langitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLangitude() {
        return langitude;
    }
}
