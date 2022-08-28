package com.company.arrays2.zadanie6;

import java.util.Arrays;

public class ChangeLetter {
    public static void main(String[] args) {
        String[] cities = {"GdYnIa", "kRakOw", "RaDoM"};

        for (int i = 0; i < cities.length; i++) {
           String word = cities[i].toLowerCase();
//zamineienie pierwszych znaków słów na literkę string zeby mozna było uzyc meody stringa (toUpperCase)
           word = word.replaceFirst(String.valueOf(word.charAt(0)),String.valueOf(word.charAt(0)).toUpperCase());

           cities[i] = word;

            System.out.println(word.charAt(0));
            System.out.println(String.valueOf(word.charAt(0)));
        }

        System.out.println(Arrays.toString(cities));
    }
}
