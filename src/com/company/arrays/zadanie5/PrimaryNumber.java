package com.company.arrays.zadanie5;

public class PrimaryNumber {
    public static void main(String[] args) {
        printPrimaryNumber(1000);
    }

    public static void printPrimaryNumber(int number) {
        for (int i = 0; i < number; i++) {
            if (isPrimaryNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrimaryNumber(int num) {
//        0 i 1 nie są liczbami pierwszymi dlatego je odrzucamy
        if (num < 2) {
            return false;
        }
//        sprawdzamy połowe zakresu ponieważ dalszy ciąg nie ma sensu
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
