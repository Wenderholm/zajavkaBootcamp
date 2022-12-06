package com.company._2warsztat.interfejsy_funkcyjne.zadanie_3;

import java.util.Optional;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Cat> compareObj = (cat1, cat2) -> {
            if(cat1.compareTo(cat2) > 0){
                return cat1;
            }
            if(cat2.compareTo(cat1) > 0){
                return cat2;
            }
        return null;
        };


        Optional<Cat> result1 = Optional.ofNullable(compareObj.apply(new Cat("roman"), new Cat("ada")));
        Cat areEqual = result1.orElseThrow(() -> new IllegalArgumentException("object are equal"));
        System.out.println(areEqual);


        Optional<Cat> result2 = Optional.ofNullable(compareObj.apply(new Cat("ada"), new Cat("roman")));
        Cat areEqual2 = result2.orElseThrow(() -> new IllegalArgumentException("object are equal"));
        System.out.println(areEqual2);


        Optional<Cat> result3 = Optional.ofNullable(compareObj.apply(new Cat("roman"), new Cat("roman")));
        Cat areEqual3 = result3.orElseThrow(() -> new IllegalArgumentException("object are equal"));
        System.out.println(areEqual3);
    }
}
