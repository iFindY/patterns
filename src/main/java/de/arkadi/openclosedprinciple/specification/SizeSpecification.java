package main.java.de.arkadi.openclosedprinciple.specification;


import main.java.de.arkadi.openclosedprinciple.model.Product;
import main.java.de.arkadi.openclosedprinciple.model.Size;

public class SizeSpecification implements Specification<Product>
{
  private Size size;

  public SizeSpecification(Size size) {
    this.size = size;
  }

  @Override
  public boolean isSatisfied(Product p) {
    return p.size == size;
  }
}
