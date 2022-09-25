package com.company.kolekcje.mapAndHashMap;


import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> people = new HashMap<>();
        people.put(1, "Norbert Adamski");
        people.put(2, "Adam Bartnicki");
        people.put(3, "Roman Czeczek");

        System.out.println(people);

//        przepisanie mapy do mapy
        Map<Integer, String> anotherPeople = new HashMap<>(people);
        System.out.println(anotherPeople);

//        wyciaganie danych z podanego klucza
        System.out.println("Get key:" + people.get(5)); // jeżeli nie ma takiej wartości to będzie NULL
        System.out.println("Get key:" + people.get(1));

//        usuwanie kluczy z ich wyswietleniem
        System.out.println("remove key: " + people.remove(5)); // jeżeli nie ma takiej wartości wyświetla się NULL
        System.out.println("remove key: " + people.remove(1)); // wyświetla usunięta wartość

        System.out.println(people);

//        sprawdzenie czy podana mapa jest pusta
        System.out.println("isEmpty: " + people.isEmpty());
        System.out.println("size: " + people.size());

//        sprawdzenie czy zawiera taki klucz oraz wartość
        System.out.println("containsKey: " + people.containsKey(4));
        System.out.println("containsKey: " + people.containsKey(2));
        System.out.println("containsValue: " + people.containsValue("Adam Bartnicki"));

        Map<Integer, List<String>> people2 = new HashMap<>();
        people2.put(1, List.of("Norbert Adamski", "Robert Natanowski"));
        people2.put(2, Collections.emptyList());
        people2.put(3, Collections.singletonList("Roman Czeczek"));

        System.out.println(people2);

        System.out.println("------------------------------------------");


        Set<Integer> integers = people.keySet();
        Collection<String> values = people.values();
//      wyświetlenie wartości mapy
        for (String value : values) {
            System.out.println(value);
        }

//        wyświetlenie kluczy mapy
        for (Integer integer : integers) {
            System.out.println(integer);
        }
//        wyswietlanie calej mapy
        Set<Map.Entry<Integer, String>> entries = people.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        Map<Car, List<String>> opinions = new HashMap<>();

        Car car1 = new Car("BMW", "X3", 2020);
        Car car2 = new Car("Audi", "A4", 2018);
        Car car3 = new Car("Mercedes", "G-class", 2019);

        opinions.put(car1, List.of("good", "bad"));
        opinions.put(car2, List.of("very good", "brilliant"));
        opinions.put(car3, List.of("not well", "i prefer faster cars"));

        System.out.println(opinions.get(car1));
        System.out.println(("HasCode: " + car1.hashCode()));

//        to zmienia hasCode i już nie sa te same objekty
        car1.setModel("AAA");

        System.out.println(opinions.get(car1));
        System.out.println(("HasCode: " + car1.hashCode()));
    }
}
