package com.company.objectProgram.immutable;

public final class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public Dog changeName(String name) {
        return new Dog(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
