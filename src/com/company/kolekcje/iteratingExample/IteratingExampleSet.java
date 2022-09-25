package com.company.kolekcje.iteratingExample;

import java.util.*;

public class IteratingExampleSet {
    public static void main(String[] args) {
        Set<String> cities = new HashSet<>();
        cities.add("Warszawa");
        cities.add("Gdynia");
        cities.add("Rumia");
        cities.add("Szczecin");

//      sposoby iterowania
        System.out.println("---------- SPOSÓB I ---------------");

        Iterator<String> iterator = cities.iterator();
//        po wywolaniu iteratora nie mozemy dodawać zadnych obiektów do hashSet
//        cities.add("aaa");  <- będzie błąd ConcurrentModificationException

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
