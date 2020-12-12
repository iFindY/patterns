package main.java.de.arkadi.classloader.reflection.car;

public class Vehicle {
    int cost;
    String type;
    public Vehicle (String type, int cost) {
        this.cost = cost;
        this.type = type;
    }

    public String inspect() {
        return "was inspected";
    }
}
