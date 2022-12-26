package com.company._3warsztat.zadania.Zadanie_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("./src/com/company/_3warsztat/zadania/Zadanie_1");
        String extension1 = ".txt";
//        run(path, extension1);
        runWithWalk(path, extension1);
    }

    private static void run(Path path, String extension) {
        try {
            System.out.printf("Printing %s%n", extension);
            printFilesWithExtension(path, extension);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void runWithWalk(Path path, String extension) {
        try {
            System.out.printf("Printing %s%n", extension);
            printFilesWithExtensionUsedWalk(path, extension);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFilesWithExtension(final Path path, final String extension) throws IOException {
//        wchodzimy do sciezki i sprawdzamy czy to jest folder jezeli folder to sprawdzamy jego wnetrze
//        1. pierwsza sciezka (nextPath) w Zadanie1 jest example wchodzimy do metody printFilesWithExtension i sprawdzamy czy to jest folder
//        2. okazuje się ze exmaple to folder wchodzimy do jego wnetrza i sprawdzamy pierwszy plik
//                pierwszy plki to nowy1.txt - sprawdzamy przy pomoczy metody printFilesWithExtension czy to folder
//                okazuje się ze to nie folder przechodzimy do else gdzie sciezka przetwarzana jest na string i sprawdzamy czy konczy sie na .txt
//                jezeli tak jest to wypisujemy
//        i tak dalej sprawdzane są kolejne pliki
        if (Files.isDirectory(path)) {
            for (Path nextPath : Files.list(path).collect(Collectors.toList())) {
                printFilesWithExtension(nextPath,extension);
            }
        }else{
            if(path.toString().endsWith(extension)){
                System.out.println(path);
            }
        }
    }

    private static void printFilesWithExtensionUsedWalk(Path path, String extension) throws IOException {
        Files.walk(path)
                .filter(p-> p.toString().endsWith(extension))
                .forEach(System.out::println);
    }


}
