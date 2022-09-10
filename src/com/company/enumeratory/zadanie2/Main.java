package com.company.enumeratory.zadanie2;

public class Main {

    public static void main(String[] args) {
        Dance hiphop = Dance.HIPHOP;

        System.out.println(hiphop.name() + ":"
                + " possible hours: " + hiphop.getHours()
                + " possible day: " + hiphop.getDay()
                + " alternative: " + hiphop.alternativeData());


        Dance modernDance = Dance.MODERNDANCE;
        System.out.println(modernDance.name() + ":"
                + " possible hours: " + modernDance.getHours()
                + " possible day: " + modernDance.getDay()
                + " alternative: " + modernDance.alternativeData());


    }
}
