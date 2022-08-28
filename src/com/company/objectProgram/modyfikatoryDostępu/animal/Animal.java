package com.company.objectProgram.modyfikatoryDostępu.animal;

public class Animal {
    public String color;

    public Animal(String color) {
        this.color = color;
    }

    private String sound(){
        return "animal sound";
    }
}

