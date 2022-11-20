package com.company._1warsztat.comparator;

public class Cat {
    private Integer id;

    private String name;

    public Cat(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat:" + id + ", " + name;
    }
}
