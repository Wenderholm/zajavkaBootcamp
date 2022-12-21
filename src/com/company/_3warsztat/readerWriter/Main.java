package com.company._3warsztat.readerWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("./src/com/company/_3warsztat/readerWriter/someFileInput.txt");
        File outputFile = new File("./src/com/company/_3warsztat/readerWriter/someFileOutput.txt");

        List<String> fileReader = readFile(inputFile);
//        wypisnie lisy z linijkami
//        System.out.println(fileReader);

//        wypisanie za pomoca lambdy
        fileReader.forEach(System.out::println);

        writeFile(outputFile, fileReader);
    }

    private static List<String> readFile(final File inputFile) throws IOException {
        List<String> result = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8)))
        {
//            wypisanie jednego znaku z tabeli unicode i zrzutowanie go na char czyli znak
//            System.out.println((char)reader.read());
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        }
        return result;
    }

    private static void writeFile(File outputFile, List<String> fileReader) throws IOException {
//        w new FileWriter(a,b,c) mamy dwie wartosci a jezeli dodamy c jest to append to linijki pliku nie będą sie nadpisywały
//        tylko dodawały na koncu poprzednich linii
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))){
            for (String line : fileReader) {
//                przejscie po wszystkich liniach pliku i zapisanie
                writer.write(line);
//                dodanie znaku nowej linii na koniec
                writer.newLine();
            }

        }
    }
}

