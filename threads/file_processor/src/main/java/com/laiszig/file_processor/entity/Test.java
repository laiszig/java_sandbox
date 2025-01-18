package com.laiszig.file_processor.entity;

import com.laiszig.file_processor.reader.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            Map<String, Integer> map = new HashMap<>(Map.of());
            for (String word : words) {
                if (word.isBlank()) {
                    continue;
                }
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            return map;
        } else {
            int mid = (start + end) / 2;

            Test leftTask = new Test(words, start, mid);
            Test rightTask = new Test(words, mid, end);

            leftTask.fork();
            rightTask.fork();

            Map<String, Integer> leftResult = leftTask.join();
            Map<String, Integer>  rightResult = rightTask.join();

            return Stream.concat(
                    leftResult.entrySet().stream(), rightResult.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
        }
    }
}

class MainMethod {
    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        String input = fileReader.readFile("random_words_1.txt");
        String text = input.replaceAll("[, .]", " ");

        String[] textArr = text.split(" ");
        Test task = new Test(textArr, 0, textArr.length);
        Map<String, Integer> result = pool.invoke(task);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}
