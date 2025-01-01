package Exercise_1;

/*
1. Write a Java program to implement a lambda expression to find the sum of two integers.
 */
interface Calculate {

    int sum(int x, int y);
}

class Test {
    public static void main(String[] args) {

        Calculate calculate = (x, y) -> x + y;
        // Or
        // Calculate calculate = Integer::sum;

        int result = calculate.sum(5, 2);
        System.out.println("Result: " + result);
    }
}