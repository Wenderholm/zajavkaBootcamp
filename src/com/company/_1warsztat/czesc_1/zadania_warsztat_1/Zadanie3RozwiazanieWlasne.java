package com.company._1warsztat.czesc_1.zadania_warsztat_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Zadanie3RozwiazanieWlasne {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,5,6,6,6,6,33,23,45,12,33,50,10));
        List<String> palindList = new ArrayList<>(Arrays.asList("nowak", "natan", "rodor", "roman"));

        System.out.println("wyswietlenie ilości liczb parzystych");
        System.out.println(pred(list, element -> element % 2 != 0));

        System.out.println("wyświetlenie palindromów ");
       palindromeMethod(palindList, element -> (palindromeCheck(element)));


    }
//  T jest to typ jaki chcemy żeby był podczas użycia metody
    static <T> int pred(List<T> num, Predicate<T> predicate ){
        int counter = 0;
        for (T t : num) {
            if(predicate.test(t)){
                counter++;
            }
        }
        return counter;
    }

    static <T> void palindromeMethod(List<T> palList, Predicate<T> pred){

        for (T t : palList) {
            if(pred.test(t)){
                System.out.println(t);
            }
        }
    }

    static boolean palindromeCheck(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


}
