package com.company._2warsztat.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacjePosrednieCz_II {
    //    4. operacja peek - operacja pozwala wyswietlic aktualne dane jakie mamy w stream
    //    5. operacja distinct - operacja ta usuwa duplikaty (lista stringow samodzielnie, obiekty to w klasie hashcode i equals)
    //    6. operacja limit - operacja ta okresla ile elementów ma byc brane do działania
    //    7. operacja skip - operacja ta pozwala pominac pewna ilosc elementów

    public static void main(String[] args) {
//      OPERACJA PEEK

        List<Person> people = Arrays.asList(
                new Person("Roman", new City("Warszawa")),
                new Person("Agnieszka", new City("Wrocław")),
                new Person("Karol", new City("Zakopane")),
                new Person("Joanna", new City("Gdynia"))
        );

        List<String> collect = people.stream()
//                .peek(p -> System.out.println("step 1: " + p))
                .map(Person::getCity)
                .map(City::getName)
//                .peek(c -> System.out.println("step 2: " + c))
                .filter(name -> name.contains("W"))
//                .peek(n -> System.out.println("step 3: " + n))
//                .map(name -> name.length())
//                .peek(l -> System.out.println("step 4: " + l))
                .collect(Collectors.toList());
        System.out.println(collect);

//      OPERACJA DISTINCT
//        1. usuwanie duplikatów w przypadku listy Stringów
//        2. uwuwanie duplikatów w przypadku listy obiektów

//        --------------------------------------------------
//        1. usuwanie duplikatów w przypadku listy Stringów
        System.out.println();
        System.out.println("OPERACJA DISTINCT ------------------------------------");
        List<String> cities1 = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk", "Łódź");

        String collect1 = cities1.stream()
//                operacja distinct() - powoduje odsianie od siebie duplikatów
                .distinct()
                .collect(Collectors.joining(","));

        System.out.println(collect1);

//        ------------------------------------------------------------------
//        2. uwuwanie duplikatów w przypadku listy obiektów
// jezeli chcemy usunąc duplikaty z obiektów to musi dodac w klasie City hasCode i equals

        List<City> cities = Arrays.asList(
                new City("Warszawa"),
                new City("Wrocław"),
                new City("Zakopane"),
                new City("Gdynia"),
                new City("Gdynia"),
                new City("Łódź"),
                new City("Łódź"),
                new City("Warszawa"),
                new City("Gdynia"),
                new City("Szczecin"),
                new City("Szczecin"),
                new City("Brodnica")
        );

        String collectCities = cities.stream()
                .distinct()
                .map(City::getName)
                .collect(Collectors.joining(","));

        System.out.println(collectCities);

        //  OPERACJA LIMIT - ogranicza ilosć danych do wykorzystania
        System.out.println();
        System.out.println("OPERACJA LIMIT ------------------------------------");
//  uzycie lilit na streamie skończonym
        List<String> citiesLimit = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Gdańsk", "Łódź");
        citiesLimit.stream()
                .peek(elem -> System.out.println("Step 1: " + elem))
                .map(String::length)
                .peek(elem -> System.out.println("Step 2: " + elem))
                .limit(3)
                .peek(elem -> System.out.println("Step 3: " + elem))
                .forEach(elem -> System.out.println("Step 4: " + elem));

//        uzycie limit na streamie nieskończonym
        System.out.println("ITERATE EXAMPLE");
        Stream<String> iterate = Stream.iterate("start", a -> a + 1);

        iterate
                .peek(elem -> System.out.println("Step 1: " + elem))
                .map(String::length)
                .peek(elem -> System.out.println("Step 2: " + elem))
                .limit(3)
                .peek(elem -> System.out.println("Step 3: " + elem))
                .forEach(elem -> System.out.println("Step 4: " + elem));

        //  OPERACJA LIMIT - ogranicza ilosć danych do wykorzystania
        System.out.println();
        System.out.println("OPERACJA SKIP ------------------------------------");

        List<String> citiesSkip = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Zakopane", "Szczecin");


        citiesSkip.stream()
                .peek(elem -> System.out.println("Step 1: " + elem))
                .map(String::length)
                .peek(elem -> System.out.println("Step 2: " + elem))
                .skip(3)
                .peek(elem -> System.out.println("Step 3: " + elem))
                .forEach(elem -> System.out.println("Step 4: " + elem));

        //  OPERACJA SORTED - operacja ta zbiera calość informacji w stream w miejscu gdzie jest ona wstawiona
//        jezeli otrzyma juz cały stream zaczyna sortować i puszcza stream dalej
        System.out.println();
        System.out.println("OPERACJA SORTED ------------------------------------");

        List<String> citiesSorted = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Zakopane", "Szczecin");

        citiesSorted.stream()
                .peek(elem -> System.out.println("Step 1: " + elem))
                .sorted()
                .forEach(elem -> System.out.println("Step 2: " + elem));

        List<Person> peopleSort = Arrays.asList(
                new Person("Roman",new City("Warszawa")),
                new Person("Agnieszka",new City("Wrocław") ),
                new Person("Karol",new City("Zakopane") ),
                new Person("Joanna",new City("Gdynia") ),
                new Person("Joanna",new City("Łódź") ),
                new Person("Damian",new City("Warszawa") ),
                new Person("Damian",new City("Gdynia") ),
                new Person("Roman",new City("Szczecin")),
                new Person("Roman",new City("Brodnica"))
        );

//        SPOSOBY SORTOWANIA:
//        1. wpisujemy tu sorted() a w klasie Person dodajemy implementacje Comparable<Person> i metode compareTo
//        2. wpisujemy tu sorted(w srodku Comparator:
//                                  a)  (e1, e2) -> e1.getName().compareTo(e2.getName())
//                                  b)  Comparator.comparing(person -> person.getName())
//                                  c)  Comparator.comparing(Person::getName)
        peopleSort.stream()
                .peek(elem -> System.out.println("Step 1: " + elem))
                .sorted(Comparator.comparing(Person::getName))
                .sorted()
                .forEach(elem -> System.out.println("Step 2: " + elem));



    }

}
