package main.java.de.arkadi.creational.builder.one;

public class Main {

    public static void main(String args[]) {

        LunchOrder lunchOrder = LunchOrder.configure().dressing("Mayo").meat("Turkey").bread("White").build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
