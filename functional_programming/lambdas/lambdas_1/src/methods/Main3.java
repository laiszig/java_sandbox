package methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("Create list with elements");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        System.out.println("Print all numbers: ");
        evaluateExpression(list, (n) -> true);

        System.out.println("Print no numbers: ");
        evaluateExpression(list, (n) -> false);

        System.out.println("Print all even numbers: ");
        evaluateExpression(list, (n) -> n%2 == 0);

        System.out.println("Print all odd numbers: ");
        evaluateExpression(list, (n) -> n%2 == 1);

        System.out.println("Print numbers greater than 5: ");
        evaluateExpression(list, (n) -> n > 5);

        System.out.println("Print numbers greater than 5 and less than 10: ");
        evaluateExpression(list, (n) -> n > 5 && n < 10);
    }

    private static void evaluateExpression(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(n -> {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        });
    }
}
