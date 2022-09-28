package com.company.kolekcje.immutableTraining;

import java.util.HashSet;
import java.util.Set;

public final class ImmutableCollection {
    private final Set<String> someSet;

    public ImmutableCollection(String someElement1, String someElement2) {
        Set<String> object = new HashSet<>();
        object.add(someElement1);
        object.add(someElement2);
        this.someSet = object;
    }
// tworzenie kopii setu someSet
    public Set<String> getSomeSet() {
        return new HashSet<>(someSet);
//        return someSet;
    }

    public static void main(String[] args) {
        ImmutableCollection obj = new ImmutableCollection("element1", "element2");
//        działanie na kopii
        System.out.println(obj.getSomeSet());
        obj.getSomeSet().add("element3");
        System.out.println(obj.getSomeSet());

    }
}
