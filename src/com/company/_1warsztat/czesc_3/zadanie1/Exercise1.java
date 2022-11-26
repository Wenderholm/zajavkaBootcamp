package com.company._1warsztat.czesc_3.zadanie1;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Exercise1 {
    public static void main(String[] args) {
        List<Car> myList = List.of(
                new Car("BMW","X5", 2002),
                new Car("Audi","A6", 2000),
                new Car("Toyota","Avensis", 2013),
                new Car("BMW","X1", 1998),
                new Car("Toyota","Corolla", 2021),
                new Car("BMW","E46", 1992)
        );

        List<Car> hisList = List.of(
                new Car("Hyundai","i40", 2005),
                new Car("Audi","A3", 2007),
                new Car("Toyota","Avensis", 2013),
                new Car("Toyota","Corolla", 2021),
                new Car("Tata","NewBramd", 2022),
                new Car("AlfaRomeo","147", 2003)
        );

        Set<Car> ourCars = new TreeSet<>();
        ourCars.addAll(myList);
        ourCars.addAll(hisList);

        for (Car car : ourCars) {
            System.out.println(car);
        }
    }

    static class Car implements Comparable<Car>{
        private String brand;
        private String model;
        private Integer year;

        public Car(String brand, String model, Integer year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Integer getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Car: " +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    '}';
        }

        @Override
        public int compareTo(Car o) {
//            Comparator<Car> comparingYear = Comparator.comparing(e -> e.year);
//            Comparator<Car> comparingModel = comparingYear.thenComparing(e -> e.model);
//            Comparator<Car> comparingBrand = comparingModel.thenComparing(e -> e.brand);
//            return comparingBrand.compare(this,car);

//            powyzsze za pomoca shortcut CTRL+ALT+N wyglada tak
//            return Comparator.
//                    <Car, Integer>comparing(e1 -> e1.year).
//                    thenComparing(e1 -> e1.model).
//                    thenComparing(e -> e.brand).
//                    compare(this,car);

            return Comparator.comparingInt((Car car) -> car.year)
                    .thenComparing((Car car) -> car.model)
                    .thenComparing((Car car) -> car.brand)
                    .compare(this,o);
        }
    }
}
