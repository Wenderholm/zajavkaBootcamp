package com.company.staticWord;

public class Dog extends Animal {

    public static final int NUMBER_OF_LEGS = 4;

    public static int howManyDog = 0;

    private String name;

    public Dog(String name) {
        this.name = name;
        howManyDog++;
    }



    public static void staticExample(){
        System.out.println("Static example");
//        NIE MOŻNA DO METOD STATYCZNYCH WRZUCAĆ METOD NIE STATYCZNYCH PONIEWAŻ:
//        METODA STATYCZNA POWSTAJE podczas łądowania się do pamięci,kiedy jest wczytywany obiekt
//        METODA NIESTATYCZNA powstaje dopiero po powstaniu obiektu

//        BŁĄD ukazuje sie ponieważ w chwili wczytywania metody statycznej nie wiadomo czym jest
//        metoda nonStaticExampe()
//        nonStaticExample();
    }

    public void nonStaticExample(){
        System.out.println("NonStatic example");
        staticExample();
    }

//  STATIC nie rozumie mechanizmu dziedziczenia ponieważ dziedziczenie zaistnieje wtedy kiedy zostanie stworzona klasa
//    czyli zostanie stworzona instancja klasy DOG
//    public static void exampleBehavior() {
//        super.exampleBehavior();
//    }

    

}
