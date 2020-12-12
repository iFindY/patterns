package main.java.de.arkadi.interfacersegregation.multifunctional;

import main.java.de.arkadi.interfacersegregation.Document;
import main.java.de.arkadi.interfacersegregation.printers.Printer;

class MultiFunctionMachine implements MultiFunctionDevice
{
  // compose this out of several modules
  private Printer printer;
  private IScanner scanner;

  public MultiFunctionMachine(Printer printer, IScanner scanner)
  {
    this.printer = printer;
    this.scanner = scanner;
  }

  public void Print(Document d) throws Exception
  {
    printer.Print(d);
  }

  public void Scan(Document d) throws Exception
  {
    scanner.Scan(d);
  }
}
