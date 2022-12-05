package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.Optional;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

//        Car jest dana wejsciową do interfejsu a String będzie na wyjsciu
//        Function<Car, String> carStringFunction = Car::toString;
//
//        Optional<String> carOpt = Optional.of(new Car())
//                .map(carStringFunction);

//        Function<Car, String> functionalImpl = c -> {
//            System.out.println(c);
//            return "someString";
//        };

//        Function<Car, String> functionalImpl = c -> exstractMethod(c);

        Function<Car, String> functionalImpl = FunctionExample::exstractMethod;

        String apply = functionalImpl.apply(new Car());
        System.out.println(apply);

    }

    private static String exstractMethod(Car c) {
        System.out.println(c);
        return "someString";
    }


    static class Car{
        @Override
        public String toString() {
            return "Car{}";
        }
    }
}
