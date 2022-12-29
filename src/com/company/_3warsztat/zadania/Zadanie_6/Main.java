package com.company._3warsztat.zadania.Zadanie_6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/com/company/_3warsztat/zadania/Zadanie_6/lorem.txt");
        convertFileToUppercase(path);
        countWordsInFile(path);

    }

    private static void countWordsInFile(Path path) {
        try {
            long count = Files.lines(path)
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .count();
            System.out.println("words in file: " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertFileToUppercase(Path path) {
        List<String> uppercaseLine = readFileAsUppercase(path);
        writeFile(path, uppercaseLine);
        System.out.println(uppercaseLine);
    }

    private static void writeFile(Path path, List<String> uppercaseLine) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String uppercase : uppercaseLine) {
                writer.write(uppercase);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.printf("Error reading path: %s, message %s%n", path, e.getMessage());
        }
    }

    private static List<String> readFileAsUppercase(Path path) {
        try {
            return Files.lines(path)
                    .map(line -> line.toUpperCase())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.printf("Error reading path: %s, message %s%n", path, e.getMessage());
        }
        return Collections.emptyList();
    }
}
