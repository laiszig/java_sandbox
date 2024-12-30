package org.laiszig.exercises;

import java.util.List;

//Find sum of odd numbers in a list
public class Exercise9 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = sumOfOddNumbers(numbers);
        System.out.println(sum);

    }

    private static int sumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum);
    }
}
