package com.laiszig.file_processor.test;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.recursive.MultiFileRecursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class MultiRec extends Rec {

    private List<String[]> listOfArrays;
    private static final int LIST_THRESHOLD = 3;  // Split list if more than 2 arrays
    private static final int ARRAY_THRESHOLD = 200; // Split arrays into chunks of 1000 entries

    public MultiRec(List<String[]> listOfArrays) {
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
        // Process the array directly if it's small enough
        if (array.length <= ARRAY_THRESHOLD) {
            return processWords(array);
        }
        // Split the array into smaller chunks
        SingleRec sRec = new SingleRec(array, 0, array.length);
        return sRec.splitTasks();
    }

    @Override
    public ConcurrentHashMap<String, Integer> splitTasks() {
        int midpoint = listOfArrays.size() / 2;

        MultiRec leftTask = new MultiRec(listOfArrays.subList(0, midpoint));
        MultiRec rightTask = new MultiRec(listOfArrays.subList(midpoint, listOfArrays.size()));

        return forkJoinTasks(leftTask, rightTask);
    }

}

class MainHere {
    public static void main(String[] args) throws IOException {
        // Multi file Task
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        List<String> resources = fileReader.getResourceFiles("txt");
        List<String[]> fileArrays = new ArrayList<>();

        for (String resource : resources) {
            String input = fileReader.readFile(resource);
            String text = input.replaceAll("[\\n\\r\\t,.]", " ").replaceAll("\\s+", " ").trim();
            String[] textArr = text.split(" ");
            fileArrays.add(textArr);
        }
        MultiRec multiFileTask = new MultiRec(fileArrays);
        Map<String, Integer> multiResult = pool.invoke(multiFileTask);

        for (Map.Entry<String, Integer> entry : multiResult.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}