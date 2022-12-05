package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.*;
import java.util.function.BiPredicate;

public class PodsumowanieFunctionalInterface {

//    1. na wejsciu jakis obiekt i na wyjsciu jakis obiekt -> ten sam obiekt na wejsciu i wyjsciu UnaryOperator
//                                                         -> inny obiekt na wejsciu inny na wyjsciu Function
//    2. na wejsciu cokolwiek i na wyjsciu boolean -> Predicat
//    3. na wejsciu nic i na wyjsciu cos produkowane -> Supplier
//    4. na wejsciu cos i na wyjsciu void -> Consumer
//    5. na wejsciu 2 cosie i na wyjsciu coś -> jeżeli 2 cosie i wyjscie takie same to binaryOperator
//                                           -> jezeli 2 cosie i inny na wyjsciu to BiFunction
//    6. na wejsciu 2 rozne cosie i na wyjsciu void -> BiConsumer

    public static void main(String[] args) {
//        WYKORZYTANIE PREDICATE
//        z tego optionala zostanie wyswietlona zawartosc jezeli przejdzie filtr
//        Optional<String> optionalString = Optional.of("optionalString").filter(s -> s.length() > 2);

//        jezeli nie przejdzie optionala to wyświetli nam sie Optional.empty
        Optional<String> optionalString = Optional.of("").filter(s -> s.length() > 2);

        System.out.println(optionalString);

        List<String> stringList = new ArrayList<>();
        stringList.add("someValue1");
        stringList.add("someValue1");
        stringList.add("someValue3");
        System.out.println(stringList);
        stringList.removeIf(s->s.contains("1"));
        System.out.println(stringList);

//        WYKORZYSATNIE CONSUMERA
        System.out.println("CONSUMER EXAMPLE");
        Optional.of(1).ifPresent(s -> System.out.println("present")); // <- wyswietli sie wartosc present
        Optional.empty().ifPresent(s -> System.out.println("present"));// <- nie wyswietli się nic

//        WYKORZYSTANIE SUPPLIER
        System.out.println("SUPPLIER EXAMPLE");
        String s = Optional.<String>empty().orElseGet(() -> "default value");
        System.out.println(s);

//        WYKORZYSTANIE BiConsumer
        System.out.println("BISUPPLIER EXAMPLE");
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"firstValue");
        map.put(2,"secondValue");
        map.forEach((k,v) ->{
            System.out.println("for key: " + k + " value is: " + v);
        });
//        WYKORZYSTANIE BiFunction
        System.out.println(map);
        map.replaceAll((k,v) -> v.concat("added"));
        System.out.println(map);

//        WYKORZYSTANIE UnaryOperator
        List<String> list2 = new ArrayList<>();
        list2.add("first");
        list2.add("second");
        list2.replaceAll(s1 -> s1.concat("NewAdd"));
        System.out.println(list2);

    }
}
