package org.laiszig;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .filter(isEvenPredicate())
                .map(squareFunction())
                .forEach(printConsumer());
    }
// Predicate - output boolean condition
// Function - input and output - diferent or same type
// Consumer - used when want to process the input, no output
// Binary Operator - accepts two inputs and gives an output.
    /**
     * In Java, a Consumer is an interface that represents a function that takes an input argument
     * of one type and returns no result. The Java Consumer interface is also a functional interface,
     * which means it can be used as the assignment target for a lambda expression or method reference.
     * <p>
     * The Consumer interface in Java has a single abstract method named "accept", which takes an input
     * argument of type T and returns no output. The "accept" method is used to perform some operation
     * on the input argument without returning any result.
     */
    private static Consumer<Integer> printConsumer() {
        return System.out::println;
    }

    Consumer<Integer> printConsumer2 = new Consumer<Integer>() {
        @Override
        public void accept(Integer x) {
            System.out.println(x);
        }
    };


    /**
     * In Java, a Function is an interface that represents a function that takes an input argument
     * of one type and returns an output of another type. The Java Function interface is also a
     * functional interface, which means it can be used as the assignment target for a lambda expression
     * or method reference.
     * <p>
     * The Function interface in Java has a single abstract method named "apply", which takes an input
     * argument of type T and returns an output of type R. The "apply" method is used to transform the
     * input argument into an output of a different type.
     **/
    private static Function<Integer, Integer> squareFunction() {
        return x -> x * x;
    }

    Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer x) {
            return x * x;
        }
    };

    /**
     * In Java, a predicate is an interface that represents a function that takes
     * a single input and returns a Boolean value. The Java Predicate interface is a functional interface,
     * which means it can be used as the assignment target for a lambda expression or method reference.
     * <p>
     * The Predicate interface in Java has a single abstract method named "test", which takes an input
     * argument and returns a Boolean value. The "test" method is used to evaluate the input argument
     * against some condition and returns true if the condition is satisfied, otherwise it returns false.
     **/
    private static Predicate<Integer> isEvenPredicate() {
        return x -> x % 2 == 0;
    }

    Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
        @Override
        public boolean test(Integer x) {
            return x % 2 == 0;
        }
    };
}