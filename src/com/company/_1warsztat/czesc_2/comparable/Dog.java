package com.company._1warsztat.czesc_2.comparable;

public class Dog implements Comparable<Dog>{

    private final Integer id;

    private final String name;

    public Dog(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Dog:" + id + ", name=" + name;
    }

    @Override
    public int compareTo(Dog o) {
//        sotrowanie rosnaco
//        return this.name.compareTo(o.name);
//        sotrowanie malejąco
        int result = this.name.compareTo(o.name);
        if(result != 0){
            return result;
        }
        return this.id - o.id;
    }
}
