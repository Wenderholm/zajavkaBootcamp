package com.company.instrukcjeWarunkowe.zadanie3;

public class Main {
    public static void main(String[] args) {

            someMethod(35);
            someMethod(60);
    }

    private static void someMethod(int number){
        if(number % 2 == 0){
            System.out.println(number + " liczba jest parzysta");
        }else{
            System.out.println(number + " liczba jest nieparzysta");
        }
    }
}
