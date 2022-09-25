package com.company.kolekcje.iteratingExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratingExampleList {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Warszawa");
        cities.add("Gdynia");
        cities.add("Rumia");
        cities.add("Szczecin");

//      sposoby iterowania
        System.out.println("---------- SPOSÓB I ---------------");
        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("---------- POSÓB II ----------------");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
        System.out.println("---------- POSÓB III ----------------");
        Iterator<String> iterator = cities.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------- ELEMENTY W KOLEJNOSCI NORMALNEJ ----------------");
        ListIterator<String> stringListIterator = cities.listIterator();
        while(stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

        System.out.println("---------- ELEMENTY W KOLEJNOSCI ODWROTNEJ ----------------");
        while(stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());
        }

    }
}
