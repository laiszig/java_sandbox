package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class IsEmptyMethod {

    public static void main(String[] args) {

        Collection<String> letters = new ArrayList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");

        if(letters.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Letters: " + letters);
        }
    }
}
