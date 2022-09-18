package com.company.staticWord.statyczneBlokiInicjalizacyjne;

public class Main {
    public static void main(String[] args) {
        System.out.println("beginning program");
        Parrot parrot1 = new Parrot();
        System.out.println("after 1st parrot");
        Parrot parrot2 = new Parrot();
        System.out.println("after 2nd parrot");
        System.out.println("the end");
    }
}
