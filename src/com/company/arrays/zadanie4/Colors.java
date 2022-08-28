package com.company.arrays.zadanie4;

public class Colors {
    public static void main(String[] args) {
        colorsMethod(100);
    }

    private static void colorsMethod(int number) {
        for (int i = 1; i < number; i++) {
            if (i % 6 == 0) {
                System.out.println("brown color");
            }
            if (i % 6 == 1) {
                System.out.println("red color");
            }
            if (i % 6 == 2) {
                System.out.println("green color");
            }
            if (i % 6 == 3) {
                System.out.println("blue color");
            }
            if (i % 6 == 4) {
                System.out.println("black color");
            }
            if (i % 6 == 5) {
                System.out.println("yellow color");
            }
        }
    }
}
