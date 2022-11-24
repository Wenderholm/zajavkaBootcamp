package com.company._1warsztat.czesc_3.listy;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Map_LinkedHashMap {
    public static void main(String[] args) {
//        uzywane wtedy gdy chcemy aby mapa zapamietywała w jakiej kolejnosci byly dodawane obiekty
        Map<Dog, Integer> someMap = new LinkedHashMap<>();

        someMap.put(new Dog("A"), 123);
        someMap.put(new Dog("E"), 123);
        someMap.put(new Dog("C"), 123);
        someMap.put(new Dog("D"), 123);
        someMap.put(new Dog("B"), 123);

        System.out.println(someMap);

        for (Map.Entry<Dog, Integer> entry : someMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static class Dog{
        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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
