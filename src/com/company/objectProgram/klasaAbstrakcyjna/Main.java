package com.company.objectProgram.klasaAbstrakcyjna;

public class Main {
    public static void main(String[] args) {
        Cat burek = new Cat("burek");
        burek.givemeVoice();

        System.out.println();
        Labrador czarek = new Labrador("czarek");
        czarek.givemeVoice();
        czarek.anim();
    }
}
