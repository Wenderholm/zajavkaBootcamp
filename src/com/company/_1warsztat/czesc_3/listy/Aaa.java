package com.company._1warsztat.czesc_3.listy;

import java.util.*;

public class Aaa<T> {

    //    T element;
//
//    public Aaa(T element) {
//        this.element = element;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Aaa("oen"));
//        System.out.println(new Aaa(2));
//        System.out.println(new Aaa("three"));
//    }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
    public static void main(String[] args) {

        quiz();
    }


    private static void quiz() {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("one");
        deque.push("two");
        deque.push("three");

        while(deque.pop() != null){
            System.out.println(deque.pop());
        }
    }


//    private static class Dog {
//    }

}
