
package main.java.de.arkadi.observer.event;

import java.util.*;
import java.util.function.Consumer;

class Event<TArgs> {
    private int count = 0;
    Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    Subscription addHandler(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    void fire(TArgs args) {
        for (Consumer<TArgs> handler : handlers.values())
            handler.accept(args);
    }

}

