package com.company.enumeratory;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Enums {
    public static void main(String[] args) {
        Volkswagen volkswagen = Volkswagen.GOLF;

        System.out.println("odpowiedz " + Volkswagen.PASSAT.ifMissing());
        if(volkswagen.ARTEON.equals(volkswagen)){
            System.out.println("This is arteon");
        }else{
            System.out.println("This is not arteon");
        }

        switch(volkswagen){
            case ARTEON:
            case PASSAT:
                System.out.println("Passat or arteon");
                break;
            case GOLF:
                System.out.println("Golf");
                break;
            case TIGUAN:
            case TUAREG:
                System.out.println("This is a SUV");
                break;
        }

        System.out.println(Volkswagen.PASSAT.getColor());
        System.out.println(Volkswagen.PASSAT.getYearOfProduction());
        System.out.println(Volkswagen.GOLF.getColor());
        volkswagen.GOLF.setColor("black");
        System.out.println(Volkswagen.GOLF.getColor());

        System.out.println(Volkswagen.GOLF);

//        tablica z enumów
        Volkswagen[] values = Volkswagen.values();
        System.out.println(Arrays.toString(values));
        System.out.println("------------------------");

//  wyswietleni wartości z enum
        for (Volkswagen value : values) {
            System.out.println(value);
        }

        System.out.println("------------------------");
        Volkswagen golf = Volkswagen.valueOf("GOLF");
        System.out.println(golf);
//  wypisywanie w liscie samochodow o tym samym kolorze
        String color = "white";
        List<Volkswagen> v1 = Volkswagen.ofColor(color);
        System.out.println(v1);
// metoda ORDINAR() sprawdza na którym miejscu znajduje się element w enum
// metoda name() wypisuje nazve z enuma
        int ordinal = golf.ordinal();
        System.out.println("ordinar for " + Volkswagen.GOLF.name()+ " is " + ordinal);
// wykorzystanie dopisanej metody abstrakcyjnej w polu enuma
        System.out.print("Other car: ");
        System.out.println(golf.ifMissing());
    }

}
