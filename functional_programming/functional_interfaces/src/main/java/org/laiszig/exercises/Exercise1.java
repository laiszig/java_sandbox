package org.laiszig.exercises;

import java.util.List;
import java.util.function.BinaryOperator;

public class Exercise1 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = numbers.stream().reduce(0, sumBinaryOperator);
        System.out.println(sum);
    }

    static BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
//    static BinaryOperator<Integer> sumBinaryOperator = (x,y) => x+y;
    static BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer int1, Integer int2) {
            return int1+int2;
        }
    };

}
