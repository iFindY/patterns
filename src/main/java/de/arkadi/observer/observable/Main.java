package main.java.de.arkadi.observer.observable;

class Main implements Observer<Person>
        // Observer<Foo>
{
    public Main() {
        Person person = new Person();
        person.subscribe(this);
        for (int i = 20; i < 24; ++i)
            person.setAge(i);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.println("Person's " + args.propertyName
                + " has been changed to " + args.newValue);
    }
}
