package com.laiszig.file_processor.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class ReaderRecursive extends RecursiveTask<Map<String, Integer>> {

    private static final int THRESHOLD = 100;
    private final String[] words;
    private final int start;
    private final int end;

    public ReaderRecursive(String[] words, int start, int end) {
        this.words = words;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (end - start <= THRESHOLD) {
            return processMap();
        } else {
            return createSubTasks();
        }
    }

    public ConcurrentHashMap<String, Integer> processMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = start; i < end; i++) {
            String word = words[i];
            if (word.isBlank()) continue;
            map.merge(word, 1, Integer::sum);
        }
        return map;
    }

    private ConcurrentHashMap<String, Integer> createSubTasks() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int mid = (start + end) / 2;

        ReaderRecursive leftTask = new ReaderRecursive(words, start, mid);
        ReaderRecursive rightTask = new ReaderRecursive(words, mid, end);

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }
}