package com.arshshaikh.aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static String readFileAsString(String path) {
        String filePath = "src/test/resources/" + path;

        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFileAsList(String path) {
        String filePath = "src/test/resources/" + path;

        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
