package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
//        jezeli mielibysmy interfejs funkcyjny Function z dwoma takimi samymi typami to mozemy użyć w to miejsce
//        UnaryOperatora
//        UnaryOperator<String> unaryOperator = str -> str + str;

//        UnaryOperator<String> unaryOperator = str -> {
//            System.out.println("calling lambda");
//            return str + str;
//        };

//        UnaryOperator<String> unaryOperator = str -> doublePowerString(str);

        UnaryOperator<String> unaryOperator = UnaryOperatorExample::doublePowerString;

        System.out.println(unaryOperator.apply("zajawka"));
    }

    private static String doublePowerString(String str) {
        System.out.println("calling lambda");
        return str + str;
    }
}
