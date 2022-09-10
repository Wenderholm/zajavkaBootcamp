package com.company.objectProgram.methodChaining.zKlasaNiemutowalna;

public class Leg {
    private int number;

    public Leg(int number) {
        this.number = number;
    }

//    konstruktor kopiujacy - tworzy kopię klasy
    public Leg(Leg leg) {
        this.number = leg.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "number=" + number +
                '}';
    }
}
