package org.laiszig;

import java.util.List;

public class FP01Structural {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        printAllNumbersInListStructure(numbers);
        System.out.println("----------------");
        printAllEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructure(List<Integer> numbers) {

        //How to loop the numbers
        for(int number:numbers) {
            System.out.println(number);
        }
    }

    private static void printAllEvenNumbersInListStructured (List<Integer> evenNumbers) {
        //How to loop the numbers
        for(int number:evenNumbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
