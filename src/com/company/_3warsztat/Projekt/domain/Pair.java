package com.company._3warsztat.Projekt.domain;

public class Pair<U,T> {
    private U p1;
    private T p2;

    public Pair(U p1, T p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public U getP1() {
        return p1;
    }

    public T getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
