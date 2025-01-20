package com.laiszig.file_processor.recursive;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MultiFileRecursive extends Recursive {

    private List<String[]> listOfArrays;
    private static final int LIST_THRESHOLD = 3;  // Split list if more than 2 arrays

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
            ConcurrentHashMap<String, Integer> innerMap = new ConcurrentHashMap<>(splitTasks());
            innerMap.forEach((key, value) -> map.merge(key, value, Integer::sum));
            return map;
        }
    }

    private Map<String, Integer> processArray(String[] array) {
        FileRecursive sRec = new FileRecursive(array, 0, array.length);
        return sRec.compute();
    }

    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int midpoint = listOfArrays.size() / 2;

        MultiFileRecursive leftTask = new MultiFileRecursive(listOfArrays.subList(0, midpoint));
        MultiFileRecursive rightTask = new MultiFileRecursive(listOfArrays.subList(midpoint, listOfArrays.size()));

        return forkJoinTasks(leftTask, rightTask);
    }

}