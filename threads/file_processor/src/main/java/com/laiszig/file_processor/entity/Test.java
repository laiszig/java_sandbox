package com.laiszig.file_processor.entity;

import com.laiszig.file_processor.reader.FileReader;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Test extends RecursiveTask<Map<String, Integer>> {

    private static final int THRESHOLD = 100;
    private final String[] words;
    private final int start;
    private final int end;

    public Test(String[] words, int start, int end) {
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

        Test leftTask = new Test(words, start, mid);
        Test rightTask = new Test(words, mid, end);

        leftTask.fork();
        rightTask.fork();

        Map<String, Integer> leftResult = leftTask.join();
        Map<String, Integer>  rightResult = rightTask.compute();

        leftResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        rightResult.forEach((key, value) -> map.merge(key, value, Integer::sum));
        return map;
    }
}

class MainMethod {
    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        String input = fileReader.readFile("random_words_1.txt");
        String text = input.replaceAll("[\\n\\r\\t,.]", " ").replaceAll("\\s+", " ").trim();

        String[] textArr = text.split(" ");
        Test task = new Test(textArr, 0, textArr.length);
        Map<String, Integer> result = pool.invoke(task);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}
