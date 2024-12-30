package org.laiszig.exercises;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise11 {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Docker", "Kubernetes");

        List<Integer> coursesLengths = listOfCoursesLengths(courses);
        System.out.println(coursesLengths);

    }

    private static List<Integer> listOfCoursesLengths(List<String> courses) {
        return courses.stream()
                .map(String::length)
//                .map(course -> course.length())
                .collect(Collectors.toList());
    }
}
