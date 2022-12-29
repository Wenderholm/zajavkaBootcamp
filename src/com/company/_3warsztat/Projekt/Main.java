package com.company._3warsztat.Projekt;

import com.company._3warsztat.Projekt.domain.Pair;
import com.company._3warsztat.Projekt.domain.Purchase;
import com.company._3warsztat.Projekt.servicers.FileServices;
import com.company._3warsztat.Projekt.servicers.PurchaseMappingService;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static final String EX2 = "./src/com/company/_3warsztat/Projekt/exported/ex2/";
    public static final String EX3 = "./src/com/company/_3warsztat/Projekt/exported/ex3/";

    public static void main(String[] args) {
        Path path = Paths.get("./src/com/company/_3warsztat/Projekt/resources/client-car-purchase-spreadsheet.csv");
        List<Purchase> purchases = FileServices.localData(path);
// pogrupowanie danych po marce samochodu
        Map<String, List<Purchase>> mapByCompany = purchases.stream()
                .collect(Collectors.groupingBy(p -> p.getCar().getCompany()));

//        wyswietlenie transakcji dla modelu
//        for (String company : mapByCompany.keySet()) {
//            System.out.println(company + " : " + mapByCompany.get(company));
//        }

//         ZADANIE 2
//        przejscie po mapie podzielonej po marce samochodu wypisanie wartosci jako stream
        for (Map.Entry<String, List<Purchase>> entry : mapByCompany.entrySet()) {
            Path path1 = Paths.get("./src/com/company/_3warsztat/Projekt/exported/ex2/purchases-of-" + entry.getKey() + ".csv");
            List<String> data = entry.getValue().stream()
//                   zapisanie danych ze streama z wykorzystaniem metody toCsvRow -> przygotowanie danych do zapisania do pliku
                    .map(PurchaseMappingService::toCsvRow)
                    .collect(Collectors.toList());
//            zapisanie przygotowanych danych "data" w wybranej lokalizacji "path1"
            FileServices.saveToFile(path1, data);
        }

//        przejscie po plikach w folderze ex2. zapisanie do mapy gdzie kluczem jest nazwa marki auta(keyMapper)
//        wartością bedzie rozmiar pliku(valueMapper), jezeli beda te same klucze to wybieramy pierwszy(margeFunction)
//        wybranie w jakiej kolekcji chcemy przechowywać dane(mapFactory) oraz ze będą one psortowanie odwrotnie

        try {
            TreeMap<Path, ? extends Number> mapSizeByCompany = Files.list(Paths.get(EX2))
                    .collect(Collectors.toMap(
                            (Path path2) -> path2.getFileName(),
                            path1 -> getFileSize(path1),
                            (a, b) -> a,
                            () -> new TreeMap<>(Comparator.reverseOrder())
                    ));
//            wypisanie nazwy modelu : wielkość pliku
            for (Path fileName : mapSizeByCompany.keySet()) {
//                wyciagnięcie nazwy marki auta np. purchases-of-Acura.csv -> Acura
                System.out.printf("%s:%s%n", fileName.toString().substring(("purchases-of-").length(), fileName.toString().indexOf('.')), mapSizeByCompany.get(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//   ZADANIE 3
        Map<String, Map<String, List<Purchase>>> mapByCompanyAndModel = mapByCompany.entrySet().stream()
//                w tym miejscu mamy pary "nazwa marki - lista zakupow dla danej marki"
                .collect(Collectors.toMap(
//                        kluczem jest marka
                        e -> e.getKey(),
//                       value jest tu lista zakupów z której robimy stream który znów chcemy pogrupowac po modelu auta
                        e -> e.getValue().stream()
                                .collect(Collectors.groupingBy(p -> p.getCar().getModel()))
                ));
        Map<String, Map<String, Pair<BigDecimal, Long>>> ex3ReportMap = mapByCompanyAndModel.entrySet().stream()
                .collect(Collectors.toMap(
//                       kluczem zostje marka auta
                        e1 -> e1.getKey(), // mozna to zapisac tak Map.Entry::getKey
//                        value jest mapa  Map<String, List<Purchase>
                        e2 -> e2.getValue().entrySet().stream()
                                .collect(Collectors.toMap(
//                                         klucz zostaje ten sam z poprzedniej mapy czyli model
                                        Map.Entry::getKey,
//                                        z wartosci która była List<Purchase> chcemy zrobic pary
//                                        stworzylismy metodę która bedzeie liczyła srednia cene i ilosc sprzedanych aut
                                        e3 -> buildPair(e3.getValue())
                                ))
                ));
        AtomicInteger counter = new AtomicInteger(1);
        // chcemy otrzymac dane do raportu czyli kolumny:   id, company, model, average_price, count
        List<String> ex3ReportData = ex3ReportMap.entrySet().stream()
//                dla klucza marka tworzymy tabele z
                .flatMap(eExternal -> eExternal.getValue().entrySet().stream()
                        .map(eInernal -> getRawRow(counter.getAndIncrement(), eExternal.getKey(), eInernal.getKey(), eInernal.getValue())))
                .collect(Collectors.toList());

        generateEx3Report(ex3ReportData);
    }

    private static void generateEx3Report(List<String> ex3ReportData) {
        Path path = Paths.get(EX3 + "report.csv");
        FileServices.saveToFile(path,ex3ReportData,"id,company,model,average_price,count");
    }

    private static String getRawRow(int counter, String company, String model, Pair<BigDecimal, Long> pair) {
        return String.format("%s,%s,%s,%s,%s", counter, company, model, pair.getP1(), pair.getP2());
    }

    private static Pair<BigDecimal, Long> buildPair(List<Purchase> purchaseList) {
        long count = purchaseList.size();
        BigDecimal averagePrice = purchaseList.stream()
//                wyciagamy ceny samochodów
                .map(p -> p.getCar().getPrice())
//               dodajemy ceny aut do siebie
                .reduce(BigDecimal.ZERO, BigDecimal::add)
//               dzielimy przez ilosc aut celem otrzymania sredeniej ceny aut s danego modelu
                .divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        return new Pair<>(averagePrice, count);
    }

    private static long getFileSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
