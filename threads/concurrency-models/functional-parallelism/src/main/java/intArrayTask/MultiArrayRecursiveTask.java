package intArrayTask;

import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class MultiArrayRecursiveTask extends RecursiveTask<Integer> {
    private List<int[]> arrays;
    private static final int ARRAY_THRESHOLD = 2;  // Split list if more than 2 arrays
    private static final int CHUNK_THRESHOLD = 1000; // Split arrays into chunks of 1000 entries

    public MultiArrayRecursiveTask(List<int[]> arrays) {
        this.arrays = arrays;
    }

    @Override
    protected Integer compute() {
        if (arrays.size() > ARRAY_THRESHOLD) {
            // Split the list of arrays
            List<MultiArrayRecursiveTask> subtasks = createArraySubtasks();
            return ForkJoinTask.invokeAll(subtasks)
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            // Process each array in this subtask
            return arrays.stream()
                    .mapToInt(this::processArray)
                    .sum();
        }
    }

    private List<MultiArrayRecursiveTask> createArraySubtasks() {
        List<MultiArrayRecursiveTask> subtasks = new ArrayList<>();
        int midpoint = arrays.size() / 2;
        subtasks.add(new MultiArrayRecursiveTask(arrays.subList(0, midpoint)));
        subtasks.add(new MultiArrayRecursiveTask(arrays.subList(midpoint, arrays.size())));
        return subtasks;
    }

    private int processArray(int[] array) {
        if (array.length > CHUNK_THRESHOLD) {
            // Split the array into smaller chunks
            List<CustomRecursiveTask> chunkTasks = createChunkSubtasks(array);
            return ForkJoinTask.invokeAll(chunkTasks)
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            // Process the array directly if it's small enough
            return processing(array);
        }
    }

    private List<CustomRecursiveTask> createChunkSubtasks(int[] array) {
        List<CustomRecursiveTask> subtasks = new ArrayList<>();
        int chunkSize = CHUNK_THRESHOLD;
        for (int i = 0; i < array.length; i += chunkSize) {
            int end = Math.min(array.length, i + chunkSize);
            subtasks.add(new CustomRecursiveTask(Arrays.copyOfRange(array, i, end)));
        }
        return subtasks;
    }

    private int processing(int[] array) {
        // Process the chunk directly
        return Arrays.stream(array)
                .filter(a -> a > 10 && a < 27)
                .map(a -> a * 10)
                .sum();
    }

    public static void main(String[] args) {
        // Create a list of 10 large arrays, each with 15k random entries
        List<int[]> bigArrays = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int[] largeArray = random.ints(15_000, 0, 50).toArray();
            bigArrays.add(largeArray);
        }

        // Process the list using MultiArrayRecursiveTask
        ForkJoinPool pool = new ForkJoinPool();
        MultiArrayRecursiveTask task = new MultiArrayRecursiveTask(bigArrays);
        int result = pool.invoke(task);

        System.out.println("Result: " + result);
    }
}
