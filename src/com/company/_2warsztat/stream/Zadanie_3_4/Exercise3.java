package com.company._2warsztat.stream.Zadanie_3_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise3 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);

        Integer collect = numbers.stream()
                .sorted()
                .distinct()
//                .peek(elem -> System.out.print(elem + " "))
//                .sorted(Comparator.comparingInt((Integer a) -> a))
                .skip(1)
                .limit(1)
//                .reduce(0, (l, r) -> l + r);
                .findFirst()
                .orElseThrow(() -> new RuntimeException("there is no second element"));
//                .collect(Collectors.toList());
        System.out.println(collect);


        Optional<Integer> first = numbers.stream()
                .sorted(Comparator.<Integer>naturalOrder().reversed())
                .skip(1)
                .limit(1)
                .findFirst();

        System.out.println(first);
    }

}
