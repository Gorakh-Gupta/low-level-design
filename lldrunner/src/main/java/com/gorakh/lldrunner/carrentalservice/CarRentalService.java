package com.gorakh.lldrunner.carrentalservice;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalService {
    private static CarRentalService instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;

    public CarRentalService() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
    }

    public static  synchronized CarRentalService getInstance(){
        if(instance ==  null){
            instance = new CarRentalService();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.put(car.getId(),car);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for(Car c : cars.values()){
            if(c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)
            && c.getStatus() == CarStatus.AVAILABLE ){
                if (isCarAvailable(c, startDate, endDate)) {
                    availableCars.add(c);
                }
            }

        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEnddate()) && endDate.isAfter(reservation.getStartdate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public Reservation makeReservation(User customer, Car car, LocalDate startDate, LocalDate endDate) {
        if(isCarAvailable(car, startDate, endDate)) {
            String reservationId = "RES" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
            Reservation res = new Reservation(reservationId, startDate,endDate,car);
            reservations.put(reservationId,res);
            car.setStatus(CarStatus.BOOKED);
            return res;
        }
        return null;

    }
    public synchronized void cancelReservation(String reservationId){
        System.out.println("CANCELLED "+ reservationId);
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getCar().setStatus(CarStatus.AVAILABLE);
        }
    }
}
