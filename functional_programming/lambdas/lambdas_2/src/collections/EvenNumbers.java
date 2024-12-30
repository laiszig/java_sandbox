package collections;

import java.util.Arrays;
import java.util.List;

public class EvenNumbers {

    public static void main(String[] args) {

        System.out.println("Print all even numbers on the list");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });
    }
}
