package com.company.kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToTableAndTableToList {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};

        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.add(5);

        System.out.println(Arrays.toString(array));

        Integer[] objects = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(objects));

    }
}
