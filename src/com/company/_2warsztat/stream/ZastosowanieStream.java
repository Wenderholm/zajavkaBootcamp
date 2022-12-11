package com.company._2warsztat.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZastosowanieStream {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk", "Łódź");

//        List<Integer> collect = stringList.stream()
//                .map(s -> s.length())
//                .sorted((e1, e2) -> e2.compareTo(e1))
//                .skip(1)
//                .limit(2)
//                .collect(Collectors.toList());
//
//        System.out.println(collect);


        List<String> collect1 = stringList.stream()
                .filter(elem -> elem.length() > 5)
                .sorted(Comparator.<String>naturalOrder().reversed())
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(collect1);
    }
}
