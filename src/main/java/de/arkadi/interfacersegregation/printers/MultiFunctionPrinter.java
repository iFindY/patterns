package main.java.de.arkadi.interfacersegregation.printers;

import main.java.de.arkadi.interfacersegregation.Document;
import main.java.de.arkadi.interfacersegregation.multifunctional.Machine;

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
  public void print(Document d)
  {
    //
  }

  public void fax(Document d)
  {
    //
  }

  public void scan(Document d)
  {
    //
  }
}
