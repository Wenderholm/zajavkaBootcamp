package com.company._1warsztat.czesc_1.zadania_warsztat_1;

import java.util.ArrayList;
import java.util.List;

public class Zadanie6RozwiazanieWlasne {
    public static void main(String[] args) {
        Stack<StackElement> stackGeneric = new Stack<>();
        stackGeneric.add(new Book());
        stackGeneric.add(new Newspaper());
        stackGeneric.add(new Newspaper());
        stackGeneric.add(new Book());
        stackGeneric.add(new Smartphone());

        stackGeneric.get();
        stackGeneric.get();

        System.out.println(stackGeneric);
    }

    interface StackElement {}

    static class Book implements StackElement {
        @Override
        public String toString() {
            return "Book";
        }
    }

    static class Smartphone implements StackElement {
        @Override
        public String toString() {
            return "Smartphone";
        }
    }

    static class Newspaper implements StackElement {
        @Override
        public String toString() {
            return "Newspaper";
        }
    }

    static class Stack<T extends StackElement>{

        List<T> elements = new ArrayList<>();

        public void add(T element){
            elements.add(element);
        }

        public T get(){
            int size = elements.size();
            if(size > 0){
                return elements.remove(size-1);
            }
            return null;
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "elements=" + elements +
                    '}';
        }
    }
}
