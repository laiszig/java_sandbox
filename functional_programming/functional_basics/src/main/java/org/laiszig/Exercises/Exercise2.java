package org.laiszig.Exercises;

//List all courses individually

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Docker", "Kubernetes");

        courses.stream()
                .forEach(System.out::println);
    }
}
