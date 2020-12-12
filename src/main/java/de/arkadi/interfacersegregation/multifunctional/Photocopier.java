package main.java.de.arkadi.interfacersegregation.multifunctional;

import main.java.de.arkadi.interfacersegregation.Document;
import main.java.de.arkadi.interfacersegregation.printers.Printer;

class Photocopier implements Printer, IScanner
{
  public void Print(Document d) throws Exception
  {
    throw new Exception();
  }

  public void Scan(Document d) throws Exception
  {
    throw new Exception();
  }
}
