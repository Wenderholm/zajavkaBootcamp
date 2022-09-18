package com.company.staticWord;

import static com.company.staticWord.Test.NOWY2;

public class Main {

    public static void main(String[] args) {


        Dog dog1 = new Dog("Burek"  );
//        mozna pisac tak
//        System.out.println(dog1.howManyDog);

//      powinno się pisać tak
//        w każdym przypadku dog1, dog2, dog3 wskazywany jest ta sam zmienna statyczna
        System.out.println(Dog.howManyDog);
        Dog dog2 = new Dog("Romek");
        System.out.println(Dog.howManyDog);
        Dog dog3 = new Dog("Azor");
        System.out.println(Dog.howManyDog);

        dog1.nonStaticExample();

//        mozliwe jest wywołanie metody bez instancji do klasy
        someStaticMethod();

//        wywołanie bez static wyglądło by tak:
    //        Main main = new Main();
    //        main.someStaticMethod();


        System.out.println("number of legs " + Dog.NUMBER_OF_LEGS);

    }

    public static void someStaticMethod(){
        System.out.println("proba static");
    }
}
