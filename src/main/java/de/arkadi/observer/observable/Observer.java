package main.java.de.arkadi.observer.observable;

// observes objects of type T
interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}
