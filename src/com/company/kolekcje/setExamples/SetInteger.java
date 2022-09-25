package com.company.kolekcje.setExamples;

import java.util.HashSet;
import java.util.Set;

public class SetInteger {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(8);
        set1.add(10);
        set1.add(11);


//      remove podajemy po konkretnym obiekci jeżeli nie będzie takeigo obiektu zwróci false
        System.out.println(set1.remove(7));
        System.out.println(set1);


        for (Integer integer : set1) {
            System.out.println(integer);
        }
//      sprawdzenie jeżeli jest to true jezeli nie to wypisze false
        System.out.println(set1.contains(8));

        Set<Integer> set2 = new HashSet<>();
        set2.add(8);
        set2.add(10);
        set2.add(13);

//        tu zmieniamy set 1. do set 1 dodajemy set 2
        Set<Integer> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(resultSet);

        System.out.println("---- wyswietlenie tego co jest w set1 a nie ma w set2");
        Set<Integer> resultSetRetainAll = new HashSet<>(set1);
        resultSetRetainAll.removeAll(set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(resultSetRetainAll);

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Ogniem i mieczem"));
        bookSet.add(new Book("Ogniem i mieczem"));

        System.out.println(bookSet);

    }


}
