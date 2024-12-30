package org.laiszig.Exercises;

import java.util.List;

public class Exercise6 {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Docker", "Kubernetes");

        courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
