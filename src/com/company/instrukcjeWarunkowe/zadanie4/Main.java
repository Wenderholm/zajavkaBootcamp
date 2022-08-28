package com.company.instrukcjeWarunkowe.zadanie4;

public class Main {
    public static void main(String[] args) {
        dayInMonth(3);
        dayInMonth(6);
        dayInMonth(2);
        dayInMonth(15);
    }

    private static void dayInMonth(int number) {
        switch (number) {
            case 1:
            case 5:
            case 3:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 dni");
                break;
            case 2:
                System.out.println("29 dni");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 dni");
                break;
            case 0:
            default:
                System.out.println("nie ma takiego miesiąca");
        }
    }
}
