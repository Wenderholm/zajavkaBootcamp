package com.company.objectProgram.is_a_has_a_kompozycja.kompozycjaPrzyklad2;

public class Main {
    public static void main(String[] args) {
        Ksiazka lektura = new Ksiazka(new Osoba("Sienkiewicz", "Henryk"),"potop", 32.6);

        System.out.println(lektura);
    }


}
