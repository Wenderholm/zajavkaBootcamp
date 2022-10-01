package com.company.kolekcje.zadania.zadanie6;

public class Square {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public Square() {
        this.side = 5;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int parimeter() {
        return side * 4;
    }

    public int area(){
        return side * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return getSide() == square.getSide();
    }

    @Override
    public int hashCode() {
        return getSide();
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
