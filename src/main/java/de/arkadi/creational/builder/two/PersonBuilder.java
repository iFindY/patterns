package main.java.de.arkadi.creational.builder.two;


//  take a type argument which have to be some type of PersonBuilder
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    // critical to return SELF here
    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    // externalised to override behavior of self in derived classes
    protected SELF self() {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public Person build() {
        return person;
    }
}
