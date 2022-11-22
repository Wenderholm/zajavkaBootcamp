package com.company._1warsztat.czesc_1.zadania_warsztat_1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Zadanie5RozwiazanieWlasne {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,42,4,12,34,43,4,55,2,3,44);
        List<Long> longList = Arrays.asList(1L,2L,42L,4L,12L,34L,43L,4L,55L,2L,3L,44L);
        List<Double> doubleList = Arrays.asList(1.0,2.0,42.0,4.0,12.0,34.0,43.0,4.0,55.0,2.0,3.0,44.0);
        List<Float> floatList = Arrays.asList(1.0f,2.0f,42.0f,4.0f,12.0f,34.0f,43.0f,4.0f,55.0f,2.0f,3.0f,44.0f);

//        wyswietla optionala
        System.out.println(max(1,44,intList));
//        jak optional nie bedzie miał wartości to zwróci null
        System.out.println(max(1L,44L,longList).orElse(null));
        System.out.println(max(1.0,44.0,doubleList).orElse(null));
        System.out.println(max(1.f,44.0f,floatList).orElse(null));


    }
// przyjmujemy typ taki który rozszeza Number
    public static <T extends Number> Optional<T> max(T start, T end, List<T> list){
//        wartość początkowa null bo to jest klassa
        T max = null;
//        iterowanie po elementach listy
        for (T element : list) {
//            jezeli element miesci się pomiędzy max i min.
//            bez doubleValue() nie moglibyśmy porównać dwóch liczb
            if(element.doubleValue() >= start.doubleValue() && element.doubleValue() < end.doubleValue()){
//                jeżeli max jest równy null albo jest większy niż maks to element zostaje max
                if(max == null || element.doubleValue() > max.doubleValue()){
//                    null możemy sprawdzić jeszcze w ten sposób
//                    if(Objects.isNull(max) || element.doubleValue() > max.doubleValue())

                    max = element;
                }
            }
        }
        return Optional.ofNullable(max);
    }
}
