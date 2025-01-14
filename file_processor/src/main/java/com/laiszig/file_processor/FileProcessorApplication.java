package com.laiszig.file_processor;

import com.laiszig.file_processor.reader.FileReader;
import com.laiszig.file_processor.threadpool.ThreadPool;

import java.io.File;
import java.io.IOException;

public class FileProcessorApplication {

    public static void main(String[] args) throws Exception {

//        FileReader.readFile("random_words_1.txt");

//        ThreadPool threadPool = new ThreadPool(3, 5);
//
//        for (int i = 0; i < 10; i++) {
//            int taskNo = i;
//            threadPool.execute(() -> {
//                try {
//                    FileReader.readFile("random_words_1.txt");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//        threadPool.waitUntilAllTasksFinished();
//        threadPool.stop();

        FileReader fileReader = new FileReader();
        for(String s : fileReader.getResourceFiles("txt")) {
            System.out.println("******** Reading file: " + s + " ********");
            System.out.println("*****************************************");
            FileReader.readFile(s);
        }
    }
}
