package com.company.objectProgram.zadaniaProgramObiektowe.zadanie3;

public class Square {
    private int bok;

    public Square() {
        this.bok = 5;
    }

    public Square(int bok) {
        this.bok = bok;
    }

    public int getBok() {
        return bok;
    }

    public void setBok(int bok) {
        this.bok = bok;
    }

    public int circuit(){
        return  bok * 4;
    }

    public int square(){
        return bok * bok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return bok == square.bok;
    }

    @Override
    public int hashCode() {
        return bok;
    }

    @Override
    public String toString() {
        return "Square{" +
                "bok=" + bok +
                '}';
    }
}
