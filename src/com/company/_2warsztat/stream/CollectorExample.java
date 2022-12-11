package com.company._2warsztat.stream;

import java.util.*;
import java.util.stream.Collectors;


public class CollectorExample {
//    counting
//    joining
//    toCollection
//    maxBy minBy


    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Warszawa", "Lubin", "Wrocław", "Wrocław", "Kraków", "Poznań");

//        Collectors.counting()
        System.out.println("Collectors.counting()");
        long countResult = cities.stream()
                .filter( element-> element.length() > 5)
                .collect(Collectors.counting());
        System.out.println(countResult);

//        Collector.joining()
        System.out.println();
        System.out.println("Collector.joining()");
        String collect = cities.stream()
                .filter( elem -> elem.length() > 4)
//                .collect(Collectors.joining(","));
                .collect(Collectors.joining("==-==","start ", " end"));
        System.out.println(collect);


//        Collector.toCollection()
        System.out.println();
        System.out.println("Collector.toCollection()");

        List<String> collectList = cities.stream()
                .filter(elem -> elem.length() > 6)
                .collect(Collectors.toList());


        Set<String> collectSet = cities.stream()
                .filter(elem -> elem.length() > 6)
                .collect(Collectors.toSet());

//        zamiast pisac na poczatku czy dany typ danych to bedzie lista czy set mozemy
//        zastosować var zeby java mogla sama okreslac jaki to jest typ danych zwracanych

//         jezeli uzyjemy var mozemy wrzucic cokolwiek toList() albo toSet()
        var collectSomething = cities.stream()
                .filter(elem -> elem.length() > 6)
//                .collect(Collectors.toSet());
                .collect(Collectors.toList());


//         jezeli uzywamy toList() albo toSet() to nie mamy gwarancji jaki to będzie typ zwracany
//        np toList() zwraca ArrayList ale nie musi
//        np toSet() zwraca HashSet ale nie musi
//        sprwadzenia jaki typ klasy jest zwracany wpisujemy kod ponizej
        System.out.println(collectSomething.getClass());

//        jezeli chcemy np wymusić TreeSet dany typ zwracany to wtedy piszemy tak
        var collectTest = cities.stream()
                .filter(elem -> elem.length() > 6)
                .collect(Collectors.toCollection(()-> new TreeSet<>()));
        System.out.println(collectTest.getClass());



//        Collector.maxBy()  ,   Collector.minBy()
        System.out.println();
        System.out.println("Collector.maxBy()  ,   Collector.minBy()");
        List<String> cities2 = Arrays.asList("Warszawa","Abramowice", "Lubin", "Wrocław", "Wrocław", "Kraków", "Poznań");

        Optional<String> maxBy = cities2.stream()
//                .collect(Collectors.maxBy(Comparator.naturalOrder()));
                .collect(Collectors.maxBy(Comparator.<String>naturalOrder().reversed()));
        System.out.println(maxBy);

    }
}


