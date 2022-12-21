package com.company._3warsztat.serializableExercise;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {
    public static final long serialVersionUID = 1L;
// jezeli klasa Car implementuje serializowanie to wszystkie inne klasy też muszą miec implementacje Serializable
//    String i Long w tym przypadku nie mają ponieważ one standardowo implementują Serializable
//    jezeli nie chcemy aby jakaś klasa byłą serializowana to dopisujemy "transient" przy polu.
    private final String name;

    private final Long year;
//pole nie byłoby brane pod uwagę przy serializacji
//    private final transient List<Door> doors;
    private final List<Door> doors;

    private String someNull;

    public Car(String name, Long year, List<Door> doors) {
        this.name = name;
        this.year = year;
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public Long getYear() {
        return year;
    }

    public List<Door> getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", doors=" + doors +
                ", someNull='" + someNull + '\'' +
                '}';
    }
}
