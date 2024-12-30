package org.laiszig;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

//        courses.stream()
//                .map(str -> str.toUpperCase()) // instance method
//                .forEach(str -> System.out.println(str)); //static method

        Supplier<String> supplier = String::new; // constructor reference
//        Supplier<String> supplier = () -> new String();
    }
}
