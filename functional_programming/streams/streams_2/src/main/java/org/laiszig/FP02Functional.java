package org.laiszig;

import java.util.Comparator;
import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Docker", "Kubernetes");

        int sum = addListFunctional(numbers);
        System.out.println(sum);
        System.out.println("--------");
        numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x:y);

        System.out.println("----Print Distinct Numbers----");
        printDistinct(numbers);
        System.out.println("----Sort Numbers----");
        sortNumbers(numbers);
        System.out.println("----Sort Courses----");
        sortCourses(courses);
        System.out.println("----Sort Courses in Reverse----");
        sortReverseCourses(courses);
        System.out.println("----Sort Courses By Length----");
        sortByLengthCourses(courses);

    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                //Combine them into one result => One Value
                //0 and (a,b) -> a + b
//                .reduce(0, FP02Functional::sum);
//                .reduce(0, (x,y) -> x+y);
                .reduce(0, Integer::sum);
    }

    private static void printDistinct (List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void sortNumbers (List<Integer> numbers) {
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void sortCourses (List<String> courses) { //Natural order
        courses.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void sortReverseCourses (List<String> courses) {
        courses.stream()
                .sorted(Comparator.reverseOrder()) //Comparator, how can I compare 2 items in a list
                .forEach(System.out::println);
    }

    private static void sortByLengthCourses (List<String> courses) {
        courses.stream()
//                .sorted(Comparator.comparing(str -> str.length()))
                .sorted(Comparator.comparing(String::length)) //Comparator, how can I compare 2 items in a list
                .forEach(System.out::println);
    }
}