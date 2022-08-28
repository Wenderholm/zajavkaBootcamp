package com.company.arrays;

import java.util.Arrays;

public class ArrayExample2_sortowanie {
    public static void main(String[] args) {
        double[] array = new double[]{2.0, 0.50, 13.72, 12.34, 1.29, 4.55, 1.23894};
        ArrayExample2_sortowanie arrayExample = new ArrayExample2_sortowanie();
//        arrayExample.arrayExample2();
        sortedArrayTest(array);
    }

    private void arrayExample2() {
        double[] array = new double[]{2.0, 0.50, 13.72, 12.34, 1.29, 4.55, 1.23894};

        System.out.println("obliczenie sumy wszystkich elementów");
        double total = 0;
        for (double element : array) {
            total += element;
        }
        System.out.println("Total: " + total);

        System.out.println("znalezienie największego elementu");
        double maximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        System.out.println("Maximum: " + maximum);
        System.out.println("znalezienie najmniejszego elementu");
        double minimum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        System.out.println("Maximum: " + minimum);


    }

    private static void sortedArrayTest(double[] array) {
        double temp;
        for (int i = 0; i < array.length-1; i++) {
//
            for (int j = 0; j < (array.length - i -1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    System.out.println("Swap: " + Arrays.toString(array));
                }else{
                    System.out.println("Don't swap: " + array[j] + " and " + array[j + 1]);
                }
            }
            System.out.println(i + " i iteration: " + Arrays.toString(array));
            System.out.println();
        }
        System.out.println("Sorted array: " + Arrays.toString(array));
//        for (double v : array) {
//            System.out.print(v + " ");
//        }
    }
};

//    private static void quiz(){
//        int result = 0;
//        do{
//            System.out.println(result++ + " ");
//        }while (result <= 10);
//    }
//
//    private static void quiz2(){
//        int result = 0;
//        while(result++ <10){}
//        System.out.println(result);
//    }
//
//    private static void quiz3(){
//        int result =0;
//        LABEL:
//        for (int i = 10; i <=23 ; i++) {
//            for (int j = 1; true; j++) {
//                if(i*j % 3 == 0){
//                    continue LABEL;
//                }
//                if(i==14){
//                    break;
//                }
//                result++;
//            }
//        }
//        System.out.println(result);
//    }

