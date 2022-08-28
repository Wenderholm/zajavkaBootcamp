package com.company.objectProgram.modyfikatoryDostępu.animal;

public class Cat extends Animal {
    private String name;
    public String hair;
    protected int age;
    int noLegs;

    public Cat(String color, String name) {
        super(color);
        this.name = name;
    }

    public void method(){
        System.out.println(color);
    }
}
