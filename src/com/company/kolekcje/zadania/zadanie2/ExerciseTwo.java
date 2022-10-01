package com.company.kolekcje.zadania.zadanie2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ExerciseTwo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");

//        System.out.println("My orginal list:\n " + stringList);
//        Collections.shuffle(stringList);
//        System.out.println("My shuffled list:\n " + stringList);

        System.out.println("My orginal list:\n " + stringList);
        shufArray(stringList);
        System.out.println("My shuffled list:\n " + stringList);


    }

    public static void shufArray(List<String> arr){
            Random random = new Random();

        for (int i = arr.size() - 1 ; i > 0 ; i--) {
            int j = random.nextInt(i);

            String temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j, temp);

        }

    }
}
