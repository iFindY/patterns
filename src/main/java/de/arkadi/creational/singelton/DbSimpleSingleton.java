package main.java.de.arkadi.creational.singelton;

// eager loading
public class DbSimpleSingleton {

    private static DbSimpleSingleton instance = new DbSimpleSingleton();


    private DbSimpleSingleton() {
    }

    public static DbSimpleSingleton getInstance() {
        return instance;
    }
}



