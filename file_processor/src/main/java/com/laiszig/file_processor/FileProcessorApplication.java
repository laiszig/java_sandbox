package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.threadpool.ThreadPool;

import java.io.IOException;

public class FileProcessorApplication {

    public static void main(String[] args) throws Exception {

//        FileReader.readFile("random_words_1.txt");

        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPool.execute(() -> {
                String message =
                        Thread.currentThread().getName()
                            + ": Task " + taskNo;
                System.out.println(message);
            });
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
