package com.company._1warsztat.podsumowanieGeneryki_1.secondExampleGeneryczneInterfejsy;

public class CyclistWithGeneric<T> implements Bikeable<T> {
    @Override
    public void ride(T bike) {
        System.out.println("Ride on bike from company " + bike);
    }
}
