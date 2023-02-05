package com.company.operatorsExercise.zadanie1_1;

public class Main {
    public static void main(String[] args) {
        method(1.23,2.3);
        method(1.1,2.2);
        dodawanie(2,3);
    }
    private static void method(double one, double two){
        System.out.println("Suma: "+ one +" + " + two + " = " + (one + two));
        System.out.println("Różnica: "+ one +" - " + two + " = " +  + (one - two));
        System.out.println("Iloczyn: "+ one +" * " + two + " = " +  + (one * two));
        System.out.println("Iloraz: "+ one +" / " + two + " = " +  + (one + two));
        System.out.println();
    }
    private static void dodawanie(double a, double b){
        System.out.println(a+b);
    }
}
