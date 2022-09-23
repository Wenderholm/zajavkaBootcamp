package com.company.kolekcje.arrayListExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
//        towrzenie arrayList z generykiem String czyli takie jakie bedzie zawierala dana tablica rzeczy
        List<String> cities = new ArrayList<>();
//        dodawanie do arrayList
        cities.add("Warszawa");
        cities.add("Gdynia");
        cities.add("Rumia");
        cities.add("Szczecin");
//        dodawanie na wybranym indeksie
        cities.add(1, "Reda");
//        wyswietlanie elementu
        System.out.println(cities.get(2));
//        sprawdzenie rozmiaru
        System.out.println(cities.size());
//        sprawdzenie czy tablic jest pusta
        System.out.println(cities.isEmpty());
//      sprwadzenie czy zawiera wielkość znaków ma znaczenie
        System.out.println(cities.contains("rumia"));
//        usuwa z danego indeksu i pokazuje co zostało usunięte
        System.out.println(cities.remove(2));
//        usuwa po nazwie i pokazuje boolean czy true czy false
        System.out.println(cities.remove("Warszawa"));
//        sprawdzenie na jakim indeksie jest obiekt jeżeli jest to pokaże indeks jeżeli nie ma to wyświetli -1
        System.out.println(cities.indexOf("rumia"));
//        CZYSZCZENIE LIST
//        cities.clear();
//      wyświetlenie listy
        System.out.println(cities);
//        dodanie innej listy
        List<String> listNew = Arrays.asList("Nowe1", "Nowe2");
        System.out.println(cities.addAll(listNew));
        System.out.println(cities);
        System.out.println("------------------------------------");
        System.out.println("podaj indeks jaki chcesz wyswietlic");

    }
}

