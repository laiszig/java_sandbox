package Exercise_2;

/*
2. Write a Java program to implement a lambda expression to check if a given string is empty.
 */

interface StringCheck {

    boolean isStringEmpty(String string);
}

class Test {

    public static void main(String[] args) {

        StringCheck stringCheck = string -> string.isEmpty();
        /* Or
        StringCheck stringCheck = String::isEmpty;
         */

        String s1 = "";
        String s2 = "Hello";
        System.out.println(stringCheck.isStringEmpty(s1));
        System.out.println(stringCheck.isStringEmpty(s2));

    }
}