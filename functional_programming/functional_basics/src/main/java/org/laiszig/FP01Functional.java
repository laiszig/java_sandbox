package org.laiszig;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        printAllNumbersInListStructure(numbers);
        System.out.println("----------------");
//        printAllEvenNumbersInListFunctional(numbers);
        printSquaresOfAllEvenNumbersInListFunctional(numbers);
    }

    private static void print(int number) {
        System.out.println(number);
    }

//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
//        numbers.stream()
//                .forEach(FP01Functional::print); //Method Reference

        numbers.stream()
                .forEach(System.out::println);
    }

    private static void printAllEvenNumbersInListFunctional (List<Integer> numbers) {
        //How to loop the numbers
        numbers.stream()
                //Filter - Only allow Even Numbers
//                .filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0) // Lambda Expression
                .forEach(System.out::println);
    }

    private static void printSquaresOfAllEvenNumbersInListFunctional (List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .forEach(System.out::println);
    }
}
