package com.company.staticWord.statyczneBlokiInicjalizacyjne;

public class Bird {

    static{
        System.out.println("Static z Bird");
    }

    {
        System.out.println("non-static z Bird");
    }

    public Bird() {
        System.out.println("konstruktor z bird");
    }
}
