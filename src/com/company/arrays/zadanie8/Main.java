package com.company.arrays.zadanie8;

public class Main {
    public static void main(String[] args) {
        printSomething();
    }
    private static void printSomething(){
        for (int k = 1; k < 10; k++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(k);
            }

            for (int i = 0; i < 4; i++) {
                System.out.println();
                for (int j = 0; j < 4; j++) {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
