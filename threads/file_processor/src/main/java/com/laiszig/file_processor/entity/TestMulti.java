package com.laiszig.file_processor.entity;

import com.laiszig.file_processor.reader.FileReader;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class TestMulti extends RecursiveTask<Map<String, Integer>> {

    private List<String[]> listOfArrays;
    private static final int LIST_THRESHOLD = 2;  // Split list if more than 2 arrays
    private static final int ARRAY_THRESHOLD = 200; // Split arrays into chunks of 1000 entries

    public TestMulti(List<String[]> listOfArrays) {
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
                ConcurrentHashMap<String, Integer> innerMap = new ConcurrentHashMap<>(processListSubtask());
                innerMap.forEach((key, value) -> map.merge(key, value, Integer::sum));
            return map;
        }
    }

    private ConcurrentHashMap<String, Integer> processListSubtask() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int midpoint = listOfArrays.size() / 2;

        TestMulti leftTask = new TestMulti(listOfArrays.subList(0, midpoint));
        TestMulti rightTask = new TestMulti(listOfArrays.subList(midpoint, listOfArrays.size()));

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }

    private Map<String, Integer> processArray(String[] array) {
        // Process the array directly if it's small enough
        if (array.length <= ARRAY_THRESHOLD) {
            return processing(array);
        }
        // Split the array into smaller chunks
        return createSubTasks(array);
    }

    private Map<String, Integer> processing(String[] arr) {
        return Arrays.stream(arr)
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum));
    }

    private ConcurrentHashMap<String, Integer> createSubTasks(String[] words) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int mid = (words.length) / 2;

        Test leftTask = new Test(words, 0, mid);
        Test rightTask = new Test(words, mid, words.length);

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }
}

class MainMulti2 {
    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        List<String> resources = fileReader.getResourceFiles("txt");
        List<String[]> fileArrays = new ArrayList<>();

        for(int i = 0; i < resources.size(); i++) {
            int finalI = i;
            String input = fileReader.readFile(resources.get(finalI));
            String text = input.replaceAll("[\\n\\r\\t,.]", " ").replaceAll("\\s+", " ").trim();
            String[] textArr = text.split(" ");
            fileArrays.add(textArr);
        }
        TestMulti task = new TestMulti(fileArrays);
        Map<String, Integer> result = pool.invoke(task);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}
