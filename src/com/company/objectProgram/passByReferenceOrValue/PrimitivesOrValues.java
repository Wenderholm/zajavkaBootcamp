package com.company.objectProgram.passByReferenceOrValue;

public class PrimitivesOrValues {
    public static void main(String[] args) {
//        ARGUMENTY METOD FUNKCJI PRZEZ REFERENCJE - java nie działa przez referencje

        Cat cat = new Cat("Andrzej");
        System.out.println(cat);
        referenceByValueOfValues(cat);
        System.out.println(cat);

        int i = 10;
        System.out.println(i);
        referenceByValueOfValues(i);
        System.out.println(i);
    }

//        ARGUMENTY METOD FUNKCJI PRZEZ REFERENCJE

//    private static void referenceByValueOfValues(Cat otherReferenceToCat) {
////        otherReferenceToCat - kopia wskazania na obiekt
//        System.out.println("Inside method 1: " + otherReferenceToCat);
////        zmiana wartosci kopi
//        otherReferenceToCat = new Cat("Roman");
////        wyswietlanie kopi która będzie widoczna tylko w metodzie poza metodą nie będzie widoczna
//        System.out.println("Inside method 2: " + otherReferenceToCat);
//    }

//    JEŻELI CHCEMY ŻEBY TO DZIAŁAŁO TO:
//    1. dodajemy seter w cat za pomocą którego będziemy zmieniac imię


    private static void referenceByValueOfValues(Cat otherReferenceToCat) {
        System.out.println("Inside method 1: " + otherReferenceToCat);
        otherReferenceToCat.setName("Adam");
        System.out.println("Inside method 2: " + otherReferenceToCat);
    }

    private static void referenceByValueOfValues(int i) {
        System.out.println("Inside method 1: " + i);
        i = 20;
        System.out.println("Inside method 2: " + i);
    }
}
