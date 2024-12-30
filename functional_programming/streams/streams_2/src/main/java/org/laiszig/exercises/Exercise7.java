package org.laiszig.exercises;

//Square every number in a list and find the sum of squares

import java.util.List;

public class Exercise7 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = squareEveryNumberAndFindSumOfSquares(numbers);
        System.out.println(sum);
    }

    private static int squareEveryNumberAndFindSumOfSquares(List<Integer> numbers) {
       return numbers.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
    }
}
