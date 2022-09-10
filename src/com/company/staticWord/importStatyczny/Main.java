package com.company.staticWord.importStatyczny;

import static com.company.staticWord.importStatyczny.Dog.*;

public class Main {
    public static void main(String[] args) {
//        Dog dog = new Dog();
        System.out.println(NAME);
        System.out.println(SURNAME);
        System.out.println(AGE);

        bark();
        goForAWalk();
    }
}
