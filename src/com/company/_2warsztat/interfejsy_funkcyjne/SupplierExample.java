package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
//        implementacja supllier nic nie przyjmuje ale coś zwraca
//        Supplier<Integer> sup1 = ()  -> 123;

//        powyższa implementacja z nawiasami {}
//        Supplier<Integer> sup1 = ()  -> {
//            System.out.println("calling sup1");
//            return 123;
//        };

//        powyższa implementacja z użyciem metody
//        Supplier<Integer> sup1 = ()  -> supExtractMethod();

//        powyższa implementacja z użyciem methodReference
        Supplier<Integer> sup1 = SupplierExample::supExtractMethod;

//      wywolanie metody get z Supplier
        System.out.println(sup1.get());
    }

    private static int supExtractMethod() {
        System.out.println("calling sup extract method");
        return 456;
    }
}
