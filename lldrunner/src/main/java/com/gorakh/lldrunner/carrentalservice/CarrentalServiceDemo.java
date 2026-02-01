package com.gorakh.lldrunner.carrentalservice;

import java.time.LocalDate;
import java.util.List;

public class CarrentalServiceDemo {
    public static  void run(){
        CarRentalService rentalSystem = CarRentalService.getInstance();

        // Add cars to the rental system
        rentalSystem.addCar(new Car("Toyota", "Camry", 2022, 50.0));
        rentalSystem.addCar(new Car("Honda", "Civic", 2021, 45.0));
        rentalSystem.addCar(new Car("Ford", "Mustang", 2023, 80.0));

        // Create customers
        User customer1 = new User("U1", "John Doe", "john@example.com", "DL1234");

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars = rentalSystem.searchCars("Toyota", "Camry", startDate, endDate);
        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            Reservation reservation = rentalSystem.makeReservation(customer1, selectedCar, startDate, endDate);
            System.out.println("Reservation Done with Id "+ reservation.getId());
            if (reservation != null) {
                //do thr payment for reservation
//                boolean paymentSuccess = rentalSystem.processPayment(reservation);
                boolean paymentSuccess = false;
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getId());
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    rentalSystem.cancelReservation(reservation.getId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}

