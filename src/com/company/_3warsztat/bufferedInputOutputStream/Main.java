package com.company._3warsztat.bufferedInputOutputStream;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("./src/com/company/_3warsztat/bufferedInputOutputStream/someFileInput.txt");
        File outputFile = new File("./src/com/company/_3warsztat/bufferedInputOutputStream/someFileOutput.txt");
//        System.out.println(inputFile.exists());
        justCopyWithBuffer(inputFile, outputFile);

    }

    private static void justCopyWithBuffer(File source, File destination) throws IOException {
        try (
                InputStream input = new BufferedInputStream(new FileInputStream(source));
                OutputStream output = new BufferedOutputStream(new FileOutputStream(destination));
        ) {
            byte[] buffer = new byte[1024];
            int lengthRead = input.read(buffer);
            System.out.printf("Start buffered reading file: [%s]%n", source);
            System.out.printf("Read value: [%s], chars[%s], length:[%s] %n",
                    PrintingUtility.byteArrToStr(buffer), PrintingUtility.toCharString(buffer), lengthRead);

            while(lengthRead > 0){
                System.out.printf("Writing value: [%s], char[%s]%n",
                        PrintingUtility.byteArrToStr(buffer), PrintingUtility.toCharString(buffer));
                output.write(buffer,0,lengthRead);
                output.flush();
//                musimy dać znać co będziemy robic dalej i w tym miejscu mowimy ze czytamy kolejny znak
                lengthRead = input.read(buffer);

                System.out.printf("Read value: [%s], chars[%s], length:[%s] %n",
                        PrintingUtility.byteArrToStr(buffer), PrintingUtility.toCharString(buffer), lengthRead);
            }
        }
    }

    private static class PrintingUtility {
        static String toCharString(byte[] input){
            char[] charArray = new char[input.length];
            for (int i = 0; i < input.length; i++) {
                charArray[i] = (char) input[i];
            }
            return replaceNewLines(Arrays.toString(charArray));
        }

        public static String byteArrToStr(byte[] buffer) {
            return  replaceNewLines(Arrays.toString(buffer));
        }

        private static String replaceNewLines(String input) {
            return input.replace("\n","\\n").replace("\r","\\r");
        }
    }
}
