package org.laiszig.exercises;

import java.util.List;
// Cube every number in a list and find the sum of cubes
public class Exercise8 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = cubeEveryNumberAndFindSumOfCubes(numbers);
        System.out.println(sum);
    }

    private static int cubeEveryNumberAndFindSumOfCubes(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
    }
}
