package com.company._3warsztat.input_outputStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("./src/com/company/_3warsztat/input_outputStream/someFileInput.txt");
        File outputFile = new File("./src/com/company/_3warsztat/input_outputStream/someFileOutput.txt");
//        System.out.println(inputFile.exists());
        justCopyNoBuffer(inputFile, outputFile);

    }

    private static void justCopyNoBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new FileInputStream(inputFile);
                OutputStream output = new FileOutputStream(outputFile);
        ) {
            int value = input.read();
            System.out.printf("Start reading file: [%s]%n", inputFile);
            System.out.printf("Reading value: [%s], char[%s]%n", value, (char)value);

//            wpisujemy tu -1 ponieważ ta cyfra oznacza koniec pliku
            while(value != -1){
                System.out.printf("Writing value: [%s], char[%s]%n", value, (char)value);
//                zapisanie najtu do innej tablicy
                output.write(value);
//                musimy dać znać co będziemy robic dalej i w tym miejscu mowimy ze czytamy kolejny znak
                value = input.read();
                System.out.printf("Reading value: [%s], char[%s]%n", value, (char)value);
            }
        }
    }
}
