package main.java.de.arkadi.classloader.reflection.print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {

        try {
            getMethods(ImplPrint.class);
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                InstantiationException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


    public static void getMethods(Class clazz) throws
            NoSuchMethodException, NoSuchFieldException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {

        Method method;
        Constructor[] ctors = clazz.getDeclaredConstructors();
        Object dynamic = ctors[0].newInstance(4);

        method = clazz.getDeclaredMethod("print", String.class, String.class);
        method.invoke(dynamic, "Hello", "World");

        method = clazz.getDeclaredMethod("print");
        method.invoke(dynamic);

        method = clazz.getDeclaredMethod("staticPrint");
        method.invoke(null);

        method = clazz.getDeclaredMethod("doNothing");
        method.setAccessible(true);
        method.invoke(dynamic);

        Field field = clazz.getDeclaredField("version");
        field.set(dynamic, 5);
        int version = (int) field.get(dynamic);
        System.out.println(version);

    }

}
