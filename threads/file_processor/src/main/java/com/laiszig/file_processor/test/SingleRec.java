package com.laiszig.file_processor.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingleRec extends Rec {

    private static final int THRESHOLD = 100;
    private final String[] words;
    private final int start;
    private final int end;

    public SingleRec(String[] words, int start, int end) {
        this.words = words;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (end - start <= THRESHOLD) {
            return processWords(words);
        } else {
            return splitTasks();
        }
    }

    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int mid = (start + end) / 2;

        SingleRec leftTask = new SingleRec(words, start, mid);
        SingleRec rightTask = new SingleRec(words, mid, end);

        return forkJoinTasks(leftTask, rightTask);
    }
}
