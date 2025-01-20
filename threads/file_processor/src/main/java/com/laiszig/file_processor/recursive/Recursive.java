package com.laiszig.file_processor.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public abstract class Recursive extends RecursiveTask<Map<String, Integer>> {

    abstract ConcurrentHashMap<String, Integer> splitTasks();

    protected ConcurrentHashMap<String, Integer> forkJoinTasks(Recursive leftTask, Recursive rightTask) {
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
