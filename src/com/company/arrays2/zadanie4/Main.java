package com.company.arrays2.zadanie4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,7,6,5,6,7,2,3,12,33,2,3};
        System.out.println(Arrays.toString(arrayCheck(array)));
    }

    private static int[] arrayCheck(int[] input){
        int counter = 0;
        int duplicateIndex= 0;
//        tablica do ktorej bedzie przypisywane znalezione duplikaty
        int[] duplicateArr = new int[input.length];
        for (int i = 0; i < input.length-1; i++) {
            for (int j = i+1; j < input.length-1; j++) {
                if(input[i] == input[j+1]){
                    duplicateArr[duplicateIndex] = input[i];
                    duplicateIndex++;
                }
            }
        }
//        kopiownie otrzymanej tablicy i zmniejszenie jej rozmiaru
        int[] readyArr = Arrays.copyOf(duplicateArr, duplicateIndex);
        return readyArr;
    }


}
