package com.company.objectProgram.konstruktory;

public class Labrador extends Dog{

    private String name;

    private int age;
    float num;
    int value;
    public Labrador() {
//        odnosi się do konstruktora bez parametrów w klasie Dog
        super();
        System.out.println("Labrador created");
    }

    public void Quiz(){
        value = 4;

    }

    public Labrador(String name) {
//        this() wyświetla defaultowo kostruktor bez parametrow
        this();
        this.name = name;
        System.out.println("labrador with name created");
    }

    public Labrador(int age) {
//        this(Romek) wskazuje na konstruktor Labrador z name
        this("Romek");
        this.age = age;
        System.out.println("labrador with age created");
    }

    public Labrador(String race, String name, int age) {
//        odnosi się do kostruktora z polem race w klasie Dog
        super(race);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Labrador{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
