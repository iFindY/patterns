package main.java.de.arkadi.observer.event;

public class Subscription<TArgs> implements AutoCloseable {
    private Event<TArgs> event;
    private int id;

    Subscription(Event<TArgs> event, int id) {
        this.event = event;
        this.id = id;
    }

    @Override
    public void close() /*throws Exception*/ {
        event.handlers.remove(id);
    }
}
