package com.company.objectProgram.referenceVsObject;

public class ReferenceVsObject {
    public static void main(String[] args) {
//        referencja typu Gorilla
        Gorilla gorilla1 = new Gorilla("10", "Robert");
//      referencja typu Monkey
        Monkey gorilla2 = gorilla1;
//      referencja typu Object
        Object gorilla3 = gorilla1;

//      aby przypisać gorilla 2 do gorilla4 należy zrzutować na typ Gorilla
        Gorilla gorilla4 = (Gorilla) gorilla2;

        Gorilla gorilla5 = (Gorilla) gorilla3;

        System.out.println(gorilla1 == gorilla4);
        System.out.println(gorilla1 == gorilla5);

//        gorilla1 jest typu Gorilla dziedziczy po Monkey a Monkey dziedziczy niejawnie po Object dlatego
//        gorilla1 może korzystać z metod w klasach Gorilla i Monkey
        System.out.println(gorilla1.gorillaMethod());
        System.out.println(gorilla1.monkeyMethod());

//        gorilla2 jest typu Monkey dzidziczy niejwanie po Object może korzystać z metod w klasie Monkey
//        może kożystać z metod klasy Gorilla po zrzutowaniu na typ Gorilla
        System.out.println(gorilla2.monkeyMethod());
        System.out.println(((Gorilla) gorilla2).gorillaMethod());
    }
}
