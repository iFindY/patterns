package main.java.de.arkadi.openclosedprinciple.filter;


import main.java.de.arkadi.openclosedprinciple.specification.Specification;

import java.util.List;
import java.util.stream.Stream;

interface Filter<T>
{
  Stream<T> filter(List<T> items, Specification<T> spec);
}
