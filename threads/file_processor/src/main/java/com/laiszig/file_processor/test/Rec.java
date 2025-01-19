package com.laiszig.file_processor.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public abstract class Rec extends RecursiveTask<Map<String, Integer>> {

    abstract ConcurrentHashMap<String, Integer> splitTasks();

    protected ConcurrentHashMap<String, Integer> processWords(String[] words) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (String word : words) {
            if (word.isBlank()) continue;
            map.merge(word, 1, Integer::sum);
        }
        return map;
    }

    protected static ConcurrentHashMap<String, Integer> forkJoinTasks(Rec leftTask, Rec rightTask) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));

        return map;
    }


}
