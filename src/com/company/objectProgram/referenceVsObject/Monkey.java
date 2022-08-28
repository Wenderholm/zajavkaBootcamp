package com.company.objectProgram.referenceVsObject;

public class Monkey {
    protected String age;
    protected String name;

    public Monkey(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public String monkeyMethod(){
        return "method in monkey";
    }
}
