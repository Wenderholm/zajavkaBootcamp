package com.company._1warsztat.czesc_3.listy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Map_HashMap {
    public static void main(String[] args) {
        Map<String, String> someMap = new HashMap<>();
        someMap.put("1", "ABC");
        someMap.put("2", "DEF");
        someMap.put("3", "GHI");
        someMap.put("4", "JKL");
        someMap.put("5", "MNO");

        System.out.println(someMap);

//        for (String s : someMap.keySet()) {
//            System.out.print(s + ", ");
//        }
//
//        System.out.println();
//        for (String value : someMap.values()) {
//            System.out.print(value + ", ");
//        }
//
//        System.out.println();
//        for (Map.Entry<String, String> stringStringEntry : someMap.entrySet()) {
//            System.out.print(stringStringEntry.getKey() + " : " + stringStringEntry.getValue());
//        }

        System.out.println(someMap.get("4"));
        System.out.println(someMap.get("7"));
        System.out.println(someMap.getOrDefault("45","nie ma takiego klucza"));

//        jezeli uzyjemy HashMap bez metody Equals oraz hashcode to zostaną dodane duplikaty ponieważ mapa
//        nie potrafi porównac obiektów
        Map<Dog, String> dogString = new HashMap<>();
//        dogString.put(new Dog("Romek"), "to moj domek");
//        dogString.put(new Dog("Stefan"), "zajavka");
//        dogString.put(new Dog("Zbyszek"), "nowy trend");
//        dogString.put(new Dog("Stefan"), "jakos bedzie");
        System.out.println(dogString);

        Dog romek = new Dog("Romek");
        Dog stefan1 = new Dog("Stefan");
        Dog zbyszek = new Dog("Zbyszek");
        Dog stefan2 = new Dog("Stefan");
        dogString.put(romek, "to moj domek");
        dogString.put(stefan1, "zajavka");
        dogString.put(zbyszek, "nowy trend");
        dogString.put(stefan2, "jakos bedzie");


        System.out.println(dogString.get(stefan1));
        System.out.println(dogString.get(stefan2));


//        NA TO TRZEBA BARDZO UWAZAC !!!!!!!!!!!!!!!
//        zemienilismy imie ktore prowadziło do jakos bedzie i nie mamy dostępu do tego value
        stefan1.setName("Stefan1");
        System.out.println(dogString.get(stefan1));
//        zmienilismy imie na stefan które juz wcześniej miało dostęp do value i mozemy wypisac
        stefan1.setName("Stefan");
        System.out.println(dogString.get(stefan1));

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
        }
    }

}
