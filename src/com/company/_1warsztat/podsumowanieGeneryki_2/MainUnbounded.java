package com.company._1warsztat.podsumowanieGeneryki_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainUnbounded {
    public static void main(String[] args) {
       List<Dog> dogList = Arrays.asList(new Dog(), new Dog());
       List<String> stringList = Arrays.asList("super", "ekstra");

       print(dogList);
       print(stringList);


    }

//    używająć znaczka unbounded musimy uważać na to że tera
//    na tych elementach możemy robić rzeczy które jej nie rozbudowują ponieważ nie wiemy co to za typ
//    jeżeli chcielibyśmy coś dodać
//     możemy natomiast używać inne metody ktore są do wyświetlania np. size() albo remove() ponieważ do tych metod
//    nie muszę wiedzieć co to za typ a mogę wyświetlić jego rozmiar bądz usunąć jakiś element
    private static void print(List<?> list) {
        System.out.println(list);
    }

    static class Dog extends Animal {

    }

    static class Animal {

    }
}
