package org.laiszig;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        filterAndPrint(numbers, x1 -> x1 % 2 == 0); //we are passing the behavior of the method as an argument!

        System.out.println(".....");

        filterAndPrint(numbers, x -> x % 2 != 0);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}