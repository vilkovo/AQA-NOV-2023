package org.prog;

public class Telega implements ITurnable {
    @Override
    public void turnLeft() {
        System.out.println("Telega turns left");
    }

    @Override
    public void turnRight() {
        System.out.println("Telega turns right");
    }
}
