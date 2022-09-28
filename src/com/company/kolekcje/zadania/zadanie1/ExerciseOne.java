package com.company.kolekcje.zadania.zadanie1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExerciseOne {
    public static void main(String[] args) {

        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("tree");
        strings.add("four");


        Iterator<String> elements = strings.iterator();
        int counter = 0;
        while(elements.hasNext()){
            counter++;
            if(counter == strings.size()){
                System.out.print(elements.next());
            }else{
                System.out.print(elements.next() + ", ");
            }
        }



    }


}
