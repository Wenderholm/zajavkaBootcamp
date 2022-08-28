package com.company.arrays;

import java.util.Arrays;

public class DwuWymiaroweTablice {
    public static void main(String[] args) {
        String[][] array = {
                {"g1e1","g1e2"},
                {"g2e1","g2e2","g2e3"},
                {"g3e1","g3e2","g3e3","g3e4"},
                {"g4e1","g4e2"}
        };

//        printArray(array);
//        printArray2(array);

//        int[][] matrix = createMatrix(4, 6);

//        int[][] matrix = createMatrix(4, 6);
//        printArray2(matrix);

    }

//    private static int [][] createMatrix(int rows, int columns){
//        int[][] matrix = new int[rows][columns];
//        for (int row = 0; row < rows; row++){
//            for(int column = 0; column < columns; column++){
//                matrix[row][column] = generateRandomValue();
//            }
//        }
//        return matrix;
//    }
//
//    private static int generateRandomValue() {
//        int min = 0;
//        int max = 10;
//        return (int)(Math.random() * ((max-min)+1))+min;
//    }

    private static void printArray(int[][] toPrint){
        for (int row = 0; row < toPrint.length; row++) {
            for (int column = 0; column < toPrint[row].length; column++) {
                System.out.println("accessing: [" + row + "][" + column + "]: "+ toPrint[row][column]);
            }
        }
    }
//    private static void printArray2(int[][] toPrint){
//        for(int[]internArray : toPrint){
//            for (int element : internArray){
//                System.out.println(element);
//            }
//        }
//    }

    private static void printArray2(int[][] toPrint){
        for(int[]internArray : toPrint){
            System.out.println(Arrays.toString(internArray));
        }
    }
}
