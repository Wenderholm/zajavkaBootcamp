package com.company._3warsztat.zadania.Zadanie_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Path src = Paths.get("src/com/company/_3warsztat/zadania/Zadanie_2");
        String extension1 = ".txt";
        String requiredContent = "zajavka";
        List<String> extensionToSkip = List.of(".docx", ".jpg", ".pdf", ".properties", ".zip", ".class", ".jar");
        printDirection(src, requiredContent, extensionToSkip);

    }

    private static void printDirection(Path src, String requiredContent, List<String> extensionToSkip) {
        try {
            Files.walk(src)
                    .filter(path -> Files.isRegularFile(path))
                    .filter(p -> !extensionToSkip.contains(finFileExtension(p)))
                    .filter(p -> checkIfFileRequiredContent(p,requiredContent))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String finFileExtension(Path path) {
        String name = path.getFileName().toString();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf == -1 ){
            return path.getFileName().toString();
        }
        return name.substring(lastIndexOf);
    }


    private static boolean checkIfFileRequiredContent(Path p, String requiredContent) {
        try {
            return Files.lines(p)
                    .anyMatch(line->line.contains(requiredContent));
        } catch (IOException e) {
            System.err.printf("error reading: %s, message %s%n", p,e.getMessage());
        }
        return false;
    }

}