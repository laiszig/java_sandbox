package methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class Main4 {

    public static void main(String[] args) {

        System.out.println("Create list with elements");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        System.out.println("Multiply all elements by 5:");
        performOperation(list, (n) -> n * 5);

        System.out.println("Calculate square of all elements in the list:");
        performOperation(list, (n) -> n * n);

        System.out.println("Add 3 to all elements in the list:");
        performOperation(list, (n) -> n + 3);

        System.out.println("Puts 0 on all the elements in the list:");
        performOperation(list, (n) -> 0);
    }

    private static void performOperation(List<Integer> list, IntFunction<Integer> function) {
        list.forEach(n -> {
            n = function.apply(n);
            System.out.println(n + " ");
        });
    }

}
