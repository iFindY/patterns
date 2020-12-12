package main.java.de.arkadi.classloader.reflection.car;

import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String... args) throws Exception {
        Class cl = Car.class;
        System.out.println(cl.getConstructor().newInstance());
        Arrays.asList(cl.getDeclaredMethods()).
        stream().
        forEach(x->System.out.println(x.getName() + " | " + x.getParameterCount()));

        System.out.print("\n");

        // Class scl = cl.getSuperclass();
        while (cl != null) {
            System.out.println(cl.getName());
            for (Constructor c : cl.getConstructors()) {
                System.out.print("   " + c.getName() + " | ");
                System.out.print(c.getParameterCount() + " | ");
                for(Parameter p : c.getParameters()) {
                    System.out.print(p.getType() + ", ");
                }
                System.out.print("\n");
            }
            cl = cl.getSuperclass();
        }
    }
}


