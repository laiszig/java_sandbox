package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Collection<String> nameList = new ArrayList<>();
        nameList.add("John");
        nameList.add("Helen");
        nameList.add("Dave");
        nameList.add("Pete");
        nameList.add("Norman");
        nameList.add("Damien");
        nameList.add("Dimitri");

        nameList.stream()
                .map(String::toUpperCase)
                .sorted()
                .filter(s -> s.startsWith("D"))
                .forEach(System.out::println);
    }
}