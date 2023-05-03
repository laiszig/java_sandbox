package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class IteratingElements {

    public static void main(String[] args) {

        Collection<String> vowels = new ArrayList<>();

        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");

        //ITERATES THROUGH ALL ELEMENTS

        for (String vowel : vowels) {
            System.out.println("Vowel: " + vowel);
        }
    }
}
