package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.recursive.MultiFileRecursive;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class FileProcessorApplication {

    public static void main(String[] args) throws IOException {

        ForkJoinPool pool = new ForkJoinPool(16);
        FileReader fileReader = new FileReader("txt");
        List<String[]> fileArrays = fileReader.processFiles();

        MultiFileRecursive multiFileTask = new MultiFileRecursive(fileArrays);
        Map<String, Integer> multiResult = pool.invoke(multiFileTask);

        for(Map.Entry<String, Integer> entry : multiResult.entrySet()) {
            System.out.println(entry.getKey().toUpperCase() + " number of occurrences: " + entry.getValue());
        }

    }
}
