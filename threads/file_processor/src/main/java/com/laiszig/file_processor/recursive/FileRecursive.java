package com.laiszig.file_processor.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Concrete implementation of Recursive for processing an array of words in parallel
 * THRESHOLD is used to decide whether to process words directly or split tasks
 */
public class FileRecursive extends Recursive {

    private static final int THRESHOLD = 3000;
    private final String[] words;
    private final int start;
    private final int end;

    public FileRecursive(String[] words, int start, int end) {
        this.words = words;
        this.start = start;
        this.end = end;
    }

    /**
     * Compute method to determine if the task should be processed directly or split into smaller tasks.
     * If the task size is below the threshold, process words directly
     * Otherwise, split the task into smaller subtasks.
     */
    @Override
    protected Map<String, Integer> compute() {
        if (end - start <= THRESHOLD) {
            return processWords();
        } else {
            return splitTasks();
        }
    }

    /**
     * 1. Calculate the midpoint for dividing the task
     * 2. Create left and right subtasks
     * 3. Use helper method to fork and join the subtasks
     */
    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int mid = (start + end) / 2;

        FileRecursive leftTask = new FileRecursive(words, start, mid);
        FileRecursive rightTask = new FileRecursive(words, mid, end);

        return forkJoinTasks(leftTask, rightTask);
    }

    /**
     * Processes the range of words directly
     * 1. Initialize a map to store word frequencies.
     * 2. Iterate over the range and count word occurrences skipping blanks
     * 3. Increment the count for each word.
     * @return A map of word frequencies in the given range.
     */
    public ConcurrentHashMap<String, Integer> processWords() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = start; i < end; i++) {
            String word = words[i];
            if (word.isBlank()) continue;
            map.merge(word, 1, Integer::sum);
        }
        return map;
    }
}
