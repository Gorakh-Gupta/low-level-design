package com.gorakh.lldrunner.bookmyshow;

import com.gorakh.lldrunner.bookmyshow.seat.Seat;
import com.gorakh.lldrunner.bookmyshow.seat.SeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BookMyShow {
    private static BookMyShow instance;
    private final List<Movie> movies;
    private final List<Theater> theaters;
    private final Map<String, Show> shows;
    private final Map<String, Booking> bookings;

    public BookMyShow() {
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.shows = new ConcurrentHashMap<>();
        this.bookings = new ConcurrentHashMap<>();
    }

    public static synchronized  BookMyShow getInstance() {
        if(instance == null){
            instance = new BookMyShow();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public void addShow(Show show) {
        shows.put(show.getId(),show);
    }

    public Booking bookTickets(User user, Show show, List<Seat> selectedSeats) {
        //check if seats are available;
        if(isSeatAvailable(show, selectedSeats)) {
            String bookingId = "BKG" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            double totalprice = calculatePrice(selectedSeats);
            Booking booking = new Booking(bookingId, user, show, selectedSeats, totalprice);
            bookings.put(bookingId, booking);
            return booking;
        }
        return null;
    }

    private double calculatePrice(List<Seat>seats){
        double prices =0;
        for(Seat seat : seats){
            prices+=seat.getPrice();
        }
        return prices;
    }
     private boolean isSeatAvailable(Show show, List<Seat>seats){
         for (Seat seat : seats) {
             Seat showSeat = show.getSeats().get(seat.getId());
             if (showSeat == null || showSeat.getStatus() != SeatStatus.AVAILABLE) {
                 return false;
             }
         }
         return true;
     }

    public void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        List<Seat> seats = booking.getSelectedSeat();
        for(Seat seat : seats){
            seat.setStatus(SeatStatus.BOOKED);
        }
        booking.setStatus(BookingStatus.Confirmed);
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        List<Seat> seats = booking.getSelectedSeat();
        for(Seat seat : seats){
            seat.setStatus(SeatStatus.AVAILABLE);
        }
        booking.setStatus(BookingStatus.Cancelled);
    }
}
