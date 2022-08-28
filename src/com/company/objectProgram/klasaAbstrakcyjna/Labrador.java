package com.company.objectProgram.klasaAbstrakcyjna;

public class Labrador extends Dog{
    public Labrador(String name) {
        super(name);
    }

    @Override
    public void givemeVoice() {
        System.out.println("labrador - chau, chau");
    }
}
