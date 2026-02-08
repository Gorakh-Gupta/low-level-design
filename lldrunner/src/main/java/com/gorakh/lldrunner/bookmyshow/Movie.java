package com.gorakh.lldrunner.bookmyshow;

public class Movie {
    private final String id;
    private final String titel;
    private final String description;
    private final int durationInMinute;


    public Movie(String id, String titel, String description, int durationInMinute) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.durationInMinute = durationInMinute;
    }

    public String getId() {
        return id;
    }

    public int getDurationInMinutes() {
        return durationInMinute;
    }
}
