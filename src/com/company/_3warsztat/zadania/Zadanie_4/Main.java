package com.company._3warsztat.zadania.Zadanie_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("./src/com/company/_3warsztat/zadania");

        List<Path> sortedPath = Collections.emptyList();

        try {
            sortedPath = Files.walk(path)
                    .filter(p -> Files.isRegularFile(p))
                    .sorted(Comparator.comparing(file -> getFileTime(file)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.printf("Errors during Files.walk() " + path + ", message " + e.getMessage() + "%n");
        }

        if(sortedPath.isEmpty()){
            System.out.println("ile not found");
            return;
        }

        Path oldestFile = sortedPath.get(0);
        Path newsFile = sortedPath.get(sortedPath.size() - 1);
        try {
            System.out.println("oldest file is : " + oldestFile + " was modified "+ Files.getLastModifiedTime(oldestFile));
            System.out.println("news file is: " + newsFile + " was modified " + Files.getLastModifiedTime(newsFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static FileTime getFileTime(Path path) {
        try {
            return Files.getLastModifiedTime(path);
        } catch (IOException e) {
            System.err.printf("Unable to get file for path: " + path + ", message: " + e.getMessage());
        }
        return FileTime.fromMillis(0);
    }
}
