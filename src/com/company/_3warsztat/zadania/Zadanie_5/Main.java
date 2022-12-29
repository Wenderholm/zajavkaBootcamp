package com.company._3warsztat.zadania.Zadanie_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("./src/com/company/_3warsztat/zadania/Zadanie_5/lorem.txt");
        printSpecificWord(path);
    }

    private static void printSpecificWord(Path path) throws IOException {
        TreeMap<Integer, List<String>> collect = Files.lines(path)
                .map(line -> line.replace(",", "").replace(".", ""))
                .flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(word -> word.length(), TreeMap::new, Collectors.toList()));

        Integer maxLengthWord = collect.keySet().stream().max(Comparator.comparingInt(a -> a)).orElse(0);

        System.out.println("Second longest words: " + collect.get(maxLengthWord).get(1));
        System.out.println("Second 3letter words: " + collect.get(3).get(1));
        System.out.println(collect);
    }
}
