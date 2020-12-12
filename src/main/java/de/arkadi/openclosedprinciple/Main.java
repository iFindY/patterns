package main.java.de.arkadi.openclosedprinciple;

import main.java.de.arkadi.openclosedprinciple.filter.BetterFilter;
import main.java.de.arkadi.openclosedprinciple.filter.ProductFilter;
import main.java.de.arkadi.openclosedprinciple.model.Color;
import main.java.de.arkadi.openclosedprinciple.model.Product;
import main.java.de.arkadi.openclosedprinciple.model.Size;
import main.java.de.arkadi.openclosedprinciple.specification.AndSpecification;
import main.java.de.arkadi.openclosedprinciple.specification.ColorSpecification;
import main.java.de.arkadi.openclosedprinciple.specification.SizeSpecification;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old):");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        // ^^ BEFORE

        // vv AFTER
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new):");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        System.out.println("Large products:");
        bf.filter(products, new SizeSpecification(Size.LARGE))
                .forEach(p -> System.out.println(" - " + p.name + " is large"));

        System.out.println("Large blue items:");
        bf.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.LARGE)
                ))
                .forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
    }
}
