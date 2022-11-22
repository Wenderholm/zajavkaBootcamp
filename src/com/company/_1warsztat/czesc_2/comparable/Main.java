package com.company._1warsztat.czesc_2.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1,"Roman"));
        dogs.add(new Dog(5,"Szymek"));
        dogs.add(new Dog(3,"Roman"));
        dogs.add(new Dog(6,"Adelin"));
        dogs.add(new Dog(2,"Roman"));
        dogs.add(new Dog(4,"Robert"));

//        Collection.sort() moze byc uzyte poniewaz klasa Dog implementuje Comparable
        System.out.println(dogs);
        Collections.sort(dogs);
        System.out.println(dogs);


    }
}
