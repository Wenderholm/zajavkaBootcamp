package com.company.arrays2.zadanie3;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        String[] city = {"Gdynia","Kraków","Olsztyn","Warszawa","Radom"};

        String[] reverseArr = new String[city.length];


        for (int i = 0; i < city.length; i++) {
            reverseArr[i] = city[city.length-1-i];
        }
        System.out.println("Original: " + Arrays.toString(city));
        System.out.println("Reversed: " + Arrays.toString(reverseArr));
    }
}
