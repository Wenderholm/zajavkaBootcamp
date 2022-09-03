package com.company.objectProgram.is_a_has_a_kompozycja.kompozycjaPrzyklad2;

public class Osoba {
    private String nazwisko;
    private String imie;

    public Osoba(String nazwisko, String imie) {
        this.nazwisko = nazwisko;
        this.imie = imie;
    }

    public String podajNazwisko(){
        return nazwisko;
    }

    public String podajImie(){
        return imie;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                '}';
    }
}
