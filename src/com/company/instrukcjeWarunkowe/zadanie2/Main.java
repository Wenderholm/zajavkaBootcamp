package com.company.instrukcjeWarunkowe.zadanie2;

public class Main {
    public static void main(String[] args) {

        checkMaxNumber(10,6,12);
        checkMaxNumber(6,17,11);
        checkMaxNumber(16,15,11);

    }

    private static void checkMaxNumber(int a , int b, int c){
        if(a>b){
            if(a>c){
                System.out.println("liczba a jest największa");
            }else {
                System.out.println("liczba c jest największa");
            }
        }else{
            if(b>c){
                System.out.println("liczba b jest największa");
            }else{
                System.out.println("liczba c jest największa");
            }
        }
    }
}
