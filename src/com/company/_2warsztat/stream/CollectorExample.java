package com.company._2warsztat.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorExample {
    //    counting
//    joining
//    toCollection
//    maxBy minBy
//    mapping
//    toMap
//    partitioningBy
//    groupingBy
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Warszawa", "Lubin", "Wrocław", "Wrocław", "Kraków", "Poznań");

//        Collectors.counting()
        System.out.println("Collectors.counting()");
        long countResult = cities.stream()
                .filter(element -> element.length() > 5)
                .collect(Collectors.counting());
        System.out.println(countResult);

//        Collector.joining()
        System.out.println();
        System.out.println("Collector.joining()");
        String collect = cities.stream()
                .filter(elem -> elem.length() > 4)
//                .collect(Collectors.joining(","));
                .collect(Collectors.joining("==-==", "start ", " end"));
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
                .collect(Collectors.toCollection(() -> new TreeSet<>()));
        System.out.println(collectTest.getClass());


//        Collector.maxBy()  ,   Collector.minBy()
        System.out.println();
        System.out.println("Collector.maxBy()  ,   Collector.minBy()");
        List<String> cities2 = Arrays.asList("Warszawa", "Abramowice", "Lubin", "Wrocław", "Wrocław", "Kraków", "Poznań");

        Optional<String> maxBy = cities2.stream()
//                .collect(Collectors.maxBy(Comparator.naturalOrder()));
                .collect(Collectors.maxBy(Comparator.<String>naturalOrder().reversed()));
        System.out.println(maxBy);


//        Collector.mapping()
        System.out.println();
        System.out.println("Collector.mapping()");
        List<String> cities3 = Arrays.asList("Warszawa", "Abramowice", "Lubin", "Wrocław", "Wrocław", "Kraków", "Poznań");

        Integer reduce = cities3.stream()
                .map(String::length)
                .reduce(0, (a, b) -> a + b);

        System.out.println(reduce);

//        zapis ponizej jest tozsamy z tym powyzej
        Integer reduce2 = cities3.stream()
//                chodzi o to ze mapping daje nam to ze zanim wywolamy koncowy collector to mamy mozliwosc wywolania
//                jeszcze przd nim jednego przemapowania
                .collect(Collectors.mapping(ele -> ele.length(), Collectors.reducing(0, (a, b) -> a + b)));

        System.out.println(reduce2);

//        Collector.toMap()
        System.out.println();
        System.out.println("Collector.toMap()");
        List<String> citiesToMap1 = Arrays.asList("Warszawa", "Abramowice", "Lubin", "Wrocław", "Kraków", "Poznań");

        System.out.println("1 przypadek --------------------------------------------------------------------");
//        to nam zadziala jezeli nie beda sie powtarzaly klucze ktorymi u nas sa nazwy miast a ich wartosciami ich dlugosci
//        nie zadziala to poniewaz nie mozemy miec dwoch identycznych kluczy
        Map<String, Integer> result = citiesToMap1.stream()
                .collect(Collectors.toMap(key -> key, value -> value.length()));

        result.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));


        System.out.println("2 przypadek-------------------------------------------------------------------");
        List<String> citiesToMap2 = Arrays.asList("Warszawa", "Abramowice", "Brodnica", "Chojnice", "Lubin", "Wrocław", "Kraków", "Poznań");
//        pprzyklad ze zmiana klucza i wartosci oraz jak sobie poradzic z powtarzjacymi elementami jako kulcz
//        trzeba dodac margeFunction jako 3 argument do toMap. to w tym miejscu przekazujemy co chcemy zorbic jezeli
//        elementy sie powtórzą
        Map<Integer, String> result2 = citiesToMap2.stream()
                .collect(Collectors.toMap(key -> key.length(),
                        value -> value,
                        (left, right) -> left + ", " + right));

        result2.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));

        System.out.println("3 przypadek----------------------------------------------------------------");
