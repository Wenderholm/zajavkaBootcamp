package com.company._1warsztat.czesc_1.podsumowanieGeneryki_2;

import java.util.List;

public class MainLowerUnbounded {
    public static void main(String[] args) {
//        List<Pigeon> pigeonList = Arrays.asList(new Pigeon(), new Pigeon());

//        <? super Pigeon> - oznacza to że możemy użyć tu typu referencji Pigeon, Animal, Object
//        to co jest nad Pigeon nie można uzyć WalkingPigeon działa to odwrotnie d <? extend Pigeon>
        List<Pigeon> pigeonList = null;
//        List<WalkingPigeon> pigeonList = null; <- NIE DZIAŁA
        List<? super Pigeon> aList = pigeonList;

//        do list w tym przypadku mozemy dodawać teraz coś co mamy przynajmniej Pigeon
//        albo jego potomków czyli WalkinPigeon
//        aList.add(new Animal()); <- to nie działa
        aList.add(new Pigeon());
        aList.add(new WalkingPigeon());

//        print(pigeonList);
//        print(aList);
    }

    private static void print(List<? extends Animal> list) {
        System.out.println(list);
    }

    private static void printSize(List<? extends Animal> list) {
        System.out.println(list.size());
    }

    static class WalkingPigeon extends Pigeon {

    }

    static class Pigeon extends Animal {

    }

    static class Animal {

    }
}
