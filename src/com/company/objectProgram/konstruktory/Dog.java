package com.company.objectProgram.konstruktory;

public class Dog extends Animal{
    protected String race;

    public Dog(String race) {
        System.out.println("Dog with race created");
        this.race = race;
    }

    public Dog() {
        System.out.println("Dog created");
    }
}
