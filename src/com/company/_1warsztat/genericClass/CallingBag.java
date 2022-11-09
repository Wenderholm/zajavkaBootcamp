package com.company._1warsztat.genericClass;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CallingBag {

    public static void main(String[] args) {
        // okreslamy ze klasa bag będzie przyjmowała Stringi

//        Bag<String> bag = new Bag<>();
//        System.out.println(bag);
//        bag.pack("nowy string");
//        System.out.println(bag);
//        String empty = bag.empty();
//        System.out.println(bag);
//
//        Bag<Car> carBag = new Bag<>();
//        System.out.println(carBag);
//        carBag.pack(new Car());
//        System.out.println(carBag);
//        Car emptyCar = carBag.empty();
//        System.out.println(carBag);

//        jeżeli mamy generyk typu Car w ty przypadku mozemy dodawć klasy które po niej dziedziczą
//        List<Car> cars = new ArrayList<>();
//        cars.add(new SUV());

        callFilteringBag();

    }
// stworzylismy metodę która będzie sprwadzała czy to co chcemy dodać do naszego worka to jest to co chcemy
    private static void callFilteringBag() {
        Car car = new Car("red2", 2020);
        FilteringBag<Car, Predicate<Car>, Predicate<Car>> filteringBag = new FilteringBag<>(
                c -> c.getColor().equals("red"),
                c -> c.getYear().equals(2020)
        );
        filteringBag.pack(car);
    }

    static class Car{

        private String color;
        private Integer year;

        public Car(String color, Integer year) {
            this.color = color;
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public Integer getYear() {
            return year;
        }
    }

//    static class SUV extends Car {
//
//    }

}
