package com.company._1warsztat.czesc_3.listy;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Map_HashMap_czasDzialania {

    public static void main(String[] args) {
        Map<Dog, String> dogString = new HashMap<>();

        LocalTime before = LocalTime.now();
        for (int i = 0; i < 100_000; i++) {
            dogString.put(new Dog("Dog " + i/12), "some value");
        }
//        1. dzialanie z dobra metoda hashcode wynik 124
//        2. dzialanie ze zla metoda hascode gdzie hashcode zwraca 1 wynik 8973
        System.out.println("Loop took: " + Duration.between(before, LocalTime.now()).toMillis());

    }

    private static class Dog{
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog: " + name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return Objects.equals(name, dog.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
//            return 1;
        }
    }


}
