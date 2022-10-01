package com.company.kolekcje.zadania.zadanie5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list100 = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list100.add(random.nextInt(10));
        }

        System.out.println(list100);

        Map<Integer, Integer> numberInList = new HashMap<>();
        for (Integer elemet : list100) {
//            wyswietlanie numeru z tablicy
            Integer num = numberInList.get(elemet);
//            dodawanie elementrów do nowej tablicy
            numberInList.put(elemet, num == null ? 1 : num + 1);
        }

        System.out.println(numberInList);

        System.out.println("--------WYSWIETLANIE--------------");
        Set<Map.Entry<Integer, Integer>> entries = numberInList.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("element " + entry.getKey() + " wystąpił : " + entry.getValue() + ((entry.getValue() == 1 ? " raz":" razy")));

        }
    }
}
