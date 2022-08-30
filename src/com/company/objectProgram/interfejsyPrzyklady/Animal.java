package com.company.objectProgram.interfejsyPrzyklady;

public interface Animal extends Swimable, Markeable {

    void run();

    default void live(){
        System.out.println("what are you doing: " + name());
    }

    private String name(){
        return "ROMEK";
    }
}
