package com.company._1warsztat.projekt_warsztat1;

public class Person {
    private final String name;
    private final String surname;
    private final Integer counter;
    private final Boolean isVip;
    private final String id;

    public Person(String name, String surname, Integer counter) {
        this(name, surname, counter, false);
    }

    public Person(String name, String surname, Integer counter, Boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVip = isVip;
        this.id = generateId();
    }

    private String generateId() {
        return this.isVip ? String.format("%s_%s_%s_VIP", this.name, this.surname, this.counter)
                : String.format("%s_%s_%s", this.name, this.surname, this.counter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return id != null ? id.equals(person.id) : person.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id;
    }
}
