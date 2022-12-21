package com.company._2warsztat.stream.zadanie_1;

import java.util.stream.IntStream;

public class Exercise1 {
    public static void main(String[] args) {

        System.out.println(factorialNormal(5));
        System.out.println(factorialRecursive(5));
        System.out.println(factorialFunction(5));


    }

    private static int factorialNormal(int n) {
        int result = 1;
        for (int j = 1; j <= n; j++) {
            result *= j;
        }
        return result;
    }

    private static int factorialRecursive(int i) {
        if(i==0){
            return 1;
        }else{
            return i * factorialRecursive(i-1);
        }

    }

    private static int factorialFunction(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (left, right) -> left * right);
    }
}
