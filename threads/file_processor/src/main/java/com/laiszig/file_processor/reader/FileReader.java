package com.laiszig.file_processor.reader;

import com.laiszig.file_processor.FileProcessorApplication;

import java.io.*;
import java.util.*;

public class FileReader {

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
