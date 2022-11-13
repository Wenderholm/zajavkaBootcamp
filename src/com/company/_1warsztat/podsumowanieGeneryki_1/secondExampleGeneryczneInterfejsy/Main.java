package com.company._1warsztat.podsumowanieGeneryki_1.secondExampleGeneryczneInterfejsy;

public class Main {
    public static void main(String[] args) {
        Bikeable cyclist1 = new CyclistNormal();
        cyclist1.ride("giant");
        CyclistNormal cyclist11 = new CyclistNormal();
        cyclist11.ride("Romet");

        Bikeable<String> cyclist2 = new CyclistWithGeneric<>();
        cyclist2.ride("Tomas");
        CyclistWithGeneric<String> cyclist22 = new CyclistWithGeneric<>();
        cyclist22.ride("Alberton");


        CyclistNormal.method("bike");
        CyclistNormal.method(2);


    }
}
