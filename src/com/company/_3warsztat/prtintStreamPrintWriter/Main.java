package com.company._3warsztat.prtintStreamPrintWriter;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/com/company/_3warsztat/prtintStreamPrintWriter/example.txt");
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file))))
        {
            writer.print(1L);
            writer.write(String.valueOf(1L));

            Car stefan = new Car("Stefan");
            writer.print(stefan);

            writer.println();

            writer.println("zajavka");

            writer.printf("some value: [%s]%n",stefan);
            writer.printf("some value: [%s]%n",stefan);
        }
    }
}
