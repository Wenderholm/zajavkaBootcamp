package com.company.lambda;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        Jumpable jumpable = new Animal();
//        System.out.println(jumpable.canJump("jumping"));
//
////        referencja do klasy bez nazwy która implementuje jumpabel i w tej klasie jest metoda canJump
//        Jumpable jumpableLampda = initParam -> initParam.contains("jump");
//        System.out.println(jumpableLampda.canJump("jumping"));
//        System.out.println(jumpableLampda.canJump("jaumping"));

        Checker lamdaCheck = zmienna -> zmienna % 2 != 0;

        System.out.println(lamdaCheck.check(123));
        System.out.println(lamdaCheck.check(124));

        System.out.println("---------------------------------");
//        predicat test zwraca boolean wiec lamda musi być wyrażeniem na String która zwraca boolean
        Predicate<String> word = someWord -> someWord.length() > 5;
        System.out.println(word.test("noweSlowo"));
        System.out.println(word.test("now"));
    }
}
