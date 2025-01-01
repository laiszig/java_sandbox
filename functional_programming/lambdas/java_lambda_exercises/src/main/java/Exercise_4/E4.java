package Exercise_4;

/*
Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
 */
import java.util.Arrays;
import java.util.List;

class Test {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream().filter(integer -> (integer % 2 == 0)).toList();

        List<Integer> oddNumbers = numbers.stream().filter(integer -> (integer % 2 != 0)).toList();

        System.out.println("All numbers: ");
        for (Integer i : numbers) {
            System.out.println(i);
        }

        System.out.println("Even numbers: ");
        for (Integer i : evenNumbers) {
            System.out.println(i);
        }

        System.out.println("Odd numbers: ");
        for (Integer i : oddNumbers) {
            System.out.println(i);
        }

    }

}