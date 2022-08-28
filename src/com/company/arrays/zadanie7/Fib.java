package com.company.arrays.zadanie7;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fibMethod(16));
    }
    private static int fibMethod(int num){
        if (num == 1 || num == 2){
            return 1;
        }else{
            return fibMethod(num-2) + fibMethod(num-1);
        }
    }
}
