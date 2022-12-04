package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, Dog> biPredicateExample = (str, d) -> d.toString().contains(str);
        boolean dog = biPredicateExample.test("Dog", new Dog());

        System.out.println(dog);
    }

    static class Dog{

    }
}
