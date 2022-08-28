package com.company.objectProgram.modyfikatoryDostępu;

import com.company.objectProgram.modyfikatoryDostępu.animal.Animal;

public class Snake extends Animal {
    private String name;

    public Snake(String color, String name) {
        super(color);
        this.name = name;
    }

    public void someMethod(){
//        System.out.println(sound() + );
    }

}
