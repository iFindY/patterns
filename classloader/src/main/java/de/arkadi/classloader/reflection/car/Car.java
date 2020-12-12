package main.java.de.arkadi.classloader.reflection.car;

public class Car extends Vehicle {
    private  int wheeles;
    public String name;

    public Car() {
        super("name", 44);
        System.out.print("hi");
    }
    public Car(String name, int i) {
        super(name, i);
        this.name = name;
    }

    public void drive() {
        System.out.print("driving!!");
    }
    private void smoking() {
        System.out.print("smoking!!");
    }
}
