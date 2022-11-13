package com.company._1warsztat.podsumowanieGeneryki_2;

import java.util.Arrays;
import java.util.List;

public class MainUpperUnbounded {
    public static void main(String[] args) {
        List<Dog> dogList = Arrays.asList(new Dog(), new Dog());
        List<Pigeon> pigeonList = Arrays.asList(new Pigeon(), new Pigeon());

//        List<Animal> aList = pigeonList; <- nie możemy przypisać listy pigeonów do listy zwierząt

//  List<? extends Animal> - TU JAKO TYP REFERENCJI - oznacza to że mamy referencje z typem generycznym który generalizuje
//  nam że możemy wrzucić tu coś co rozszerza Animal
        List<? extends Animal> aList = pigeonList;

//        aList.add(new Pigeon()); <-  nie możemy tu dodać ponieważ nie wiemy co to będzie za typ
//        (NIE WIEMY CO BĘDZIEMY DODAWAĆ)
        List<Animal> animalList = Arrays.asList(new Animal(), new Animal());
//        List<String> stringList = Arrays.asList("super", "ekstra");


        print(dogList);
        print(pigeonList);
        print(animalList);

        printSize(dogList);
        printSize(pigeonList);
//        print(stringList);


    }
// List<? extends Animal> list - TU JAKO PARAMETR METODY - oznacza to że metoda print przyjmie generyki tylko te które
// dziedziczą po klasie Animal. widać że string tu nie działa.
    private static void print(List<? extends Animal> list) {
        System.out.println(list);
    }
// <? extends Animal> - to co tu mamy najczęściej uzywane jes do tego żeby tworzyć logigę dla różnych typów
    private static void printSize(List<? extends Animal> list) {
        System.out.println(list.size());
    }

    static class Dog extends Animal {

    }

    static class Pigeon extends Animal {

    }

    static class Animal {

    }

}
