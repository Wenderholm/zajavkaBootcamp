package com.company.arrays2.zadanie5;

import java.util.Arrays;

public class CompareTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {2,6,1,12};
        int[] arr2 = {12,6,13,1,2};

        System.out.println(compareArrays(arr1,arr2));
    }
    
    
    
    
    private static boolean compareArrays(int[] arr1, int[]arr2){
        int[] arr1Sorted = sortedArray(arr1);
        int[] arr2Sorted = sortedArray(arr2);
        if(arr1Sorted.length == arr2Sorted.length){
            for (int i = 0; i < arr1Sorted.length; i++) {
                if(arr1Sorted[i] != arr2Sorted[i]){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] sortedArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < (array.length - i -1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
            }
        }
    }
        return array;
    };
}
