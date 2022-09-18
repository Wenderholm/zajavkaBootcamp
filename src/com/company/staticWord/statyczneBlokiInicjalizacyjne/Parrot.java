package com.company.staticWord.statyczneBlokiInicjalizacyjne;

public class Parrot extends Bird {

    public static String name;

    private String surname;


    static{
        System.out.println("zmienna inicjalizacyjna static z Parrot");
        name = "imie statyczne z parrot";
    }

    {
        System.out.println("zmienna inicjalizacyjna z Parrot");
        name = "imię niestatyczne z parrot";
        surname = "nazwisko niestatyczne z parrot";
    }

    public Parrot() {
        super();
        System.out.println("konstruktor z Parrot");
    }

}
