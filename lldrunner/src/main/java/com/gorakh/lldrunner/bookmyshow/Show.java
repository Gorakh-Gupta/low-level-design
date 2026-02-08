package com.gorakh.lldrunner.bookmyshow;

import com.gorakh.lldrunner.bookmyshow.seat.Seat;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    private final String id;
    private final Movie movie;
    private final Theater theater;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final Map<String, Seat> seats;

    public Show(String id, Movie movie, Theater theater, LocalDateTime startTime, LocalDateTime endTime,Map<String, Seat> seats) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }
}
