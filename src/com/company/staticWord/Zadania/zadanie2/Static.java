package com.company.staticWord.Zadania.zadanie2;

public class Static {

    public static int counter;

    static {
        System.out.println("Creating static class");
    }

    private final String name;

    public Static(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }
}
