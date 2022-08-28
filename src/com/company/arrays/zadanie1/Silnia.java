package com.company.arrays.zadanie1;

public class Silnia {
    public static void main(String[] args) {
        System.out.println(silnia(3));
        System.out.println(silnia_rekurencyjnie(3));
    }

    private static int silnia(int n){
        int iloczyn = 1;
        for (int i = 1; i <= n; i++) {
            iloczyn *= i;

        }
        return iloczyn;
    }

    private static int silnia_rekurencyjnie(int n){
        if (n==0){
            return 1;
        }else {
            return (n*silnia_rekurencyjnie(n-1));
        }
    }
}
