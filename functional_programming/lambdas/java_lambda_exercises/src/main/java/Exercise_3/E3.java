package Exercise_3;

/*
3. Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
 */

import java.util.ArrayList;
import java.util.List;

class Test {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("dfg");
        strings.add("hij");

        List<String> stringsUpper = strings.stream().map(String::toUpperCase).toList();

        for (String s : stringsUpper) {
            System.out.println(s);
        }
    }
}
