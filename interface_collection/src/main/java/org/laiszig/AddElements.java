package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class AddElements {

    public static void main(String[] args) {

        Collection<String> names = new ArrayList<>();
        names.add("John");
        names.add("Helen");
        names.add("Dave");
        names.add("Pete");
        names.add("Norman");

        System.out.println("List of names: " + names);
    }
}
