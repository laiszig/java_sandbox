package org.laiszig.Exercises;

import java.util.List;

public class Exercise5 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllOddNumbersCubesInListFunctional(numbers);

    }

    private static void printAllOddNumbersCubesInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }
}
