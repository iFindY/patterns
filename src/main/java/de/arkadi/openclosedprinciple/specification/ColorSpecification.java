package main.java.de.arkadi.openclosedprinciple.specification;


import main.java.de.arkadi.openclosedprinciple.model.Color;
import main.java.de.arkadi.openclosedprinciple.model.Product;

public class ColorSpecification implements Specification<Product>
{
  private Color color;

  public ColorSpecification(Color color) {
    this.color = color;
  }

  @Override
  public boolean isSatisfied(Product p) {
    return p.color == color;
  }
}
