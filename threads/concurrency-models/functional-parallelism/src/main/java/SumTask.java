import java.util.concurrent.RecursiveTask;

/**
 * We create a custom class extending RecursiveTask<Long> for the sum operation.
 * This task divides the array into smaller chunks, processes them recursively, and combines the results.
 */
public class SumTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10; // Chunk size to stop slitting further
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println("Processing range: " + start + " to " + (end - 1));
        if(end - start <= THRESHOLD) {
            // Base case: directly compute the sum for small chunks
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            System.out.println("Computed sum from index " + start + " to " + (end - 1) + ": " + sum);
            return sum;
        } else {
            // Recursive case: split the task
            int mid = (start + end) / 2;
            System.out.println("Splitting range: " + start + " to " + (end - 1) + " into " + start + " to " + (mid - 1) + " and " + mid + " to " + (end - 1));

            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);

            // Fork both subtasks
            leftTask.fork();
            rightTask.fork();

            //Join the results
            long leftResult = leftTask.join();
            long rightResult = rightTask.join();

            // Combine results from both halves
            return leftResult + rightResult;
        }
    }
}
