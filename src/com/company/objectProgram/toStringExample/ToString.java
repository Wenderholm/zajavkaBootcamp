package com.company.objectProgram.toStringExample;


public class ToString {

    public static void main(String[] args) {
//        Car car1 = new Car("Mercedes", "A-Class", 2010);
//        Car car2 = new Car("BMW", "X1", 2009);
//        Car car3 = new Car("Volkswagen", "Golf", 2015);
//
//
//        System.out.println(car1);

        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


}
