package com.gorakh.lldrunner.elevatorsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorSystem {

    private final List<Elevator> elevators;

    public ElevatorSystem(int numElevator, int capacity){
        elevators = new ArrayList<>();
        for(int i=0;i<numElevator ;i++){
            Elevator elevator = new Elevator(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int source, int destination, String name) {
        Elevator ele = findOptimalElavtor(source, destination);
        System.out.println(ele + "PPPPPPPPPPPPPP");
        ele.addRequest(new Request(source, destination,name));
    }

    private Elevator findOptimalElavtor(int source, int destination) {
     Elevator optimal = null;
     int minDistance = Integer.MAX_VALUE;

     //firts preference to direction;
        Direction direction = source > destination? Direction.Down : Direction.Up;
        List<Elevator> optimals = elevators.stream().filter(e -> e.getCurrentDirection()== direction).findAny().isPresent()?
                elevators.stream().filter(e -> e.getCurrentDirection() == direction).collect(Collectors.toList()) : elevators;

//        System.out.println(optimals.size() + "FFFFFFFFF");
        for(Elevator e: optimals){
            int distance = Math.abs(source - e.getCurrentfloor());
            if(minDistance > distance){
                minDistance = distance;
                optimal = e;
            }
        }
        return optimal;
    }
}
