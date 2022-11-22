package com.company._1warsztat.czesc_1.podsumowanieGeneryki_1.secondExampleGeneryczneInterfejsy;

public class CyclistNormal implements Bikeable<String>{
    @Override
    public void ride(String bike) {
        System.out.println("Ride on bike from company " + bike);
    }
    static <T> void method(T t){
        System.out.println(t);
    }
}
