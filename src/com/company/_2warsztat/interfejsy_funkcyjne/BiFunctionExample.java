package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {

// biFunction<T,U,R> przyjmuje trzy typy. dwa pierwsze T, U to typy przyjmowane a typ R jest zwracany
//        BiFunction<Table, Window, String> bifunctionImpl = (tab, wind) -> {
//            return tab.toString().concat(" #### ").concat(wind.toString());
//        };

//        BiFunction<Table, Window, String> bifunctionImpl = (tab, wind) -> tab.toString().concat(" #### ").concat(wind.toString());

//        BiFunction<Table, Window, String> bifunctionImpl = (tab, wind) -> getExtractMet(tab, wind);

        BiFunction<Table, Window, String> bifunctionImpl = BiFunctionExample::getExtractMet;

//        wywołanie caller
        Caller cal = new Caller();
//        uzycie metody instancyjnej concat z klasy Caller
        BiFunction<Table, Window, String> bifunctionImpl2 = cal::concat;


        String apply = bifunctionImpl.apply(new Table(), new Window());
        System.out.println(apply);
    }

    private static String getExtractMet(Table tab, Window wind) {
        return tab.toString().concat(" #### ").concat(wind.toString());

    }

    static class Caller {
//        metoda instancyjna
        String concat(Table tab, Window wind) {
            return tab.toString().concat(" #### ").concat(wind.toString());
        }
    }

    static class Table {
    }

    static class Window {
    }
}