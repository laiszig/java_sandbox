package com.laiszig.file_processor.recursive;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class MultiFileRecursive extends RecursiveTask<Map<String, Integer>> {

    private List<String[]> listOfArrays;
    private static final int LIST_THRESHOLD = 3;  // Split list if more than 2 arrays
    private static final int ARRAY_THRESHOLD = 200; // Split arrays into chunks of 1000 entries

    public MultiFileRecursive(List<String[]> listOfArrays) {
        this.listOfArrays = listOfArrays;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (listOfArrays.size() <= LIST_THRESHOLD) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
            for (String[] array : listOfArrays) {
                ConcurrentHashMap<String, Integer> innerMap = new ConcurrentHashMap<>(processArray(array));
                innerMap.forEach((key, value) -> map.merge(key, value, Integer::sum));
            }
            return map;
        } else {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
                ConcurrentHashMap<String, Integer> innerMap = new ConcurrentHashMap<>(processListSubtask());
                innerMap.forEach((key, value) -> map.merge(key, value, Integer::sum));
            return map;
        }
    }

    private ConcurrentHashMap<String, Integer> processListSubtask() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int midpoint = listOfArrays.size() / 2;

        MultiFileRecursive leftTask = new MultiFileRecursive(listOfArrays.subList(0, midpoint));
        MultiFileRecursive rightTask = new MultiFileRecursive(listOfArrays.subList(midpoint, listOfArrays.size()));

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }

    private Map<String, Integer> processArray(String[] array) {
        // Process the array directly if it's small enough
        if (array.length <= ARRAY_THRESHOLD) {
            return processing(array);
        }
        // Split the array into smaller chunks
        return createSubTasks(array);
    }

    private Map<String, Integer> processing(String[] arr) {
        return Arrays.stream(arr)
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum));
    }

    private ConcurrentHashMap<String, Integer> createSubTasks(String[] words) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int mid = (words.length) / 2;

        ReaderRecursive leftTask = new ReaderRecursive(words, 0, mid);
        ReaderRecursive rightTask = new ReaderRecursive(words, mid, words.length);

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }
}