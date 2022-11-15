package com.company._1warsztat.zadania_warsztat_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class Zadanie3RozwiazanieZajavka {
    public static void main(String[] args) {

        Collection<Long> list = new HashSet<>(Arrays.asList(2L,4L,3L,1L,2L,3L,4L,7L,8L));

        System.out.println(exerciseThree(list, element -> element % 2 != 0));
    }

//    public static <T extend Collection<E>,E,F extends Predicate<E>> int exerciseThree(T collection, F predicate)
    public static <T> int exerciseThree(Collection<T> col, Predicate<T> pred){
        int counter = 0;
        for (T element  : col) {
            if(pred.test(element)){
                counter++;
            }
        }
        return counter;
    }
}
