package main.java.de.arkadi.openclosedprinciple.filter;

import main.java.de.arkadi.openclosedprinciple.model.Color;
import main.java.de.arkadi.openclosedprinciple.model.Product;
import main.java.de.arkadi.openclosedprinciple.model.Size;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
    // state space explosion
    // 3 criteria = 7 methods
}
