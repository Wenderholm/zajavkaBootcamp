package com.company.kolekcje.zadania.zadanie6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Square> squares = List.of(
                new Square(2),
                new Square(3),
                new Square(4),
                new Square(5),
                new Square(6),
                new Square(7),
                new Square(),
                new Square()
        );

        Set<Square> squaresSet = new HashSet<>(squares);
        System.out.println(squares);
        System.out.println(squaresSet);
    }
}
