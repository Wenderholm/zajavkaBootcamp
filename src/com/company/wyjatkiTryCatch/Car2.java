package com.company.wyjatkiTryCatch;

public class Car2 {
    public void drive(){
        System.out.println("one");
    }
    public static void driveAgain(){
        System.out.println("tow");
    }

    public static void main(String[] args) {
        Car2 car = new Car2();
        car.drive();
        Car2 anotherCar = null;
        anotherCar.driveAgain();
        anotherCar.drive();
    }
}
