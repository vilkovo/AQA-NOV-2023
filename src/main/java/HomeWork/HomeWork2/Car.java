package HomeWork.HomeWork2;

public class Car {

    public String color = null;

    //TODO: call this method when there is not color set, and intercept exception that occurs
    //вызовите этот метод, когда цвет пустой, и перехватить ошибку которая там возникнет
    //TODO: in same block in finally set car color to some value
    //в этом же блоке добавить finally и присвоить этому цвету какое-то значение

    public void printColorLength() {
        try {
            System.out.println(color.length());
        } catch (RuntimeException e) {
            System.out.println("Цвет машины пустой!");
        } finally {
            color = "Зеленый";
            System.out.println("Цвет этой машины - " + color + " )))");
        }
    }
}