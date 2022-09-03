package com.company.objectProgram.interfejsyPrzyklady.examExample;

public interface CanSwim {
    default boolean canSwim(){
        return false;
    }
}
