package com.company._3warsztat.zadania.Zadanie_7;

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
        Path path = Paths.get("./src/com/company/_3warsztat/zadania/Zadanie_7/lorem7.txt");
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
}

