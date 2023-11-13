package org.prog;

public class Truck extends BigCar {

    @Override
    public void turnLeft() {
        System.out.println("Truck turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("Truck turning right");
    }
}
