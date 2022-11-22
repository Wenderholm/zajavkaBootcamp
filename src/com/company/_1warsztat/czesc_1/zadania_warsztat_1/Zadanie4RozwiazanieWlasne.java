package com.company._1warsztat.czesc_1.zadania_warsztat_1;

import java.util.Arrays;

public class Zadanie4RozwiazanieWlasne {

    public static void main(String[] args) {
        Dog[] dogs = {new Dog(1), new Dog(2), new Dog(3),new Dog(4)};
        Cat[] cats = {new Cat(1), new Cat(2), new Cat(3),new Cat(4)};

        System.out.println(Arrays.toString(dogs));
        swap(dogs, 0,2);
        swap(cats, 0,2);
        swap(dogs, 6,2);
        swap(cats, 6,2);
        swap(dogs, 1,5);
        System.out.println(Arrays.toString(dogs));


    }

    public  static <T> void swap(T[] array, int position1, int position2){

        if(position1 >= array.length){
            System.out.println("index " + position1 + " is to big!!!. id max number: " + (array.length-1));
            return;
        }
        if(position2 >= array.length){
            System.out.println("index " + position2 + " is to big!!!. id max number: " + (array.length-1));
            return;
        }

        T temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;

    }

    public static class Dog{
        private final int id;

        public Dog(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "id=" + id +
                    '}';
        }
    }

    public static class Cat{
        private final int id;

        public Cat(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "id=" + id +
                    '}';
        }
    }

}
