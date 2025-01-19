package com.laiszig.file_processor.entity;

import com.laiszig.file_processor.intArrayTask.CustomRecursiveTask;
import com.laiszig.file_processor.intArrayTask.MultiArrayRecursiveTask;
import com.laiszig.file_processor.reader.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class MultiFileRecursiveTask extends RecursiveTask<Map<String, Integer>> {

    private List<String[]> arrays;
    private static final int ARRAY_THRESHOLD = 1;  // Split list if more than 2 arrays
    private static final int CHUNK_THRESHOLD = 1000; // Split arrays into chunks of 1000 entries

    public MultiFileRecursiveTask(List<String[]> arrays) {
        this.arrays = arrays;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (arrays.size() > ARRAY_THRESHOLD) {
            // Split the list of arrays
            List<MultiFileRecursiveTask> subtasks = createArraySubtasks();
            return ForkJoinTask.invokeAll(subtasks)
                    .stream()
                    .map(ForkJoinTask::join)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
        } else {
            // Process each array in this subtask
            return arrays.stream()
                    .map(this::processArray)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
        }
    }

    private List<MultiFileRecursiveTask> createArraySubtasks() {
        List<MultiFileRecursiveTask> subtasks = new ArrayList<>();
        int midpoint = arrays.size() / 2;
        subtasks.add(new MultiFileRecursiveTask(arrays.subList(0, midpoint)));
        subtasks.add(new MultiFileRecursiveTask(arrays.subList(midpoint, arrays.size())));
        return subtasks;
    }

    private Map<String, Integer> processArray(String[] array) {
        if (array.length > CHUNK_THRESHOLD) {
            // Split the array into smaller chunks
            List<ReaderRecursiveTask> chunkTasks = createChunkSubtasks(array);

            return ForkJoinTask.invokeAll(chunkTasks)
                    .stream()
                    .map(ForkJoinTask::join)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
        } else {
            // Process the array directly if it's small enough
            return processing(array);
        }
    }

    private List<ReaderRecursiveTask> createChunkSubtasks(String[] array) {
        List<ReaderRecursiveTask> subtasks = new ArrayList<>();
        int chunkSize = CHUNK_THRESHOLD;
        for (int i = 0; i < array.length; i += chunkSize) {
            int end = Math.min(array.length, i + chunkSize);
            subtasks.add(new ReaderRecursiveTask(Arrays.copyOfRange(array, i, end)));
        }
        return subtasks;
    }

    private Map<String, Integer> processing(String[] arr) {
        return Arrays.stream(arr)
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum));
    }
}

class MainMulti {
    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        List<String> resources = fileReader.getResourceFiles("txt");
        List<String[]> fileArrays = new ArrayList<>();

        for(int i = 0; i < resources.size(); i++) {
            int finalI = i;
            String text = fileReader.readFile(resources.get(finalI));
            String[] textArr = text.split(" ");
            fileArrays.add(textArr);
        }
        MultiFileRecursiveTask task = new MultiFileRecursiveTask(fileArrays);
        Map<String, Integer> result = pool.invoke(task);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}
