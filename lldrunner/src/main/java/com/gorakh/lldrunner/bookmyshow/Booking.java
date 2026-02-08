package com.gorakh.lldrunner.bookmyshow;

import com.gorakh.lldrunner.bookmyshow.seat.Seat;
import com.gorakh.lldrunner.bookmyshow.seat.SeatStatus;

import java.util.List;

public class Booking {
    private final String id;
    private final User user;
    private final Show show;
    private final List<Seat> selectedSeat;
    private final double price;
    private  BookingStatus status;

    public Booking(String id, User user, Show show, List<Seat> selectedSeat, double price) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.selectedSeat = selectedSeat;
        this.price = price;
        this.status = BookingStatus.Pending;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSelectedSeat() {
        return selectedSeat;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }


}
