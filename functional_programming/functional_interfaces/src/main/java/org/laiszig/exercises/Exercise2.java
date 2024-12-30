package org.laiszig.exercises;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise2 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> squaredNumbers = mapAndCreateList(numbers, x -> x * x);
        List<Integer> cubedNumbers = mapAndCreateList(numbers, x -> x * x * x);

        System.out.println(squaredNumbers);
        System.out.println(cubedNumbers);
    }

    private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

}
