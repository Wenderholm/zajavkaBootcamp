package com.company.instrukcjeWarunkowe.zadanie5;

public class Main {
    public static void main(String[] args) {
        numberOfTheDay(12);
        numberOfTheDay(13);
    }

    private static void numberOfTheDay(int number) {
        int sum = 0;
        switch (number) {
            default:
                System.out.println("nie ma takiego miesiąca");
                break;
            case 12:
                sum += 31;
            case 11:
                sum += 30;
            case 10:
                sum += 31;
            case 9:
                sum += 30;
            case 8:
                sum += 31;
            case 7:
                sum += 31;
            case 6:
                sum += 30;
            case 5:
                sum += 31;
            case 4:
                sum += 30;
            case 3:
                sum += 31;
            case 2:
                sum += 28;
            case 1:
                sum += 31;
        }
        System.out.println("liczba dni od początku roku to " + sum);
    }
}
