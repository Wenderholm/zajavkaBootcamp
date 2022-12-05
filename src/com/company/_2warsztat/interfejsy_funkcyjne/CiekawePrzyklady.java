package com.company._2warsztat.interfejsy_funkcyjne;

import java.util.*;

public class CiekawePrzyklady {
    public static void main(String[] args) {
        Optional.of("someValue")
//                Functional
                .map(s -> s.length())
//                Predicate
                .filter(x -> x > 5)
//                Consumer
                .ifPresent(toConsume -> System.out.println(toConsume));

        List<String> stringList = new ArrayList<>();
        stringList.removeIf(x -> x.contains("abc"));

        Map<Integer,Cat> someMap = new HashMap<>();
        someMap.put(1,new Cat("zajavka"));
        someMap.put(2,new Cat("zajavka2"));
        someMap.put(3,new Cat("zajavka3"));
        System.out.println(someMap);
        someMap.replaceAll( (key,value) -> new Cat(value.name + "change") );
        System.out.println(someMap);


    }
    static class Cat{
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
