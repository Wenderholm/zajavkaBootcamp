package com.company.arrays2.zadanie8;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,4,5,3,2,5,6,2,3,4,46,7,8};
        someMethod(arr,9);
        System.out.println("------------");
        someMethod(arr,12);
    }

    private static void someMethod(int[] array, int sum){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                if(i == j){
                    break;
                }
                if(array[i] + array[j] == sum){
                    System.out.println("para: " + array[i] + " + " + array[j] + " = " + sum );
                }
            }
        }
    }
}
