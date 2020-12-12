package main.java.de.arkadi.interfacersegregation.printers;


import main.java.de.arkadi.interfacersegregation.Document;
import main.java.de.arkadi.interfacersegregation.multifunctional.Machine;

class OldFashionedPrinter implements Machine {
    public void print(Document d) {
        // yep
    }

    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    public void scan(Document d) throws Exception {
        throw new Exception();
    }
}
