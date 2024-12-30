package cat;

public class Main {
    public static void main(String[] args) {

//        Cat myCat = new Cat();

        printThing(() -> System.out.println("Meow!"));
    }

    static void printThing(Printable thing) {
        thing.print();
    }
}


/*
Lambdas in Java can only be used with certain types of interfaces.

An interface is like a contract. Any class that implements that interface,
has to provide their own implementations of the methods specified by that interface.

When an interface has only one method, and it takes a parameter, the only thing that matters
is what that class implementation of this method is.

Lambdas allow us to just pass in a specific implementation of this method as the parameter.

** Instead of passing in an object that contains a specific implementation of a method, we are just passing in
that specific implementation.
 */