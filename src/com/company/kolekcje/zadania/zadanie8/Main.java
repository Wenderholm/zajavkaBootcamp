package com.company.kolekcje.zadania.zadanie8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,-3,-5);
        Collections.sort(list);
        Integer[] arr = list.toArray(new Integer[5]);
        System.out.println(Arrays.toString(arr));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i,++i);
        }

        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }
}
