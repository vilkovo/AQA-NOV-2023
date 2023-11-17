package org.prog;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    /**
     * #######99#########################
     * ##################################
     * #####redCar#######################
     * ##################################
     * ##################################
     * ##################################
     * ################yellowCar#########
     * ##################################
     * ##################################
     *
     * @param args
     */

    public static void main(String[] args) {
        String s = "s";
        String s1 = "";
        String s2 = null;

        System.out.println(s.length());
        System.out.println(s1.length());
        System.out.println(s2.length());

//        Car car = new Car();
//        car.smth();
//        car.goTo("Lviv");
//        car.goTo("Dnipro", "Chernihiv");
//        car.goTo("Kyiv", "Kharkiv", "Poltava");
//        car.goTo("Odessa", "Kyiv", "Dnipro", "food");
    }

    private static void increment(Integer input){
        input += 1000;
        System.out.println(input);
    }

    public static void paintCar(Car car) {
        car.color = "black";
    }

    public static void followTheRoute(ITurnable iCar) {
        iCar.turnLeft();
        iCar.turnRight();
    }
}
