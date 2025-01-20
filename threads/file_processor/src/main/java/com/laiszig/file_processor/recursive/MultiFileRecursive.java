package com.laiszig.file_processor.recursive;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A concrete implementation of Recursive for processing multiple arrays of words
 * THRESHOLD is used to decide whether to process the list directly or split tasks
 */
public class MultiFileRecursive extends Recursive {

    private List<String[]> listOfArrays;
    private static final int THRESHOLD = 3;  // Split list if more than 2 arrays

    public MultiFileRecursive(List<String[]> listOfArrays) {
        this.listOfArrays = listOfArrays;
    }

    /**
     * Compute method to decide whether to process arrays directly or split them into smaller tasks
     * 1. If the list size is below the threshold, process each array and merge its results.
     * 2. Otherwise, split the task into smaller subtasks.
     * @return
     */
    @Override
    protected Map<String, Integer> compute() {
        if (listOfArrays.size() <= THRESHOLD) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
            for (String[] array : listOfArrays) {
                ConcurrentHashMap<String, Integer> innerMap = new ConcurrentHashMap<>(process(array));
                innerMap.forEach((key, value) -> map.merge(key, value, Integer::sum));
            }
            return map;
        } else {
            return splitTasks();
        }
    }

    private Map<String, Integer> process(String[] array) {
        FileRecursive fileRecursive = new FileRecursive(array, 0, array.length);
        return fileRecursive.compute();
    }

    /**
     * 1. Calculate the midpoint for dividing the task
     * 2. Create left and right subtasks
     * 3. Use helper method to fork and join the subtasks
     */
    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int midpoint = listOfArrays.size() / 2;

        MultiFileRecursive leftTask = new MultiFileRecursive(listOfArrays.subList(0, midpoint));
        MultiFileRecursive rightTask = new MultiFileRecursive(listOfArrays.subList(midpoint, listOfArrays.size()));

        return forkJoinTasks(leftTask, rightTask);
    }

}