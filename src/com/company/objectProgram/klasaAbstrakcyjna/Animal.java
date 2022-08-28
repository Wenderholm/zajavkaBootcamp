package com.company.objectProgram.klasaAbstrakcyjna;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void anim(){
        System.out.println("method in Animal");
    }

//    metoda abstrakcyjna
    public abstract void givemeVoice();
}