//     ten sposob pokazuje jak mozemy do danego klucza wrzucic miasta jako jego lista
        Map<Integer, List<String>> result3 = citiesToMap2.stream()
                .collect(Collectors.toMap(key -> key.length(),
                        value -> List.of(value),
                        (left, right) -> merge(left, right)));
        result3.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));
        System.out.println(result3.getClass());

        System.out.println("4 przypadek-----------------------------------------------------------------");
//     ostatni sposob pokazuje jak mozemy wymusic typ zwracany poniewaz dmyslnie nie jest on okreslony i mozemy dostac
//     rozne typy zwracane
        Map<Integer, List<String>> result4 = citiesToMap2.stream()
                .collect(Collectors.toMap(key -> key.length(),
                        value -> List.of(value),
                        (left, right) -> merge(left, right),
                        () -> new TreeMap<Integer, List<String>>()));
        result4.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));
        System.out.println(result4.getClass());


        System.out.println();
        System.out.println("Collector.partitioningBy()");
        List<String> citiesToMap3 = Arrays.asList("Warszawa", "Abramowice", "Lubin", "Wrocław", "Kraków", "Poznań");

//        1 przypadek dostajemy tu dwa klucze jeden to true a drugi to false
//        w zaleznosci od tego jaki mamy warunek jako predicate to tak zostana dane podzielone
        System.out.println("1 przypadek --------------------------------------------------------");
        Map<Boolean, List<String>> collect1 = citiesToMap3.stream()
                .collect(Collectors.partitioningBy(elem -> elem.length() > 6));
        collect1.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));

        System.out.println("2 przypadek --------------------------------------------------------");
//        2 przypadek gdy chcemy nasze dane przypisac do konkretnej kolekcji np do TreeSet
        Map<Boolean, Set<String>> collect2 = citiesToMap3.stream()
                .collect(Collectors.partitioningBy(elem -> elem.length() > 6, Collectors.toCollection(TreeSet::new)));
        collect2.forEach((key, value) -> {
            System.out.println(value.getClass());
            System.out.println("Key: " + key + " - value: " + value);
        });

        System.out.println();
        System.out.println("Collector.groupingBy()");
        List<String> citiesToMap4 = Arrays.asList("Warszawa", "Abramowice", "Lubin", "Wrocław", "Kraków", "Poznań", "Poznań");

//      jezeli chcemy pogrupowac nasze miasta po dlugosci znaków
        System.out.println("1 przypadek --------------------------------------------------------");
        Map<Integer, List<String>> collect3 = citiesToMap4.stream()
                .collect(Collectors.groupingBy(elem -> elem.length()));
        collect3.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));

//        dodwanie jaki chcemy miec typ kolekcji na wyjsciu
        System.out.println("2 przypadek toList()--------------------------------------------------------");
        Map<Integer, List<String>> collect4 = citiesToMap4.stream()
                .collect(Collectors.groupingBy(elem -> elem.length(), Collectors.toList())); // <- w tym przypadku typ wyjsciowy Lista moga byc powtórzenia
        collect4.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));

        System.out.println("2 przypadek toSet()--------------------------------------------------------");
        Map<Integer, Set<String>> collect5 = citiesToMap4.stream()
                .collect(Collectors.groupingBy(elem -> elem.length(), Collectors.toSet())); // <- tu Set usuwa powtórzenia
        collect5.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));

        System.out.println("3 przypadek counting() zliczenie ile mamy miast o danej dlugosci -------------");
        Map<Integer, Long> collect6 = citiesToMap4.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        collect6.forEach((key, value) -> System.out.println("Miast o długości: " + key + " - jest na naszej liscie : " + value));
        System.out.println();


        System.out.println("zadanie");
        List<String> citiesTask = Arrays.asList("szczecin", "zakopane", "gdynia");
//        citiesTask.stream().map((a,b)-> a.length() - b.length())
    }


    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>(left);
        result.addAll(right);
        return result;
    }
}


