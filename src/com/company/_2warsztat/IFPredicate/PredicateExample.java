package com.company._2warsztat.IFPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();

        cities.add("Szczecin");
        cities.add("Warszawa");
        cities.add("Radom");
        cities.add("Brodnica");

//        metoda print z lambdą wpisana bezposrednio
//        print(cities, s -> {
//            System.out.println("Calling lambda from print: " + s);
//            return s.contains("a");
//        });

//        to samo co powyżej tylko ze lamda jest wyciagnieta do zmiennej
        Predicate<String> predicate = s -> {
            System.out.println("Calling lambda from print: " + s);
            return s.contains("a");
        };
        print(cities, predicate);

//        zapisanie powyższego za pomoca MethodReferences
        System.out.println("=--------------------------");
        print(cities, PredicateExample::stringTest);


    }
//      metoda stringTest moze byc uzyta jako metodReference ponieważ strukturą jest taka sama jak motoda test
//    czyli przyjmuje String jako wejscie i zwraca boolean

//    ta metoda ma służyc do zaimlemenotwania metody test z interfejsu funkcyjnergo Predicat
    private static boolean stringTest(String input){
        System.out.println("Calling check from city: " + input);
        return input.contains("a");
    }

    private static void print(List<String> cities, Predicate<String> checker){
        for (String city : cities) {
            if(checker.test(city)){
                System.out.println(city);
            }
        }
    }

}
