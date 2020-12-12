package main.java.de.arkadi.interfacersegregation.multifunctional;

import main.java.de.arkadi.interfacersegregation.Document;

public interface Machine {
    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d) throws Exception;
}
