package com.company.staticWord.Zadania.zadanie2;

public class Main {
    public static void main(String[] args) {
        Static one = new Static("one");
        System.out.println("Name is: " + one.getName() + ", counter = " + Static.counter);
        Static two = new Static("two");
        System.out.println("Name is: " + two.getName() + ", counter = " + Static.counter);
        Static three = new Static("three");
        System.out.println("Name is: " + three.getName() + ", counter = " + Static.counter);
        Static four = new Static("four");
        System.out.println("Name is: " + four.getName() + ", counter = " + Static.counter);
        Static five = new Static("five");
        System.out.println("Name is: " + five.getName() + ", counter = " + Static.counter);


    }
}
