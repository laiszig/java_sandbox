package com.laiszig.file_reader.reader.reader;

import com.laiszig.file_reader.reader.FileProcessorApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FileReader {

    public Map<String, Integer> processFiles (String resource) throws IOException {
        String fileString = readFile(resource);
        return countWordOccurrence(fileString);
    }

    public String readFile(String path) throws IOException {
        ClassLoader classLoader = FileProcessorApplication.class.getClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(classLoader.getResourceAsStream("txt/" + path))))) {
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                return sb.toString();
            } finally {
                br.close();
            }
        }
    }

    public Map<String, Integer> countWordOccurrence(String string) {
        String[] a = string.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : a) {
            if(word.isBlank()) {
                continue;
            }
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            }
            else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public void printOccurrences(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue() + " ------------------> Printed by: " + Thread.currentThread().getName());
        }
    }

    public List<String> getResourceFiles(String path) throws IOException {
        List<String> filenames = new ArrayList<>();

        try (
                InputStream in = getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
            }
        }
        return filenames;
    }

    private InputStream getResourceAsStream(String resource) {
        ClassLoader classLoader = FileProcessorApplication.class.getClassLoader();
        final InputStream in
                = classLoader.getResourceAsStream(resource);

        return in == null ? getClass().getResourceAsStream(resource) : in;
    }

}
