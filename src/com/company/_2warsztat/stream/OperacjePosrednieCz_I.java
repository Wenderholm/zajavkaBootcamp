package com.company._2warsztat.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OperacjePosrednieCz_I {
//    1. operacja filter
//    2. operacja map
//    3. operacja flatMap
//    ssh bd -> wze - sudo reboot -> wze


    public static void main(String[] args) {
//      OPERACJA FILTER ---------------------------
        List<String> cities = Arrays.asList("Warszawa", "Wrocław" , "Zakopane", "Gdynia", "Łódź", "Warszawa", "Gdynia");
//        Stream<String> stream = cities.stream();
//        to działa jak koniunkcja czyli logiczne i. zostanie misto ktore zawiera a,o,e w nazwie
//        Stream<String> filterResult = stream
//                .filter(city -> city.contains("a"))
//                .filter(city -> city.contains("o"))
//                .filter(city -> city.contains("e"));

//    to dziala jak logiczne lub czyli zostana miasta które maja a lub o lub e
        List<String> collect = cities.stream()
                .filter(city -> city.contains("a") || city.contains("o") || city.contains("e"))
                .collect(Collectors.toList());
        System.out.println(collect);

//      OPERACJA MAP ---------------------------

        List<String> cities2 = Arrays.asList("Warszawa", "Wrocław" , "Zakopane", "Gdynia", "Łódź", "Warszawa", "Gdynia");
//        List<Integer> stream2 = cities2.stream()
//                .map(city -> city.length())
//                .collect(Collectors.toList());

        List<String> stream2 = cities2.stream()
                .map(city -> city + "zajavka")
                .collect(Collectors.toList());

        System.out.println(stream2);

        List<Person> people = Arrays.asList(
                new Person("Roman",new City("Warszawa")),
                new Person("Agnieszka",new City("Wrocław") ),
                new Person("Karol",new City("Zakopane") ),
                new Person("Joanna",new City("Gdynia") ),
                new Person("Ewelina",new City("Łódź") ),
                new Person("Bartosz",new City("Warszawa") ),
                new Person("Damian",new City("Gdynia") ),
                new Person("Roman",new City("Szczecin")),
                new Person("Adam",new City("Brodnica"))
        );

//        String stream = people.stream()
//                .map(person -> person + "A")
//                .map(word -> word.toUpperCase())
//                .reduce("start", (a, b) -> a.concat(b));


//        String stream = people.stream()
//                .map(person -> person.getCity())
//                .map(city -> city.getName())
//                .reduce("start", (a, b) -> String.format("%s - %s",a,b));

        AtomicInteger counter = new AtomicInteger();
        String stream = people.stream()
                .map(Person::getCity)
                .map(city -> city.getName() + " " + counter.incrementAndGet())
                .reduce("start", (a, b) -> String.format("%s - %s",a,b));
        System.out.println(stream);
        System.out.println("ilosc miast: " + counter);

//      OPERACJA MAP ---------------------------
        List<String> cities11 = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocaław", "Gdańsk", "Łódź");
        List<String> cities12 = Arrays.asList("Białystok", "Szczecin", "Łódź", "Zakopane", "Gdańsk", "Łódź");
        List<String> cities13 = Arrays.asList("Warszawa", "Lublin", "Wrocław", "Wrocaław", "Kraków", "Poznań");

        List<List<String>> citiesCombined = List.of(cities11, cities12, cities13);

        System.out.println(citiesCombined);

//        w tym przypadku dostajemy Stream listy Stringów zeby spłaszczyc strukturę danych należy uzyc flatMap
//        Stream<List<String>> stream1 = citiesCombined.stream();

        Set<String> stream1 = citiesCombined.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toSet());

        System.out.println(stream1);

    }
}
