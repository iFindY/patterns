package main.java.de.arkadi.classloader.classpath.withinterface;

/**
 * Created by kevinj.
 */
public class Quote implements IQuote  {
    @Override
    public String getQuote() {
        return "A rolling stone gathers no moss";
    }
}
