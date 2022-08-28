package com.company.objectProgram.klasaAbstrakcyjna;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

@Override
    public void givemeVoice() {
        System.out.println("kotek robi - meow meow");
    }
}
