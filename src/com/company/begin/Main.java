package com.company.begin;

import com.company.Animal.Dog;

public class Main {

    public static void main(String[] args) {
        String code = " hello cos tam ";
        System.out.println(code);

        Dog dog1 = new Dog("Burek", 12);
        System.out.println("name " + dog1.name + " number of leg " + dog1.legNumbers);
        Dog.voice();
        Dog.voice();
    }
}
