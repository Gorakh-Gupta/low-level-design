package com.gorakh.lldrunner.bookmyshow;

import com.gorakh.lldrunner.bookmyshow.seat.Seat;
import com.gorakh.lldrunner.bookmyshow.seat.SeatType;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMyShowDemo {
    public static void run(){
        BookMyShow bookingSystem = BookMyShow.getInstance();
        // Add movies
        Movie movie1 = new Movie("M1", "Movie 1", "Description 1", 120);
        Movie movie2 = new Movie("M2", "Movie 2", "Description 2", 135);
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        // Add theaters
        Theater theater1 = new Theater("T1", "Theater 1", "Location 1");
        Theater theater2 = new Theater("T2", "Theater 2", "Location 2");
        bookingSystem.addTheater(theater1);
        bookingSystem.addTheater(theater2);

        // Add shows
        Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()), createSeats(10, 10));
        Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDurationInMinutes()), createSeats(8, 8));
        bookingSystem.addShow(show1);
        bookingSystem.addShow(show2);

        // Book tickets
        User user = new User("U1", "John Doe", "john@example.com");

        List<Seat> selectedSeats = Arrays.asList(show1.getSeats().get("1-5"), show1.getSeats().get("1-6"));

        Booking booking = bookingSystem.bookTickets(user, show1, selectedSeats);

        //check status
        System.out.println("Status " + booking.getStatus());

        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getId());
            bookingSystem.confirmBooking(booking.getId());
        } else {
            System.out.println("Booking failed. Seats not available.");
        }

        //check status
        System.out.println("Status " + booking.getStatus());

        // Cancel booking
        bookingSystem.cancelBooking(booking.getId());
        System.out.println("Booking canceled. Booking ID: " + booking.getId());

        //check status
        System.out.println("Status " + booking.getStatus());
    }

    private static Map<String, Seat> createSeats(int rows, int cols) {
        Map<String, Seat>  seats = new HashMap<>();
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                String seatId = row + "-" + col;
                SeatType seatType = (row <= 2) ? SeatType.PREMIUM : SeatType.NORMAL;
                Seat seat = new Seat(seatId, row, col, seatType);
                seats.put(seatId, seat);
            }
        }
        return seats;
    }

}
