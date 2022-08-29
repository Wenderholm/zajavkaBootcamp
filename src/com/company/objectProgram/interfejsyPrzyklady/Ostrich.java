package com.company.objectProgram.interfejsyPrzyklady;

public class Ostrich implements Animal, Swimable{
    @Override
    public void run() {
        System.out.println("I'm running - ostrich");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming - ostrich");
    }
}
