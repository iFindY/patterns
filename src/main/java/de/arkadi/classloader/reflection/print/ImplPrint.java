package main.java.de.arkadi.classloader.reflection.print;

public class ImplPrint implements IPrint {

    public static void staticPrint() {
        System.out.println("Hi im static !!");
    }


    public int version;
    public String name;
    private String address;

    public ImplPrint(int i) {
        this.version = i;
        this.name = "Peter";
        this.address = "Germany";
    }


    public void print() {
        System.out.println("privet from ImplPrint Class !!");
    }

    public void print(String h, String w) {
        System.out.println(h + " " + w);
    }

    public void doSome() {
        System.out.println("working");
    }

    private void doNothing() {
        System.out.println("chilling");
    }
}
