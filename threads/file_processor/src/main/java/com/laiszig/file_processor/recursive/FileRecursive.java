package com.laiszig.file_processor.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    @Override
    protected Map<String, Integer> compute() {
        if (end - start <= THRESHOLD) {
            return processWords();
        } else {
            return splitTasks();
        }
    }

    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int mid = (start + end) / 2;

        FileRecursive leftTask = new FileRecursive(words, start, mid);
        FileRecursive rightTask = new FileRecursive(words, mid, end);

        return forkJoinTasks(leftTask, rightTask);
    }

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
