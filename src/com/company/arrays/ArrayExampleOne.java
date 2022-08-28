package com.company.arrays;

public class ArrayExampleOne {
    public static void main(String[] args) {
        ArrayExampleOne arrayExample = new ArrayExampleOne();
        arrayExample.arraysExample1();
    }

    private void arraysExample1() {
        String[] array = new String[10];

        int i = 0;
        while (i < 5) {
            array[i] = "Hello new index: " + i;
            i++;
        }

        String completeContent = "";
        for (int k = 0; k < 7; k++) {
            completeContent = completeContent + array[k] + ";";
            System.out.println("Print => " + array[k]);
        }
        System.out.println(completeContent);
    }
}
