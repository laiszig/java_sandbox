package org.laiszig.Exercises;

//Print courses containing the word Spring

import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Docker", "Kubernetes");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }
}
