package com.laiszig.file_processor.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

/**
 * This class represents a generic recursive task that processes data
 * It contains one abstract method to be implemented by the subclasses, to define how tasks are split
 * It contains a helper method used by the subclasses to fork and join tasks
 */
public abstract class Recursive extends RecursiveTask<Map<String, Integer>> {

    abstract ConcurrentHashMap<String, Integer> splitTasks();

    /**
     * Helper method to fork and join two tasks
     * 1. Initialize a concurrent map to stored merged results
     * 2. Fork the left and right tasks to execute them asynchronously
     * 3. Join the results of the left and right tasks (blocks until completion)
     * 4. Merge the results of both tasks into the map
     * @return A combined map with merged results from the two tasks.
     */
    protected ConcurrentHashMap<String, Integer> forkJoinTasks(Recursive leftTask, Recursive rightTask) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.join();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));

        return map;
    }

}
