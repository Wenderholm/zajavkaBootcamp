package com.company._2warsztat.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

//        Stream - mozemy traktować jako linia produkcyjna

//        Stream pipeline
//        1. żródło
//        2. operacja pośrednia
//        3. operacja determinujaca

//        żródło i operacje determinujace muszą być
//        operacja pośrednia - może ich występować kilka
//        operacja pośrednia - nie zostaną uruchomione do czasu wywołąnia operacji determinującej
//        operacja determinujaca - może być wywołąna tylko raz

//        sposoby tworzenia Streamow
        Stream<String> empty = Stream.empty();
//        zródło
        Stream<String> stringStream = Stream.of("1","7","9")
//                operacja pośrednia
                .peek( elem -> System.out.println("elementy: " + elem));
//      operacja determinująca
        stringStream.collect(Collectors.toList());
//    UWAGA !!! strumien danych moze być użyty tylko raz
//        stringStream.collect(Collectors.toList());

//        STREAMY DZIELA SIE NA SKONCZONE (PRZYKŁADY POWYZEJ) I NIESKONCZONE

//      metoda generuje caly czas dane. przyjmuje ona Supplier gdzie wypisuje sie losowe dane
//        metoda peek sprawdza co jest drukowane
//        collect to jest metoda determinujaca
        Stream.generate(()->Math.random())
                .peek(elem -> System.out.println("elem: " + elem))
                .collect(Collectors.toList());

//        metoda iterate generuje caly czas dane. przyjmuje UnaryOperator który przyjmuje integer i zwraca integer + 1
        Stream.iterate(0, prev -> prev + 1)
                .peek(elem -> System.out.println("elem: " + elem))
                .collect(Collectors.toList());
    }
}
