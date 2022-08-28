package com.company.objectProgram.equalMethod;

public class EqualsMethod {
    public static void main(String[] args) {
        equalExample();
    }

    private static void equalExample(){
        Car car1 = new Car("Mercedes", "A-Class", 2010);
        Car car2 = new Car("BMW", "X1", 2009);
        Car car3 = new Car("Volkswagen", "Golf", 2015);
        Car car4 = new Car("Audi", "A4", 2018);
        Car car5 = new Car("Audi", "A4", 2018);

        System.out.println(car4 == car5);
        System.out.println(car4.equals(car5));
    }
}
