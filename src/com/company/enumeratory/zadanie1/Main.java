package com.company.enumeratory.zadanie1;

public class Main {
    public static void main(String[] args) {

        for (Day value : Day.values()) {
            System.out.println(value + "(" + value.shortWord() + ")"
            + " Is working day? " + value.isWorkingDay()
            + " Is weekend day? " + value.isWeekend());
        }
        ;
    }
}
