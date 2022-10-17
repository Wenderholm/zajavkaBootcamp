package com.company.JavaAPI_Optional_stringBuilder.optionalExample;

import java.util.Optional;

public class SteeringWheel {
    private final double diameter;

    public SteeringWheel(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        System.out.println("Getting diameter");
        return diameter;
    }

    public Optional<Double> getDiameterOpt(){
        return Optional.of(diameter);
    }

    @Override
    public String toString() {
        return "SteeringWheel{" +
                "diameter=" + diameter +
                '}';
    }
}
