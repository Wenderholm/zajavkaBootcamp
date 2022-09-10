package com.company.objectProgram.zadaniaProgramObiektowe.zadanie3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        exercise();
    }

    private static void exercise(){
        Square[] squares = new Square[]{
                new Square(2),
                new Square(3),
                new Square(4),
                new Square(6),
                new Square(7),
                new Square(4),
                new Square(),
                new Square(),
        };

        System.out.println(Arrays.toString(squares));
        Square[] duplicateAndSortArr = duplicateAndSort(squares);
        System.out.println(Arrays.toString(duplicateAndSortArr));
    }

    private static Square[] duplicateAndSort(Square[] arr) {
//        sortowanie tablicy
        sort(arr);
//        sprawdzanie ile jest unikalnych liczb żeby dostosować nową tablicę
        int sizeOfNonDuplicate = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i].equals(arr[i + 1])) {
                sizeOfNonDuplicate++;
            }
        }
        int size = arr.length;
        Square[] newArr = new Square[sizeOfNonDuplicate];
        int j = 0;
        for (int i = 0; i < size - 1; i++) {
            if (!arr[i].equals(arr[i + 1])) {
                newArr[j++] = arr[i];
//                j++;
            }
        }
//dopisanie ostatniej liczyb do listy
        newArr[j] = arr[size - 1];
        return newArr;
    }


    private static void sort(Square[] array) {
        Square temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if (array[i].square() > array[j].square()) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
