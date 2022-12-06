package com.company._2warsztat.interfejsy_funkcyjne.zadanie_2;

@FunctionalInterface
public interface ExampleInterface<O> {
    Integer myInterface(String strArg, Integer intArg, O someObject);
}
