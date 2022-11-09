package collections;

import java.util.*;

public class Person {

    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}

class Main {

    public static void main(String[] args) {

        System.out.println("Sort people by name:");
        List<Person> listPeople = Arrays.asList(new Person("Edward", 29),
        new Person("John", 32), new Person("Julie", 26));
        Collections.sort(listPeople, new Comparator<Person>() {

            @Override
            public int compare(Person person1, Person person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });
        listPeople.forEach(person -> System.out.println(person.getName()));

        System.out.println("------------------");
        System.out.println("Sort people by age");
        Collections.sort(listPeople, new Comparator<Person>() {

            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge().compareTo(person2.getAge());
            }
        });
        listPeople.forEach(person -> System.out.println(person.getName()));
    }
}
