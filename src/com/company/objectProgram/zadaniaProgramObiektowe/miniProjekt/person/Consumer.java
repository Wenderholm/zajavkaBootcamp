package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;

public class Consumer extends Person{

    private final String exceptation;


    public Consumer(String name, String surname, String exceptation) {
        super(name, surname);
        this.exceptation = exceptation;
    }

    public String getExceptation() {
        return exceptation;
    }

    @Override
    public void consume(Food food) {
        System.out.println("Consumer consuming " + food);
    }
}
