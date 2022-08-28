package com.company.instrukcjeWarunkowe.zadanie1;

public class Main {
    public static void main(String[] args) {
        checkMethod(1200);
        checkMethod(1999);
        checkMethod(1100);


    }

    private static void checkMethod(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println("podany rok : " + year + " jest rokiem przestępnym");
        } else {
            System.out.println("podany rok : " + year + " nie jest rokiem przestępnym");
        }
    }
}
