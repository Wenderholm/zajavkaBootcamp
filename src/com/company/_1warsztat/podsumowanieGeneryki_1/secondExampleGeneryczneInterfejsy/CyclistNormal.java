package com.company._1warsztat.podsumowanieGeneryki_1.secondExampleGeneryczneInterfejsy;

public class CyclistNormal implements Bikeable<String>{
    @Override
    public void ride(String bike) {
        System.out.println("Ride on bike from company " + bike);
    }
    static <T> void method(T t){
        System.out.println(t);
    }
}
