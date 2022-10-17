package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie4;

public class User {
    private final int id;
    private final String name;
    private final String surname;


    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User() {
        this.id = 0;
        this.name = "default";
        this.surname = "default";

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
}
