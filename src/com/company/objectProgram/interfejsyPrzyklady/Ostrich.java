package com.company.objectProgram.interfejsyPrzyklady;

public class Ostrich implements Animal, Flyable{
    @Override
    public void run() {
        System.out.println("I'm running - ostrich");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying - ostrich");
    }

    @Override
    public void swim() {

    }
}
