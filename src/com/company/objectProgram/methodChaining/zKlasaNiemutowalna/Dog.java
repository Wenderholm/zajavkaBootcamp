package com.company.objectProgram.methodChaining.zKlasaNiemutowalna;

public final class Dog {
    private final String name;
    private final int age;
    private final Leg leg;

    public Dog(String name, int age, Leg leg) {
        this.name = name;
        this.age = age;
//   towrzenie nowego biektu na podsawie starego obiektu
// zabezpieczenie przed możliwościa zmiany ilości nóg
        this.leg = new Leg(leg);
    }

    public Dog withName(String name) {
        return new Dog(name, this.age, this.leg);
    }

    public Dog withAge(int age) {
        return new Dog(this.name, age, this.leg);
    }

    public Leg getLeg() {
        return new Leg(leg);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", leg=" + leg +
                '}';
    }
}
