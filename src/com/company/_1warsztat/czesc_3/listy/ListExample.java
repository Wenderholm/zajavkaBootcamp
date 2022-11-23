package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
//        implementacje list
        List<String> list1 = Arrays.asList("a","b","c");
        List<String> list2 = List.of("a","b","c");
        List<String> list3 = Collections.singletonList("x");
        List<String> list4 = Collections.emptyList();
        List<String> list5 = new LinkedList<>();
        List<String> list6 = new ArrayList<>();

//        metody do wykonania
//        void add(T element) - dodawanie elmentów
//        void add(int index, T element) - dodawanie elmentów
//        get(int index) - wyswietlenie obiektu z danego indeksu
//        int indexOf(o) - wyswietlenie ineksu obiektu. jezeli go nie ma -1
//        int lastIndexOf(o) - wyswietlenie indeksu ostatniego wystąpienia. jezeli go nie ma -1
//        remove(int index) - usunięcie elementu z podanego indeksu
//        set(int index, T e) - ustawienie elementu na danym indeksie
        list6.add("a");
        list6.add("b");
        list6.add("c");
        list6.add("d");
        list6.add("e");
        list6.add("f");
        list6.add("e");

        list6.add(3,"123");
        System.out.println(list6);
        System.out.println(list6.get(2));
//        System.out.println(list6.get(7)); <- wyrzuci wyjatek IndexOutOfBoundsException poniewaz nie ma tekiego indeksu
        System.out.println(list6.indexOf("e"));
        System.out.println(list6.lastIndexOf("e"));
        System.out.println(list6.remove("f"));
//        zwraca co zostanie zmienione
        System.out.println(list6.set(2, "nowy string"));
        System.out.println(list6);

        list5.add("a");
        list5.add("b");
        list5.add("a");
        list5.add("a");
        list5.add("e");
        list5.add("f");
        list5.add("f");

        System.out.println(list5);

    }
}
