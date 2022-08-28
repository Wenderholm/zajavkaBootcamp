package com.company.arrays2.zadanie7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 5, 0, -2, -1, 3, -5, 4, 2, -19, 17, -3, 3, 4, -5, 4, 18, 0, -1, -2, 3, -5, 0};

        int[] duplicate1 = duplicateAndSort(arr);

        System.out.println(Arrays.toString(duplicate1));
        System.out.println("second largest: " + duplicate1[duplicate1.length - 2]);


    }

    private static int[] duplicateAndSort(int[] arr) {
//        sortowanie tablicy
        sort(arr);
//        sprawdzanie ile jest unikalnych liczb żeby dostosować nową tablicę
        int sizeOfNonDuplicate = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                sizeOfNonDuplicate++;
            }
        }
        int size = arr.length;
        int j = 0;
        int[] newArr = new int[sizeOfNonDuplicate];
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                newArr[j++] = arr[i];
//                j++;
            }
        }
//dopisanie ostatniej liczyb do listy
        newArr[j] = arr[size - 1];
        return newArr;
    }


    private static void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

