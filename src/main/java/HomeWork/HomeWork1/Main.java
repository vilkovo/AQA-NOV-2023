package HomeWork.HomeWork1;

public class Main {

    public static void main(String[] args) {

        Car myCar = new Car();
        BigCar bigCar = new BigCar();
        ElectricCar electricCar = new ElectricCar();
        Telega telega = new Telega();
        BigTruck bigTruck = new BigTruck();
        Truck truck = new Truck();
        ElectricTruck electricTruck = new ElectricTruck();

        followTheRoute(myCar);
        followTheRoute(telega);
        followTheRoute(truck);
        followTheRoute(bigTruck);
        followTheRoute(electricTruck);
        followTheRoute2(electricTruck);

        Car car = new Car();
        car.goTo("Lviv");
        car.goTo("Dnipro", "Chernihiv");
        car.goTo("Kyiv", "Kharkiv", "Poltava");
        car.goTo("Odessa", "Kyiv", "Dnipro", "food");
        car.goTo("Odessa", "Kyiv", "Dnipro", "food", "return");
    }

    public static void paintCar(Car car) {
        car.color = "black";
    }

    public static void followTheRoute(ITurnable iCar) {
        iCar.turnLeft();
        iCar.turnRight();
    }
    public static void followTheRoute2(IMovable iCar) {
        iCar.moveForward();
        iCar.moveBackward();
    }
}