package com.company.kolekcje.immutableTraining;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>();
        nameList.add("czarek");
        nameList.add("marek");
        nameList.add("darek");
        nameList.add("arek");


        CatImmutable catImmutable = new CatImmutable(nameList);
        System.out.println(catImmutable);

        List<String> friendsNames = catImmutable.getFriendsNames();
//        tu działa I blokada z gettera
        friendsNames.add("jarek");
        System.out.println(catImmutable);

//        tu działa II blokada z konstruktora
        nameList.add("ogorek");
        System.out.println(catImmutable);
        System.out.println(nameList);
        System.out.println(friendsNames);
    }
}
