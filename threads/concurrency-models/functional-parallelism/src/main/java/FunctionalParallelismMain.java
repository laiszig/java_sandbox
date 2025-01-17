import java.util.concurrent.ForkJoinPool;

public class FunctionalParallelismMain {

    public static void main(String[] args) {

        // Create a large array to sum
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill array with numbers 1 to 100
        }

        // Create ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Submit the main task
        SumTask task = new SumTask(numbers, 0, numbers.length);
        long result = pool.invoke(task);

        // Print the result
        System.out.println("Total sum: " + result);
    }
}
