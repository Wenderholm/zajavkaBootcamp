package com.company.objectProgram.is_a_has_a_kompozycja.kompozycjaPrzyklad2;

public class Ksiazka {
    private Osoba autor;
    private String tytul;
    double cena;

    public Ksiazka(Osoba autor, String tytul, double cena) {
        this.autor = autor;
        this.tytul = tytul;
        this.cena = cena;
    }

    public Osoba podajAutor() {
        return autor;
    }

    public String podajTytul() {
        return tytul;
    }

    public double podajCena() {
        return cena;
    }


    @Override
    public String toString() {
        return "Ksiazka{" +
                "autor=" + autor +
                ", tytul='" + tytul + '\'' +
                ", cena=" + cena +
                '}';
    }
}
