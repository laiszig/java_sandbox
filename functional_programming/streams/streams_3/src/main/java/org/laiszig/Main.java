package org.laiszig;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = getPeople();
        people.forEach(System.out::println);

    //Imperative approach

        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

    // Declarative approach

    // Filter
        List<Person> females2 = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

    // Sort

        System.out.println("-------------");

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println("-------------");

        List<Person> sortedReversed = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sortedReversed.forEach(System.out::println);

        System.out.println("-------------");

        List<Person> sortedGender = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        sortedGender.forEach(System.out::println);

    // All match

        System.out.println("-------------");

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);

    // Any match
        System.out.println("-------------");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);

    // None match
        System.out.println("-------------");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("James Bond"));
        System.out.println(noneMatch);

    // Max
        System.out.println("-------------");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    // Min
        System.out.println("-------------");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    // Group
        System.out.println("-------------");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        System.out.println("-------------");
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleAge.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz ", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}