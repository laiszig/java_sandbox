package com.laiszig.file_processor.entity;


import com.laiszig.file_processor.intArrayTask.MultiArrayRecursiveTask;
import com.laiszig.file_processor.reader.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ReaderRecursiveTask extends RecursiveTask<Map<String, Integer>> {

    private String[] wordsFromTxt;

    private static final int THRESHOLD = 12;

    public ReaderRecursiveTask(String[] wordsFromTxt) {
        this.wordsFromTxt = wordsFromTxt;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (wordsFromTxt.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .map(ForkJoinTask::join)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
        } else {
            return processing(wordsFromTxt);
        }
    }


    private Collection<ReaderRecursiveTask> createSubtasks() {
        List<ReaderRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ReaderRecursiveTask(
                Arrays.copyOfRange(wordsFromTxt, 0, wordsFromTxt.length / 2)));
        System.out.println(Thread.currentThread().getName());
        dividedTasks.add(new ReaderRecursiveTask(
                Arrays.copyOfRange(wordsFromTxt, wordsFromTxt.length / 2, wordsFromTxt.length)));
        System.out.println(Thread.currentThread().getName());
        return dividedTasks;
    }

    private Map<String, Integer> processing(String[] arr) {
        return Arrays.stream(arr)
                .filter(word -> !word.isBlank())
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum));
    }

}

class Main {
    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        FileReader fileReader = new FileReader();
        String text = fileReader.readFile("random_words_1.txt");
        String[] textArr = text.split(" ");
        ReaderRecursiveTask task = new ReaderRecursiveTask(textArr);
        Map<String, Integer> result = pool.invoke(task);

        for(Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }
}
