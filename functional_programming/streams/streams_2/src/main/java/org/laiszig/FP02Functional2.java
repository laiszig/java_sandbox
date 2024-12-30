package org.laiszig;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional2 {

    public static void main(String[] args) {

    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


    List<Integer> doubledNumbers = doubleList(numbers);
        System.out.println(doubledNumbers);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number)
                .collect(Collectors.toList());
    }
}

/*
There 2 types of Streams.
 > Methods that return streams are Intermediate Operations
ex: Distinct, sorted, map, filter
 > When the return is void, they are Terminal operations
 ex: forEach()
 > When they return a specific type, they are also Terminal.
ex: collect
 Everytime they return something other than a stream, they are terminal operations.
 */