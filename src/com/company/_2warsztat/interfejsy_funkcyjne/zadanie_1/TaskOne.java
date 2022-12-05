package com.company._2warsztat.interfejsy_funkcyjne.zadanie_1;

import java.util.function.BiFunction;

public class TaskOne {
    public static void main(String[] args) {
        BiFunction<Integer, Double, String> taskOne = TaskOne::extractMethod;
        String apply = taskOne.apply(4, 6.7);
        System.out.println(apply);
    }

    private static String extractMethod(Integer one, Double two) {
        System.out.println("first arg: " + one + " second arg: " + two);
        return one.toString().concat(two.toString());
//        return "" + one + two;
    }
}
