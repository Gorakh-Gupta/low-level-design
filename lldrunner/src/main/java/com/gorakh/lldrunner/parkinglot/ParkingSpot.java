package com.gorakh.lldrunner.parkinglot;

public class ParkingSpot {
    private final int parkingspotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int parkingspotNumber, VehicleType vehicleType) {
        this.parkingspotNumber = parkingspotNumber;
        this.vehicleType = vehicleType;
    }
    public synchronized  boolean isAvailable(){
        return parkedVehicle == null;
    }
    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType() == vehicleType){
          parkedVehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public synchronized void unparVehicle(){
        parkedVehicle = null;
    }

    public int getParkingspotNumber() {
        return parkingspotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
