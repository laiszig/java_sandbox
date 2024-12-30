package org.laiszig.Exercises;

//Print courses with names longer than 4 letters

import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Docker", "Kubernetes");

        courses.stream()
                .filter(course -> course.length() > 4)
                .forEach(System.out::println);
    }
}
