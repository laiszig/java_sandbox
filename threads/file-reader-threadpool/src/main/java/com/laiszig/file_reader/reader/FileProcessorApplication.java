package com.laiszig.file_reader.reader;


import com.laiszig.file_reader.reader.reader.FileReader;
import com.laiszig.file_reader.reader.threadpool.ThreadPool;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileProcessorApplication {

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 5);

        FileReader fileReader = new FileReader();
        List<String> resources = fileReader.getResourceFiles("txt");

        for(int i = 0; i < resources.size(); i++) {
            int finalI = i;
            threadPool.execute(() -> {
                        try {
                            Map<String, Integer> occurrencesMap = fileReader.processFiles(resources.get(finalI));
                            fileReader.printOccurrences(occurrencesMap);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
