package com.company._3warsztat.Projekt.servicers;

import com.company._3warsztat.Projekt.domain.Purchase;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileServices {
    public static List<Purchase> localData(Path path) {
        try {
            return Files.lines(path, Charset.defaultCharset())
//                    pominięcie pierwszego wiersza z nazwami kolumn
                    .skip(1)
//                    zmapowanie linijek na odpowiednie obiekty
                    .map(PurchaseMappingService::mapPurchase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    ;

    public static void saveToFile(Path path, List<String> data) {
        String header = "id,first_name,last_name,email,ip_address,color,car_vin,car_company," +
                "car_model,car_model_year,car_price,country,city,date";
        saveToFile(path, data, header);
    }

    public static void saveToFile(Path path, List<String> data, String header) {
        try {
//            towrzenie folderu ex2
            Files.createDirectories(path.subpath(0, path.getNameCount() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter write = Files.newBufferedWriter(path, Charset.defaultCharset())) {
//            dopisanie nagłówka do pliku
            write.write(header);
//            dodanie entera po nagłówku
            write.newLine();
            for (String row : data) {
//                dodanie wiersza
                write.write(row);
                write.newLine();
                write.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
