package com.company.objectProgram.interfejsyPrzyklady.examExample;

public interface CanRunFast {
    default boolean isFast(){
        return false;
    }
}
