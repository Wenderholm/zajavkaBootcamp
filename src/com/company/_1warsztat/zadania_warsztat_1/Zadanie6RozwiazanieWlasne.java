package com.company._1warsztat.zadania_warsztat_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zadanie6RozwiazanieWlasne {
    public static void main(String[] args) {
        Stack<ItemOnTable> stack = new Stack<>();

        stack.add(new Book());
        stack.add(new Laptop());
        stack.add(new Laptop());
        stack.add(new Newspaper());
        stack.add(new Newspaper());
        stack.add(new Book());

        System.out.println(stack);

        stack.take();
        stack.take();

        System.out.println(stack);

    }


    interface ItemOnTable{

    }

    static class Laptop implements ItemOnTable{
        @Override
        public String toString() {
            return "Laptop";
        }
    }

    static class Newspaper implements ItemOnTable{
        @Override
        public String toString() {
            return "Newspaper";
        }
    }

    static class Book implements ItemOnTable{
        @Override
        public String toString() {
            return "Book";
        }
    }

    static class Stack<T extends ItemOnTable>{
        private final List<T> elements = new ArrayList<>();

        public void add(T element){
            elements.add(element);
        }

        public Optional<T> take(){
            int size = elements.size();
            if(size > 0){
                return Optional.ofNullable(elements.remove(size - 1));
            }
            return Optional.empty();
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "elements=" + elements +
                    '}';
        }
    }

}
