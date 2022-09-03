package com.company.objectProgram.finalExercise.immutable;

import com.company.objectProgram.finalExercise.immutable.Dog;

public class Main {
    public static void main(String[] args) {
        Dog fafik = new Dog("fafik");
        System.out.println(fafik.getName());
//        próba zmiany nazwy psa
        fafik.changeName("roman");
//        próba wyswietlenia pokazuje ze imie sie nie zmienia ponieważ nie możemy zmienic clasyimmutable
        System.out.println(fafik.getName());


//        nazwe zminimy tylko jak przypiszemy wywolanie metody zmiany nazwy i przypiszemy do nowegoobiektu
        Dog andrzej = fafik.changeName("andrzej");
        System.out.println(andrzej.getName());
    }
}
