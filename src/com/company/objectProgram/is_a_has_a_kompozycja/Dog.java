package com.company.objectProgram.is_a_has_a_kompozycja;

public class Dog extends Animal{
    private Leg leg = new Leg();
}
// ZALEŻNOŚCI IS_A oraz HAS_A(kompozycja)
// Dog is a Animal czyli piej jest zwierzęciem
// Dog has a Leg czyli pies ma nogi