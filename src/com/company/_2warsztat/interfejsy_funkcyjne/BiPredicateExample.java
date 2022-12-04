package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
//        BiPredicate<String, Dog> biPredicateExample = (str, d) -> d.toString().contains(str);

//        to samo co powyżej
//        BiPredicate<String, Dog> biPredicateExample = (str, d) -> {
//            System.out.println("BiPredicate calling co zawiera str " + str );
//            System.out.println("BiPredicate calling co zwiera d " + d.toString());
//            return d.toString().contains(str);
//        };

//        użycie wydzielonej metody
//        BiPredicate<String, Dog> biPredicateExample = (str, d) -> {
//            return extractedPredicateMethod(str, d);
//        };

//        użycie wydzielonej metody jako methodReference
        BiPredicate<String, Dog> biPredicateExample = BiPredicateExample::extractedPredicateMethod;


        boolean dog = biPredicateExample.test("Dog", new Dog()); // <- to da nam prawdę ponieważ w obikcie
        // Dog() mamy słowo Dog
        boolean cat = biPredicateExample.test("cat", new Dog()); // <- to da nam false ponieważ w obikcie
        // Dog() nie ma słowa Cat

        System.out.println(dog);
        System.out.println(cat);
    }

    private static boolean extractedPredicateMethod(String str, Dog d) {
        System.out.println("BiPredicate calling co zawiera str " + str);
        System.out.println("BiPredicate calling co zwiera d " + d.toString());
        return d.toString().contains(str);
    }

    static class Dog{

    }
}
