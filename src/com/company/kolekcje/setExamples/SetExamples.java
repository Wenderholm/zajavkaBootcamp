package com.company.kolekcje.setExamples;

import java.util.*;

public class SetExamples {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Gdansk");
        set1.add("Warszawa");
        set1.add("Szczecin");
        set1.add("Szczecin");
        set1.add("Szczecin");
        set1.add("Wrocław");
        System.out.println(set1);
//        rozmiar set
        System.out.println(set1.size());
//        czyszczenie
//        set.clear();

        Set<String> set2 = new HashSet<>();
        set2.add("łódź");
        set2.add("Warszawa");
        set2.add("biaystok");
        set2.add("zakopane");
        set2.add("Szczecin");
        set2.add("Wrocław");

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("SET1: " + set1);
        System.out.println("SET2: " + set2);
        System.out.println("Union: " + union);

        System.out.println("----------przecięcie lub wspólne elementy---------");

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("SET1: " + set1);
        System.out.println("SET2: " + set2);
        System.out.println("Retain : " + intersection);

        System.out.println("----------------------------------------------------");

        Set<String> setWithCities = new HashSet<>();
        setWithCities.add("łódź");
        setWithCities.add("biaystok");
        setWithCities.add("Radom");
        setWithCities.add("Lublin");
        setWithCities.add("Szczecin");
        setWithCities.add("Wrocław");

        method(setWithCities);

        ArrayList<String> arrayListWithCities = new ArrayList<>();
        arrayListWithCities.add("łódź");
        arrayListWithCities.add("biaystok");
        arrayListWithCities.add("Radom");
        arrayListWithCities.add("Lublin");
        arrayListWithCities.add("Szczecin");
        arrayListWithCities.add("Wrocław");

        method(arrayListWithCities);

        LinkedList<String> linkedListWithCities = new LinkedList<>();
        linkedListWithCities.add("łódź");
        linkedListWithCities.add("biaystok");
        linkedListWithCities.add("Radom");
        linkedListWithCities.add("Lublin");
        linkedListWithCities.add("Szczecin");
        linkedListWithCities.add("Wrocław");

        method(linkedListWithCities);

    }

    private static void method(Collection<String> stringSet) {
        for (String s : stringSet) {
            System.out.println(s);
        }
    }
}
