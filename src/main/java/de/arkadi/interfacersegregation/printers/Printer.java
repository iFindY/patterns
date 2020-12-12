package main.java.de.arkadi.interfacersegregation.printers;

import main.java.de.arkadi.interfacersegregation.Document;

public interface Printer
{
  void Print(Document d) throws Exception;
}
