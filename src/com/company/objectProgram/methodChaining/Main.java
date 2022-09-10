package com.company.objectProgram.methodChaining;

import com.company.objectProgram.methodChaining.zKlasaMutowalna.Kangaroo;
import com.company.objectProgram.methodChaining.zKlasaNiemutowalna.Dog;
import com.company.objectProgram.methodChaining.zKlasaNiemutowalna.Leg;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String text = "Zdanie kontrolne";
        String substract = text.toUpperCase(Locale.ROOT).substring(2, 5);
        int length = text.toUpperCase(Locale.ROOT).substring(2, 5).length();

        System.out.println(substract );
        System.out.println(length);


        Kangaroo kangaroo = new Kangaroo("Kinga", 10);
        System.out.println(kangaroo);
        kangaroo.withName("Daria").withAge(3);
        System.out.println(kangaroo);

        System.out.println("------------------------------------");

        Leg leg = new Leg(4);
        Dog dog = new Dog("Janek", 10,leg);
        System.out.println(dog);
//        Dog daria = dog.withName("Daria").withAge(3);
//        System.out.println(daria);
        Leg leg1 = dog.getLeg();
        leg1.setNumber(6);
        leg.setNumber(12);
        System.out.println(dog);

    }
}
