package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;

public class ClearList {

    public static void main(String[] args) {

        Collection<String> books = new ArrayList<>();

        books.add("Java");
        books.add("Php");
        books.add("Python");
        books.add("SQL");

        System.out.println("List of books: " + books);

        books.clear();

        System.out.println("List after clearing: " + books);
    }
}
