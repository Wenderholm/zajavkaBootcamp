package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class Set_LinkedHashSet {
    public static void main(String[] args) {
        Set<Duck> stringSet = new LinkedHashSet<>();
        stringSet.add(new Duck("Donald"));
        stringSet.add(new Duck("Daisy"));
        stringSet.add(new Duck("Donald"));

        System.out.println(stringSet);

//        istnieje mozliwosc przypisania kolekcji do listy w taki sposób
        List<Duck> stringList = new ArrayList<>(stringSet);
        System.out.println(stringList);

    }

    private static class Duck {
        private String name;

        public Duck(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Duck duck = (Duck) o;
            return Objects.equals(name, duck.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Duck: " + name;
        }
    }
}
