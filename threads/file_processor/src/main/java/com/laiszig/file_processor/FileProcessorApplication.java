package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.recursive.MultiFileRecursive;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class FileProcessorApplication {

    private final static int POOL_SIXTEEN = 16;
    private final static Path PATH = Path.of("C:\Users\Lais_Ziegler\\OneDrive - Dell Technologies\\Documents\\Personal\\github\\java_sandbox\\threads\\file_processor\\src\\main\\resources");

    public static void main(String[] args) throws IOException {

        ForkJoinPool pool = new ForkJoinPool(POOL_SIXTEEN);
        FileReader fileReader = new FileReader(PATH);
        List<String[]> processedFileLines = fileReader.processFiles();

        MultiFileRecursive multiFileTask = new MultiFileRecursive(processedFileLines);
        Map<String, Integer> multiResult = pool.invoke(multiFileTask);

        // Iterate through the results and print each word's occurrence
        for(Map.Entry<String, Integer> entry : multiResult.entrySet()) {
            System.out.println(entry.getKey().toUpperCase() + " number of occurrences: " + entry.getValue());
        }
    }
}

