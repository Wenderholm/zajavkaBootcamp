package com.company.arrays;

public class TwoDimensionalArrayExercise {
    public static void main(String[] args) {
        int[][] array = {
                {1,3,5,64},
                {2,4,5,23},
                {3,4,12,45},
                {3,4,1,23}
        };
        System.out.println(matrixChecked(array));
        System.out.println(sumMatrix(array));
        System.out.println(reversSumMatrix(array));

    }
//sprwadzenie czy macierz jest kwadrawtowa czyli ma tyle samo wierszy co kolumn
    private static int matrixChecked(int[][] array){
        int rowSize = array.length;
        for (int[] ints : array) {
            int colSize = ints.length;
            if(rowSize != colSize){
                return -1;
            }
        }
        return 0;
    }
//policzenie sumy po przekątnej od [0][0] do [n][n]
    private static int sumMatrix(int[][]arr){
//        ustawienie poczatkowej sumy
        int sum = 0;
//        pętla zewnetrzna po rzędach
        for (int row = 0; row < arr.length; row++) {
//            pętla wewnęrzna w każdym rzędzie wszystkie kolumny
            for (int col = 0; col < arr[row].length; col++) {
//                sprwadzenie czy rząd jest równy kolumnie ponieważ chcemy sumowac [0][0],[1][1],[2][2] itd
                if(row == col){
                    sum += arr[row][col];
                }
            }
        }
        return sum;
    }

//policzenie sumy po przekątnej od [0][n] do [n][0]
    private static int reversSumMatrix(int[][] array){
        int sum = 0;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                int size = array[row].length - 1 ;
                if(row == size - col){
//                    System.out.println("print[row][col] : [" + row + "]["+ col+"]" );
                    sum += array[row][col];
                }
            }
        }
        return sum;
    }
}
