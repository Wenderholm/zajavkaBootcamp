package com.company.optionalExample;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class OptionalCarExamples {
    public static void main(String[] args) {
//        Optional<Car> car = Optional.of(new Car());
        Optional<Car> car = Optional.empty();
//        System.out.println(car);


        Double cars = car
                .map(c -> c.getSteeringWheel())
                .map(sw -> sw.getDiameter())
                .orElse(0.0);
        System.out.println(cars);

        
//        OPTIONAL W OPTIONAL 
//        Optional<Optional<SteeringWheel>> steeringWheel = car.map(c -> c.getSteeringWheelOpt());

//        MOZEMY SIE POZBYC OPTIONAL W OPTIONAL
        Double car2 = car
                .flatMap(c -> c.getSteeringWheelOpt())
                .flatMap(sw -> sw.getDiameterOpt())
                .orElse(0.0);
        System.out.println();
        System.out.println("FILTER IN OPTIONAL");
        Optional<Double> diameter = car
                .map(c -> c.getSteeringWheel())
                .map(sw -> sw.getDiameter())
                .filter(d -> {
                    System.out.println("Filtering d >= 0.5");
                    return d >= 0.5;
                })
                .filter(d -> {
                    System.out.println("Filtering d < 0.7");
                    return d < 0.7;
                });
        System.out.println(diameter);


        System.out.println();
        System.out.println("CHAINING OPTIONAL");
        Optional<Car> or = car
                .or(() -> {
                    System.out.println("first");
                    return Optional.empty();
                })
                .or(() -> {
                    System.out.println("second");
                    return Optional.of(new Car());
                });
    }
}
