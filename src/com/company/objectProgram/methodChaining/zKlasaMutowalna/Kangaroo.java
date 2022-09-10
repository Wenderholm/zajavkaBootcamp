package com.company.objectProgram.methodChaining.zKlasaMutowalna;

public class Kangaroo {
    private String name;
    private int age;

    public Kangaroo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Kangaroo withName(String name) {
        this.name = name;
        return this;
    }

    public Kangaroo withAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Kangaroo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
