package com.company.objectProgram.interfejsyPrzyklady.examExample;

public class Dog implements CanRunFast {
    @Override
    public boolean isFast() {
        return false;
    }

    public static void main(String[] args) {
        CanRunFast animal = new Dog();
        System.out.println(animal.isFast());
    }
}
