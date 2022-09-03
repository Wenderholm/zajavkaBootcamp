package com.company.objectProgram.agregacja;

public class Main {

    public static void main(String[] args) {
        Marks m1 = new Marks(65,70,62);

        Student s1 = new Student("S001", "Ann", m1);

        s1.display();

//        Obiekt ucznia, którym jest s1, może używać obiektu znaczników, który jest m1. Dlatego Uczeń i Oceny mają relację „ma”.
//        Obiekt Marks może istnieć bez obiektu Student. Dlatego jest to agregacja
    }

}
