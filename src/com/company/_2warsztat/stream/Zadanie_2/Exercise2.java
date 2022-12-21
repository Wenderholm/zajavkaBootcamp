package com.company._2warsztat.stream.Zadanie_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Exercise2 {
    public static void main(String[] args) {
        String[] letters = {"z", "x", "a", "j", "a", "v", "x", "k", "a", "x"};
        String result = Stream.of(letters)
                .map(x -> x.toUpperCase())
                .filter(letter -> !letter.contains("X"))
//                .filter(letter-> !"x".equalsIgnoreCase(letter))
                .sorted(Comparator.<String>naturalOrder().reversed())
                .reduce((""), (left, right) -> left + right);
        System.out.println(result);
    }

}
