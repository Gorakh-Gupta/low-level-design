package com.gorakh.lldrunner.elevatorsystem;

public class ElevatorSystemDemo {

    public static void run() {

        ElevatorSystem controller = new ElevatorSystem(3, 5);
        controller.requestElevator(5, 10,"First");
        controller.requestElevator(4, 5, "Second");
        controller.requestElevator(8, 2, "Third");
        controller.requestElevator(1, 9, "Fourth");
    }
}
