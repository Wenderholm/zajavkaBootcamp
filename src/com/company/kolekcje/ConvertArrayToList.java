package com.company.kolekcje;

import java.util.Arrays;
import java.util.List;

public class ConvertArrayToList {
    public static void main(String[] args) {
        Integer[] array = {1,3,4,7};
        List<Integer> list = Arrays.asList(array);

        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers));

    }
}
