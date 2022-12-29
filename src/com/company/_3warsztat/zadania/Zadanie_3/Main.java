package com.company._3warsztat.zadania.Zadanie_3;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("./src/com/company/_3warsztat/zadania/Zadanie_3/someFile.txt");
        try {
            BigDecimal divider = BigDecimal.valueOf(1000);
            BigDecimal sizeInBytes = BigDecimal.valueOf(Files.size(path));
            BigDecimal sizeInKilobits = sizeInBytes.divide(divider, RoundingMode.HALF_UP);
            BigDecimal sizeInMegabit = sizeInKilobits.divide(divider, RoundingMode.HALF_UP);

            System.out.printf("File in %s[b] %s[kb] %s[Mb]", sizeInBytes,sizeInKilobits,sizeInMegabit);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
