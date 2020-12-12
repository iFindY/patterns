package main.java.de.arkadi.openclosedprinciple.specification;

// we introduce abst new interfaces that are open for extension
public interface Specification<T>
{
  boolean isSatisfied(T item);
}
