package com.company._1warsztat.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
//        tej listy nie mozemy modyfikowac
        List<String> strings = List.of("a","b","c");

        List<String> strings1 = Arrays.asList("a","A","1","aA","Aa","A1","a1");
        System.out.println(strings1);

//   naturalOrder jest to naturalny porzadek sortowania
//        Comparator<String> comparator = Comparator.naturalOrder();

//      sortowanie odwrotnie.(musimy podać co chcemy sortować)
        Comparator<String> comparator = Comparator.<String>naturalOrder().reversed();
        strings1.sort(comparator);
        System.out.println(strings1);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1,"Roman"));
        cats.add(new Cat(6,"Zbyszek"));
        cats.add(new Cat(3,"Rafał"));
        cats.add(new Cat(2,"Stefan"));
        cats.add(new Cat(5,"Roman"));
        cats.add(new Cat(4,"Roman"));
        System.out.println(cats);


//        SORTOWANIE PO JEDNEJ WARTOŚCI TU PO ID
//        Comparator<Cat> myFirstComparator = new Comparator<>() {
//            @Override
//            public  int compare(Cat o1, Cat o2) {
//                rosnąco
//                return o1.getId() - o2.getId();
//                malejąco
//                return o2.getId() - o1.getId();
//            }
//        };

//      SORTOWANIE PO DWÓCH WARTOŚCIACH - dokładanie kolejnych Comparatorów
//        Comparator<Cat> myFirstComparator = new Comparator<Cat>() {
//            @Override
//            public  int compare(Cat o1, Cat o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        }.thenComparing(new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
//                return o1.getId() - o2.getId();
//            }
//        });


//      POWYŻSZY ZAPIS NAPISANY W INNY SPOSÓB
        Comparator<Cat> myFirstComparator = new Comparator<Cat>() {
            @Override
            public  int compare(Cat o1, Cat o2) {
//                porownanie po nazwie
                int result = o1.getName().compareTo(o2.getName());
//                jezeli resultat jest różny od zera czyli kiedy imiona sa rozne
//                to zwraca nam sortowanie po nazwie
                if(result != 0){
                    return result;
                }
//                jezeli nazwy sa te same czyli rezultat rowny 0 porownujemy po id
                return o1.getId() - o2.getId();
            }
        };

        //        normalne sortowanie
        cats.sort(myFirstComparator);
//        odwrotne sortownie
//        cats.sort(myFirstComparator.reversed());
        System.out.println(cats);


//    POROWNANIE Z UZYCIEM LAMBDY
//        Comparator<Cat> myNextComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Cat> myNextComparator;
        myNextComparator = Comparator.<Cat, String>comparing(cat1 -> cat1.getName())
                .thenComparing(Comparator.comparingInt(cat -> cat.getId()));

        cats.sort(myNextComparator);
        System.out.println(cats);


    }
}
