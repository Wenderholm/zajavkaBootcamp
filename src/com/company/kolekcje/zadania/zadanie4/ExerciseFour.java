package com.company.kolekcje.zadania.zadanie4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExerciseFour {
    public static void main(String[] args) {

        List<Integer> numb = new ArrayList<>(Arrays.asList(5, 3, 6, 7, 12, 33, 4, 6, 7, 1, 2, 1, 33, 23, 12));

        System.out.println("------first task-------------");
        moveMaxToEnd(numb);

        System.out.println("------second task-------------");
        List<Integer> integersChecked = newListMoveMaxToEnd(numb);
        System.out.println(integersChecked);


    }

    public static void moveMaxToEnd(List<Integer> list) {
        int maxValue = list.get(0);
        for (Integer val : list) {
            if (val > maxValue) {
                maxValue = val;
            }
        }
        System.out.println("Max value: " + maxValue);
//        usunięcie wystąpienia max value
        list.removeAll(Collections.singleton(maxValue));
        list.add(maxValue);
        System.out.println(list);
    }

    public static List<Integer> newListMoveMaxToEnd(List<Integer> list){
        int maxValue = list.get(0);
        for (Integer val : list) {
            if(val > maxValue){
                maxValue = val;
            }
        }
        List<Integer> mixList = new ArrayList<>();
        for (Integer val : list) {
            if(val != maxValue){
                 mixList.add(val);
            }
        }
        mixList.add(maxValue);
        return mixList;
    }

}
