package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.recursive.MultiFileRecursive;
import com.laiszig.file_processor.recursive.ReaderRecursive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class FileProcessorApplication {

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
        MultiFileRecursive multiFileTask = new MultiFileRecursive(fileArrays);
        Map<String, Integer> multiResult = pool.invoke(multiFileTask);

        for(Map.Entry<String, Integer> entry : multiResult.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }

        // Single File Task
        String input = fileReader.readFile("random_words_2.txt");
        String text = input.replaceAll("[\\n\\r\\t,.]", " ").replaceAll("\\s+", " ").trim();
//
        String[] textArr = text.split(" ");
        System.out.println(textArr.length);
//        ReaderRecursive singleFileTask = new ReaderRecursive(textArr, 0, textArr.length);
//        Map<String, Integer> singleResult = pool.invoke(singleFileTask);
//
//        for(Map.Entry<String, Integer> entry : singleResult.entrySet()) {
//            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
//        }
    }
}
