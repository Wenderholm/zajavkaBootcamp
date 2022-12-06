package com.company._2warsztat.interfejsy_funkcyjne.zadanie_3;

public class Cat implements Comparable<Cat> {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }
}
