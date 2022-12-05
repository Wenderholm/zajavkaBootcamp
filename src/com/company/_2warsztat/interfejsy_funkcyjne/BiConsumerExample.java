package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
//        BiConsumer<String, Cat> consumer1 = (str, c) -> System.out.println("Cat : " + c + " likes eating words: " + str);

//        w tym przypadku nie musimy wpisywać return ponieważ BiConsumer zwraca void
//        BiConsumer<String, Cat> consumer1 = (str, c) -> {
//            System.out.println("Cat : " + c + " likes eating words: " + str);
//        };

//        BiConsumer<String, Cat> consumer1 = (str, c) -> getPrintln(str, c);

        BiConsumer<String, Cat> consumer1 = BiConsumerExample::getPrintln;

        consumer1.accept("exampleWord" , new Cat());
     }

    private static void getPrintln(String str, Cat c) {
        System.out.println("Cat : " + c + " likes eating words: " + str);
    }

    static class Cat{

    }
}
