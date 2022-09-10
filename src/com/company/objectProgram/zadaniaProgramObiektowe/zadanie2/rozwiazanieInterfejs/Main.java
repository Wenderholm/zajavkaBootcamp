package com.company.objectProgram.zadaniaProgramObiektowe.zadanie2.rozwiazanieInterfejs;

public class Main {
    public static void main(String[] args) {
        Function half = new HalfCalculator();
        Function quarter = new QuaterCalculator();

        System.out.println(half.calculate(6));
        System.out.println(quarter.calculate(24));

        Function[] funArray = new Function[10];

        for (int i = 0; i < funArray.length ; i++) {
            funArray[i] = i % 2 == 0 ? new HalfCalculator() : new QuaterCalculator();
         }

        int start = 10;

        for (Function function : funArray) {
            start += function.calculate(start);
        }
        System.out.println(start);
    }
}
