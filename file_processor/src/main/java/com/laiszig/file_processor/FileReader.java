package com.laiszig.file_processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileReader {

    public static void readFile(String path) throws IOException {
        ClassLoader classLoader = FileProcessorApplication.class.getClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(classLoader.getResourceAsStream(path))))) {
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                Map<String, Integer> mappedOccurrences = countWordOccurrence(everything);
                printOccurrences(mappedOccurrences);
            } finally {
                br.close();
            }
        }
    }

    private static Map<String, Integer> countWordOccurrence(String string) {
        String[] a = string.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : a) {
            if(word.isEmpty()) {
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

    private static void printOccurrences(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " number of occurrences: " + entry.getValue());
        }
    }

}
