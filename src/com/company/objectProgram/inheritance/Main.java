package com.company.objectProgram.inheritance;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.company);
//        horn zostanie wydrukowane te które jest w car ponieważ jest nadpisana metoda z vehicle
        System.out.println(car.horn());
    }
}
