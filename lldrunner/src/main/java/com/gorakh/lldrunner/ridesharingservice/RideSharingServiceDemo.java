package com.gorakh.lldrunner.ridesharingservice;

public class RideSharingServiceDemo {
    public static void run() {
        RideSharingService rideService = RideSharingService.getInstance();

        // Create passengers
        Passenger passenger1 = new Passenger("1", "John Doe", "1234567890", new Location(37.7749, -122.4194));
        Passenger passenger2 = new Passenger("2", "Jane Smith", "9876543210", new Location(37.7860, -122.4070));
        rideService.addPassenger(passenger1);
        rideService.addPassenger(passenger2);

        // Create drivers
        Driver driver1 = new Driver("1", "Alice Johnson", "4567890123", "ABC123", new Location(37.7749, -122.4194));
        Driver driver2 = new Driver("2", "Bob Williams", "7890123456", "XYZ789", new Location(37.7860, -122.4070));
        rideService.addDriver(driver1);
        rideService.addDriver(driver2);

        // Passenger 1 requests a ride
        rideService.requestRide(passenger1, new Location(37.7887, -122.4098));

        // Driver 1 accepts the ride
        Ride ride = rideService.getRequestedRides().poll();

        System.out.println("Ride Booking Successfully : "  + ride.getId() + " total Fare : "+ ride.getFare());

        // Start the ride
        rideService.startRide(ride);

        // Complete the ride
        rideService.completeRide(ride);

        // Passenger 2 requests a ride
        rideService.requestRide(passenger2, new Location(37.7749, -122.4194));

        // Driver 2 accepts the ride
        Ride ride2 = rideService.getRequestedRides().poll();

        // Passenger 2 cancels the ride
        rideService.cancelRide(ride2);
    }
}
