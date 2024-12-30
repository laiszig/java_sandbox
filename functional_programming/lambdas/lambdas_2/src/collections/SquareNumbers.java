package collections;

import java.util.Arrays;
import java.util.List;

public class SquareNumbers {

    public static void main(String[] args) {
        System.out.println("Print the square of all the elements on the list");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n *n));
    }
}
