package com.company.objectProgram.polimorfizm;

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

        Car car2 = new Mitsubishi(12, "Mitsubishi NEW");
        System.out.println(car2.accelerate());
        System.out.println(car2.brake());
        System.out.println(car2.startEngine());
//        tu horn nie zadziała poniewaz referencja car jest typu Car a w klasie Car nie ma metody horn()
//        System.out.println(car2.horn());

        Ford ford = new Ford(7,"Civic");
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());
        System.out.println(ford.startEngine());



    }
}
