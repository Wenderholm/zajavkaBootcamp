package com.company.staticWord.example2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator sold : " + Calculator.calculatorSold);
        Calculator calc1 = new Calculator("casio");

        calc1 = null;
        System.gc();

        for (int i = 0; i < 1000; i++) {
            String a = new String("a");
        }

        Calculator calc2 = new Calculator("NAKIO");
        System.out.println("Calculator sold : " + Calculator.calculatorSold);
    }
}
