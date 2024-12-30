package collections;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Book {

    private String name;
    private Integer year;

    public Book(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }
}

class Main2 {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(new Book("The Shining", 1977),
                new Book("The Da Vinci Code", 2003), new Book("Eat, Pray, Love", 2006));
        System.out.println("Sorting books by name");
//        Collections.sort(bookList, (Book book1, Book book2) -> book1.getName().compareTo(book2.getName()));
        Collections.sort(bookList, Comparator.comparing(Book::getName));
        bookList.forEach(book -> System.out.println(book.getName()));

        System.out.println("Sorting books by year");
//        Collections.sort(bookList, (Book book1, Book book2) -> book1.getYear().compareTo(book2.getYear()));
        Collections.sort(bookList, Comparator.comparing(Book::getYear));
        bookList.forEach(book -> System.out.println(book.getYear()));
    }
}

/* :: Method Reference Expressions
A method reference expression is used to refer to the invocation of a method without actually performing the invocation.
Certain forms of method reference expression also allow class instance creation or array creation
to be treated as if it were a method invocation
 */