package com.company.udemyPackage.polymorphism;

class Car{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine=true;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "Car -> startEngine()";
    }
    public String accelerate(){
        return "Car -> accelerate()";
    }
    public String brake(){
        return "Car -> break()";
    }
}

class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    public String horn(){
        return "Mitsubishi - horn()";
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> break()";
    }
}

class Ford extends Car{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> break()";
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(8,"BaseCar");
        System.out.println(car.accelerate());
        System.out.println(car.brake());
        System.out.println(car.startEngine());

        Mitsubishi mitsubishi = new Mitsubishi(10,"Mitsubishi X5");
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.horn());

        Ford ford = new Ford(7,"Civic");
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());
        System.out.println(ford.startEngine());



    }
}
