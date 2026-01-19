package com.gorakh.lldrunner.elevatorsystem;

import org.apache.tomcat.util.IntrospectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int id;
    private final int capacity;
    private int currentfloor;
    private Direction currentDirection;
    private final List<Request> requests;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentfloor = 1;
        this.currentDirection = Direction.Up;
        this.requests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentfloor() {
        return currentfloor;
    }

    public  synchronized void addRequest(Request request){
        if(requests.size() < capacity){
            requests.add(request);
            System.out.println("Elevator " +  id + "added Request " + request.getName());
            notifyAll();
        }
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void run() {
        processRequests();
    }

    public synchronized void processRequests() {
        while(true){
            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

     public synchronized void processRequest(Request request){
         int startFloor = currentfloor;
         int endFloor = request.getDestinationfloor();
        if(startFloor < endFloor){
            currentDirection = Direction.Up;
            for(int i=startFloor ;i<= endFloor ;i++){
                currentfloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentfloor);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            currentDirection =Direction.Down;
            for(int i=startFloor ;i>= endFloor ;i--){
                currentfloor = i;
                System.out.println("Elevator " + id + " reached floor " + currentfloor);
                try {
                    Thread.sleep(1000); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

     }

    private synchronized  Request getNextRequest() {
        while(requests.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }
}
