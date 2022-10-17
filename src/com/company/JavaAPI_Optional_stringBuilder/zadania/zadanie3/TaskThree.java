package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie3;

import java.math.BigInteger;

public class TaskThree {
    public static void main(String[] args) {
        System.out.println(silnia(1));
        System.out.println(silnia(2));
        System.out.println(silnia(5));
        System.out.println(silniaRecuren(1));
        System.out.println(silniaRecuren(2));
        System.out.println(silniaRecuren(5));

        System.out.println("____________________");
        System.out.println(silniaBigInteger(BigInteger.valueOf(6)));
    }

    private static BigInteger silniaBigInteger(BigInteger n){
        BigInteger factorial = BigInteger.ONE;

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0 ; i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
        }
        return factorial;
    }



    private static int silnia(int number) {
//        BigInteger factorial = BigInteger.ONE;
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int silniaRecuren(int n){
        if(n == 0){
            return 1;
        }else{
            return (n * silniaRecuren(n-1));
        }
    }
}
