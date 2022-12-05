package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {

//        interfejs funkcyjny function<T,T,T> zamiast tego mozemy użyc BinaryOperator<T,T>

//        wejsciowe typy to String i String a na wyjściu będziemy mieli String
//        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;

//        BinaryOperator<String> binaryOperator = (str1, str2) -> {
//            System.out.println("calling lambda");
//            return str1 + str2;
//        };

//        BinaryOperator<String> binaryOperator = (str1, str2) -> extractMethod(str1, str2);

        BinaryOperator<String> binaryOperator = BinaryOperatorExample::extractMethod;

        String apply = binaryOperator.apply("zajavka ", "jest fajna");
        System.out.println(apply);
    }

    private static String extractMethod(String str1, String str2) {
        System.out.println("calling lambda");
        return str1 + str2;
    }
}
