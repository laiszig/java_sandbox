package org.laiszig;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FP03FunctionalInterfaces2 {
    public static void main(String[] args) {

        //BiPredicate
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5, "in28minutes"));
        System.out.println("---------");

        //BiFunction
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };

        System.out.println(biFunction.apply(15, "in28minutes"));
        System.out.println("---------");


        //BiConsumer
        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(15, "in28Minutes");
        System.out.println("---------");


    }
}
