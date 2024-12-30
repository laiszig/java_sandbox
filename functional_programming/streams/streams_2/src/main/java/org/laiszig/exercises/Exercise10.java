package org.laiszig.exercises;

import java.util.List;
import java.util.stream.Collectors;

//Create a list with even numbers filtered from the numbers list
public class Exercise10 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> listOfEvenNumbers = createListOfEvenNumbers(numbers);
        System.out.println(listOfEvenNumbers);
    }

    private static List<Integer> createListOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }
}
