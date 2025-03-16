package com.laiszig.file_processor.reader;

import com.laiszig.file_processor.FileProcessorApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {

    private final Path path;

    public FileReader(Path path) {
        this.path = path.toAbsolutePath();
    }

    public List<String[]> processFiles() throws IOException {
        List<String> resources = getResourceFiles(path);
        List<String[]> processedFileLines = new ArrayList<>();

        for (String resource : resources) {
            String input = readFile(resource);
            String text = input.replaceAll("[\\n\\r\\t,.]", " ").replaceAll("\\s+", " ").trim();
            String[] textArr = text.split(" ");
            processedFileLines.add(textArr);
        }
        return processedFileLines;
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

    public List<String> getResourceFiles(Path directoryPath) throws IOException {
        List<String> filenames = new ArrayList<>();

        try (
                InputStream in = getResourceAsStream(directoryPath.toString());
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
