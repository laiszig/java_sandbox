package Exercise_3;

import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List stringList = Arrays.asList("Red", "Green", "Blue", "PINK");

        // Print the original strings
        System.out.println("\nOriginal strings:");
        for (String str : stringList) {
            System.out.println(str);
        }

        // Convert strings to lowercase using lambda expression
        stringList.replaceAll(str -> str.toLowerCase());

        // Print the list of lowercase strings
        System.out.println("\nLowercase strings:");
        for (String str : stringList) {
            System.out.println(str);
        }

        // Convert strings to uppercase using lambda expression
        stringList.replaceAll(str -> str.toUpperCase());

        // Print the list of uppercase strings
        System.out.println("\nUppercase strings:");
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}

/*
The replaceAll() method applies a lambda expression that converts each string in the list to uppercase using the toUpperCase() method.
This lambda expression is (str -> str.toUpperCase()).
After that, the replaceAll() method applies a lambda expression that converts each string in the list to lowercase using the toLowerCase method.
This lambda expression is (str -> str.toLowerCase()).
 */