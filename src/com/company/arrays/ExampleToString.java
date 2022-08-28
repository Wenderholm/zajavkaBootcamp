package com.company.arrays;

public class ExampleToString {
    public static void main(String[] args) {
        int[] array = {1,3,4,-1};
        printElement(array);
    }

    private static void printElement(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
