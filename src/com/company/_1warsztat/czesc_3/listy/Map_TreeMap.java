package com.company._1warsztat.czesc_3.listy;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Map_TreeMap {
    public static void main(String[] args) {
//        Map<String, String> treeMap = new TreeMap<>();
//
//        treeMap.put("o9", "some hashMap 1");
//        treeMap.put("G5", "some hashMap 2");
//        treeMap.put("A9", "some hashMap 3");
//        treeMap.put("a2", "some hashMap 4");
//        treeMap.put("1A", "some hashMap 5");
//
//
//        System.out.println(treeMap);
//
//        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

//        aby sortowac po nazwie to uzywamy comparator
//        UWAGA jezeli mamy comparator uzyty jako lambda oraz comparTo w metodzie to zostanie wywolany comparator z lamda
//        Map<Dog, String> treeMap = new TreeMap<>(((o1, o2) -> o1.name.compareTo(o2.name)));

//        aby sortowac mozemy tez uzyc Comparable w klasie Dog
//        HashMap wykorzystuje metody hashcode i equal
//        treeMap wykorzystuje metody compare to z klasy
        Map<Dog, String> treeMap = new TreeMap<>();
        treeMap.put(new Dog("o9"), "some hashMap 1");
        treeMap.put(new Dog("G5"), "some hashMap 2");
        treeMap.put(new Dog("o9"), "some hashMap 3");
        treeMap.put(new Dog("a2"), "some hashMap 4");
        treeMap.put(new Dog("o9"), "some hashMap 5");

        System.out.println(treeMap);

    }


    private static class Dog implements Comparable<Dog> {
        private String name;

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
            System.out.println("Equal calling ....");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return Objects.equals(name, dog.name);
        }

        @Override
        public int hashCode() {
            int hashValue = Objects.hash(name);
            System.out.println("Hashcode calling .... " + hashValue);
            return hashValue;
        }

        @Override
        public int compareTo(Dog o) {
            System.out.println("compareTo calling ....");
            return this.name.compareTo(o.name);
        }
    }
}

