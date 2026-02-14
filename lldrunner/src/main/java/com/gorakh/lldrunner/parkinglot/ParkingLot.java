package com.gorakh.lldrunner.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private  ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }


    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level level: levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public void displayAvailability() {
        for(Level level: levels){
            level.displayAvailability();
        }
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(Level level: levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle un parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }
}
