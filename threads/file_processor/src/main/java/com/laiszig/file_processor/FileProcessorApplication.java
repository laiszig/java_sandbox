package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.recursive.MultiFileRecursive;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class FileProcessorApplication {

    public static void main(String[] args) throws IOException {

        // Create a ForkJoinPool with 16 threads for parallel execution
        ForkJoinPool pool = new ForkJoinPool(16);
        // Create an instance of FileReader to read from the resources package
        FileReader fileReader = new FileReader("txt");
        // Process the files, which returns a list of String arrays representing the contents
        List<String[]> fileArrays = fileReader.processFiles();

        // Create a MultiFileRecursive task to process the list of file arrays concurrently
        MultiFileRecursive multiFileTask = new MultiFileRecursive(fileArrays);
        // Invoke the task using the ForkJoinPool to execute it in parallel and collect the results
        Map<String, Integer> multiResult = pool.invoke(multiFileTask);

        // Iterate through the results and print each word's occurrence
        for(Map.Entry<String, Integer> entry : multiResult.entrySet()) {
            System.out.println(entry.getKey().toUpperCase() + " number of occurrences: " + entry.getValue());
        }

    }
}
