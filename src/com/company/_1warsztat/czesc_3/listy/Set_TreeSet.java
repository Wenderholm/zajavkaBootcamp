package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class Set_TreeSet {
    public static void main(String[] args) {
//        aby posortować TreeSet musi nasz klasa implementowac Comparable
//        musimy zapimplementować metode compareTo
//        albo mozna uzyc comparatora
        TreeSet<Duck> stringSet = new TreeSet<>();
        stringSet.add(new Duck("Donald"));
        stringSet.add(new Duck("Daisy"));
        stringSet.add(new Duck("Donald"));
        stringSet.add(new Duck("Abdacy"));

        System.out.println(stringSet);
    }

    private static class Duck implements Comparable<Duck>  {
        private String name;

        public Duck(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
//      TU METODA EQUALS I HASHCODE NIE DZIAŁAJA
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Duck duck = (Duck) o;
//            return Objects.equals(name, duck.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name);
//        }

        @Override
        public String toString() {
            return "Duck: " + name;
        }
//
        @Override
        public int compareTo(Duck o) {
            return this.name.compareTo(o.name);
        }
    }

}
