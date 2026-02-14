package com.gorakh.lldrunner.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingspots;

    public Level(int floor, int numSpots) {
        parkingspots = new ArrayList<>(numSpots);
        this.floor = floor;
        
        double spotsForBikes = 0.50;
        double spotsForCars = 0.40;

        int numBikes = (int) (numSpots * spotsForBikes);
        int numCars = (int) (numSpots * spotsForCars);


        for (int i = 1; i <= numBikes; i++) {
            parkingspots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for (int i = numBikes + 1; i <= numCars + numBikes; i++) {
            parkingspots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for (int i = numBikes + numCars + 1; i <= numSpots; i++) {
            parkingspots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingspots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingspots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingspots) {
            System.out.println("Spot " + spot.getParkingspotNumber() + ": " + (spot.isAvailable() ? "Available For" : "Occupied By ") + " " + spot.getVehicleType());
        }
    }

}
