package com.company.operatorsExercise.zadanie5;

public class Main {
    public static void main(String[] args) {
        someMethod(3);
        someMethod(5);
        someMethod(7);
        someMethod(21);
    }

    private static void someMethod(int x){
        boolean divisionBy3 = x % 3 == 0;
        boolean divisionBy7 = x % 7 == 0;
        boolean divisionBy3and7 = divisionBy3 && divisionBy7;

        System.out.println("liczba podzielna przez 3 " + divisionBy3);
        System.out.println("liczba podzielna przez 7 " + divisionBy7);
        System.out.println("liczba podzielna przez 3 i 7 " + divisionBy3and7);
        System.out.println();
    }
}
