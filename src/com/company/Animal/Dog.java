package com.company.Animal;

public class Dog {
    public String name;
    public int legNumbers;

    public Dog(String name, int legNumbers) {
        this.name = name;
        this.legNumbers = legNumbers;
    }

    public static void voice(){
        System.out.println("Dog bark");
    }

}
