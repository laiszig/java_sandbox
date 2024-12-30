package org.laiszig;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03Supplier {

    //no input > return something

    public static void main(String[] args) {

    Supplier<Integer> randomIntegerSupplier = () -> { //empty parameter
        Random random = new Random();
        return random.nextInt(1000);

    };
        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));
    }
}