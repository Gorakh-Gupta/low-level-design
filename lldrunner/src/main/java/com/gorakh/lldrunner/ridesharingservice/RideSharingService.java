package com.gorakh.lldrunner.ridesharingservice;

import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RideSharingService {
    private static RideSharingService instance;
    private final Map<String , Passenger>passengers;
    private final Map<String ,Driver>drivers;
    private final Map<String , Ride>rides;
    private final Queue<Ride> requestedRides;

    public RideSharingService() {
        this.requestedRides = new ConcurrentLinkedQueue<>();
        this.passengers = new ConcurrentHashMap<>();
        this.drivers = new ConcurrentHashMap<>();
        this.rides = new ConcurrentHashMap<>();
    }

    public static synchronized RideSharingService getInstance(){
        if(instance == null){
            instance = new RideSharingService();
        }
        return instance;
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(),passenger);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public synchronized  void requestRide(Passenger passenger,Location destination) {
        Location source = passenger.getLocation();
        String rideId = "RIDE " + UUID.randomUUID().toString().substring(0,7).toUpperCase();
        double fare = calculateFare( source,  destination);
        //assign driver
        for(Driver driver:drivers.values()){
            if(driver.getStatus() .equals("AVAILABLE")){
                driver.setStatus("BUSY");
                Ride ride = new Ride(rideId ,passenger, driver ,destination ,fare);
                rides.put(rideId,ride);
                requestedRides.offer(ride);
                return;
            }
        }
        System.out.println("No Driver Available");
    }

    public double calculateFare(Location source, Location Destination) {
        // Calculate the distance between two locations using a distance formula (e.g., Haversine formula)
        // For simplicity, let's assume a random distance between 1 and 20 km
        return Math.random() * 20 + 1;
    }

    public Queue<Ride> getRequestedRides() {
        return requestedRides;
    }

    public void startRide(Ride ride) {
        System.out.println("Strted Riding  "+ ride.getId());

    }

    public void completeRide(Ride ride) {
        System.out.println("Ride Completed "+ ride.getId());
    }

    public void cancelRide(Ride ride) {
        Driver dr = ride.getDriver();
        dr.setStatus("AVAILABLE");
        System.out.println("Ride Cancelled "+ ride.getId());
    }


}
