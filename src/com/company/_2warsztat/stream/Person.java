package com.company._2warsztat.stream;

public class Person implements Comparable<Person> {
    private final String name;

    private final City city;


    public Person(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
