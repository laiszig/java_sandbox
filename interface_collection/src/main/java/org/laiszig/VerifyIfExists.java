package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class VerifyIfExists {

    public static void main(String[] args) {

        Collection<String> vowels = new ArrayList<>();

        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");

        System.out.println("Does it contain the vowel I? " + vowels.contains("I"));
        System.out.println("List of vowels: " + vowels);
    }
}
