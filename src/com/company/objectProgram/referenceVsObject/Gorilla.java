package com.company.objectProgram.referenceVsObject;

public class Gorilla extends Monkey{

    public Gorilla(String age, String name) {
        super(age, name);
    }

    public boolean hasHair(){
        return true;
    }

    public String gorillaMethod(){
        return "method in gorilla";
    }
}
