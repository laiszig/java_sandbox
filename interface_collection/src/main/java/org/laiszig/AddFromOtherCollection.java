package org.laiszig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AddFromOtherCollection {

    public static void main(String[] args) {

        Collection<String> vowels = new ArrayList();

        vowels.add("A");
        vowels.add("E");
        vowels.add("I");

        Collection<String> vowels2 = Arrays.asList("O", "U");

        //RECEIVES ALL ELEMENTS FROM THE COLLECTION2
        vowels.addAll(vowels2);

        System.out.println("List of vowels: " + vowels);


    }
}
