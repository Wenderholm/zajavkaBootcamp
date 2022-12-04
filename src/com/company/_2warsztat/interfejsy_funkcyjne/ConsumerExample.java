package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
//        Consumer to metoda accept
//        Consumer wykorzytujemy wtedy kiedy cos konsumujemy i nic nie zwracamy
//        Consumer<String> consumer1 = input -> {
//            extracted(input);
//        };


//        powyższe zapisane za pomoca methodReference
//     metoda extract tak samo jak metoda a accept przyjmuje jakąś wartość i nic nie zwraca
        Consumer<String> consumer1 = ConsumerExample::extracted;
        consumer1.accept("Zakopane");
    }


    private static void extracted(String input) {
        System.out.println("Calling accetp");
        System.out.println(input);
    }
}
