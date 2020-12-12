package main.java.de.arkadi.creational.builder.two;

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAs(String position) {
        person.position = position;
        return self();
    }

//    //  from person builder, you can override  and do some stuff here
//    @Override
//    protected EmployeeBuilder self() {
//        return this;
//    }
}
